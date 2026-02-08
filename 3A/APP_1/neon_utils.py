import os
import json
import cv2
import numpy as np
import pandas as pd

class NeonDataHandler:
    def __init__(self, recording_dir):
        self.rec_dir = recording_dir
        self.calibration_path = os.path.join(recording_dir, 'scene_camera.json')
        self.gaze_path = os.path.join(recording_dir, 'gaze.csv')
        self.world_ts_path = os.path.join(recording_dir, 'world_timestamps.csv')
        self.video_path = os.path.join(recording_dir, 'video_clip.mp4')
        
        self.K, self.D = self._load_intrinsics()
        self.matched_data = self._load_and_sync_data()
        
        self.dim = (1600, 1200)
        self.new_K, self.roi = cv2.getOptimalNewCameraMatrix(
            self.K, self.D, self.dim, 1, self.dim
        )

    def _load_intrinsics(self):
        if not os.path.exists(self.calibration_path):
            raise FileNotFoundError(f"Fichier introuvable : {self.calibration_path}")
        with open(self.calibration_path, 'r') as f:
            data = json.load(f)
        K = np.array(data['camera_matrix'])
        D = np.array(data['distortion_coefficients'])
        return K, D

    def _load_and_sync_data(self):
        print("Chargement des CSV...")
        gaze_df = pd.read_csv(self.gaze_path)
        world_ts_df = pd.read_csv(self.world_ts_path)
        
        gaze_df = gaze_df.sort_values('timestamp [ns]')
        world_ts_df = world_ts_df.sort_values('timestamp [ns]')
        
        print("Synchronisation...")
        merged_df = pd.merge_asof(
            world_ts_df,
            gaze_df,
            on='timestamp [ns]',
            direction='nearest',
            tolerance=50000000 
        )
        return merged_df.dropna(subset=['gaze x [px]', 'gaze y [px]'])

    def undistort_frame(self, frame):
        return cv2.undistort(frame, self.K, self.D, None, self.new_K)

    def undistort_gaze_point(self, gaze_x, gaze_y):
        src_pt = np.array([[[gaze_x, gaze_y]]], dtype=np.float32)
        dst_pt = cv2.undistortPoints(src_pt, self.K, self.D, P=self.new_K)
        return dst_pt[0][0] # Retourne (x, y) directement