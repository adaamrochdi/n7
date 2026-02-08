import cv2
import numpy as np

class MultiPosterMapper:
    def __init__(self):
        self.sift = cv2.SIFT_create()
        # Configuration du matcher 
        index_params = dict(algorithm=1, trees=5)
        search_params = dict(checks=50)
        self.flann = cv2.FlannBasedMatcher(index_params, search_params)
        
        # Liste pour stocker les cibles 
        self.targets = []

    def add_poster(self, name, image_path):
        """Ajoute un poster à la liste des cibles connues."""
        img = cv2.imread(image_path)
        if img is None:
            print(f"ERREUR : Impossible de charger l'image {image_path}")
            return
            
        # Calcul des features une seule fois au démarrage
        kp, des = self.sift.detectAndCompute(img, None)
        h, w = img.shape[:2]
        
        self.targets.append({
            "name": name,
            "kp": kp,
            "des": des,
            "size": (w, h) # Largeur, Hauteur
        })
        print(f"Cible chargée : {name} ({len(kp)} points clés)")

    def map_on_specific_target(self, frame, gaze_point, target_name):
        """
        Lance SIFT uniquement sur le poster nommé 'target_name'.
        Utilisé après que YOLO ait identifié quel poster est regardé.
        """
        # 1. Retrouver les données du poster cible
        target = next((t for t in self.targets if t["name"] == target_name), None)
        
        if target is None:
            # Le nom renvoyé par YOLO n'est pas dans notre liste de posters chargés
            return None

        # 2. Analyse SIFT de la frame vidéo actuelle
        kp_frame, des_frame = self.sift.detectAndCompute(frame, None)
        
        if des_frame is None or len(kp_frame) < 4:
            return None

        # 3. Matching (Comparaison avec la cible unique)
        matches = self.flann.knnMatch(target["des"], des_frame, k=2)
        
        good_matches = []
        for m, n in matches:
            if m.distance < 0.7 * n.distance:
                good_matches.append(m)

        # 4. Calcul de l'Homographie
        if len(good_matches) > 10:
            src_pts = np.float32([target["kp"][m.queryIdx].pt for m in good_matches]).reshape(-1, 1, 2)
            dst_pts = np.float32([kp_frame[m.trainIdx].pt for m in good_matches]).reshape(-1, 1, 2)
            
            # RANSAC pour éliminer les erreurs
            H, mask = cv2.findHomography(src_pts, dst_pts, cv2.RANSAC, 5.0)
            
            if H is not None:
                try:
                    # 5. Projection du regard (Inverse de H)
                    # On passe du repère Vidéo au repère Poster
                    H_inv = np.linalg.inv(H)
                    
                    gaze_vec = np.array([[[gaze_point[0], gaze_point[1]]]], dtype=np.float32)
                    mapped_pt = cv2.perspectiveTransform(gaze_vec, H_inv)
                    pt = mapped_pt[0][0]
                    
                    w, h = target["size"]
                    
                    # 6. Vérification finale : le point est-il DANS le poster ?
                    if (0 <= pt[0] < w) and (0 <= pt[1] < h):
                        return pt # Succès : retourne (x, y) sur le poster
                        
                except np.linalg.LinAlgError:
                    return None
                    
        return None