import cv2
import os
import numpy as np
from tqdm import tqdm
from ultralytics import YOLO

# Import des modules locaux
from neon_utils import NeonDataHandler
from multi_mapper_yolo import MultiPosterMapper
from gaze_mapper import generate_heatmap

# --- CONFIGURATION ---
DATA_DIR = "data01"
VIDEO_FILE = "video_clip.mp4" 
YOLO_MODEL_PATH = "model/best.pt" 

FRAME_SKIP = 7

POSTERS_DICT = {
    "Mary": "images/Anning.png",
    "Ben": "images/Barres.png",
    "Bell": "images/Bell.png",
    "Danielle": "images/Bunten-Berry.png",
    "Franklin": "images/Franklin.png",
    "Gautier": "images/Gautier.png",
    "Katherine": "images/Johnson.png",
    "Emmy": "images/Noether.png"
}
# ---------------------

def main():
    # 1. Vérifications initiales
    video_path = os.path.join(DATA_DIR, VIDEO_FILE)
    if not os.path.exists(video_path):
        print(f"ERREUR CRITIQUE: Vidéo introuvable -> {video_path}")
        return
    
    if not os.path.exists(YOLO_MODEL_PATH):
        print(f"ERREUR CRITIQUE: Modèle YOLO introuvable -> {YOLO_MODEL_PATH}")
        return

    # 2. Chargement du modèle YOLO
    print(">>> Chargement du modèle YOLO...")
    model = YOLO(YOLO_MODEL_PATH)
    
    # 3. Initialisation Neon
    print(">>> Chargement des données Pupil Neon...")
    try:
        data_handler = NeonDataHandler(DATA_DIR)
    except Exception as e:
        print(f"Erreur NeonDataHandler: {e}")
        return

    # 4. Initialisation du Multi-Mapper
    print(">>> Chargement de la galerie de posters...")
    mapper = MultiPosterMapper()
    for name, path in POSTERS_DICT.items():
        if os.path.exists(path):
            mapper.add_poster(name, path)

    # 5. Boucle de Traitement Vidéo
    cap = cv2.VideoCapture(video_path)
    total_frames = int(cap.get(cv2.CAP_PROP_FRAME_COUNT))
    
    results_data = {name: [] for name in POSTERS_DICT.keys()}
    
    print(f">>> Lancement du pipeline Hybride sur {total_frames} frames (Skip={FRAME_SKIP})...")
    
    current_frame_idx = 0
    pbar = tqdm(total=total_frames)

    while cap.isOpened():
        ret, frame = cap.read()
        if not ret:
            break

        # --- OPTIMISATION : FRAME SKIPPING (LE BON ENDROIT EST ICI) ---
        # On incrémente le compteur
        current_frame_idx += 1
        pbar.update(1)

        # Si ce n'est pas une frame multiple de 5, on passe à la suivante DIRECTEMENT
        # On ne fait NI undistort, NI yolo, NI sift.
        if current_frame_idx % FRAME_SKIP != 0:
            continue
        # -------------------------------------------------------------

        # Récupération de la donnée regard (attention au décalage d'index)
        # Comme current_frame_idx commence à 1 maintenant, on ajuste -1 pour l'index array
        idx_for_data = current_frame_idx - 1 
        
        if idx_for_data < len(data_handler.matched_data):
            row = data_handler.matched_data.iloc[idx_for_data]
        else:
            row = None

        if row is not None:
            # A. Correction Optique
            frame_undist = data_handler.undistort_frame(frame)
            gaze_raw = data_handler.undistort_gaze_point(row['gaze x [px]'], row['gaze y [px]'])
            gx, gy = gaze_raw[0], gaze_raw[1]

            # B. Inférence YOLO
            yolo_results = model(frame_undist, verbose=False, conf=0.5)
            
            detected_poster_name = None
            
            # C. Intersection
            for r in yolo_results:
                boxes = r.boxes
                for box in boxes:
                    x1, y1, x2, y2 = box.xyxy[0].cpu().numpy()
                    
                    if x1 < gx < x2 and y1 < gy < y2:
                        cls_id = int(box.cls[0])
                        label = model.names[cls_id]
                        if label in POSTERS_DICT:
                            detected_poster_name = label
                            cv2.rectangle(frame_undist, (int(x1), int(y1)), (int(x2), int(y2)), (255, 0, 0), 2)
                            break 
                if detected_poster_name: break

            # D. Précision SIFT
            if detected_poster_name:
                local_pt = mapper.map_on_specific_target(frame_undist, (gx, gy), detected_poster_name)
                
                if local_pt is not None:
                    results_data[detected_poster_name].append(local_pt)
                    cv2.putText(frame_undist, f"LOCK: {detected_poster_name}", (50, 50), 
                               cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 255, 0), 2)
                else:
                    cv2.putText(frame_undist, f"YOLO: {detected_poster_name}", (50, 50), 
                               cv2.FONT_HERSHEY_SIMPLEX, 1, (0, 165, 255), 2)

            cv2.circle(frame_undist, (int(gx), int(gy)), 8, (0, 0, 255), -1)
            cv2.imshow("Pipeline YOLO -> SIFT", cv2.resize(frame_undist, (800, 600)))
            
            if cv2.waitKey(1) & 0xFF == ord('q'):
                break

    cap.release()
    cv2.destroyAllWindows()
    
    # 6. Génération Heatmaps
    print("\n>>> Génération des rapports...")
    if not os.path.exists("output"):
        os.makedirs("output")

    for name, points in results_data.items():
        if len(points) > 5:
            output_file = f"output/heatmap_{name}.png"
            try:
                generate_heatmap(POSTERS_DICT[name], points, output_file)
                print(f"Ok: {output_file}")
            except Exception as e:
                print(f"Erreur {name}: {e}")

if __name__ == "__main__":
    main()