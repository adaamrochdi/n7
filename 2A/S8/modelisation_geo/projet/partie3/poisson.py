import numpy as np

class Poisson:
    def __init__(self):
        self.position = np.random.rand(3)

        direction = np.random.uniform(-1, 1, 3)
        direction /= np.linalg.norm(direction)
        speed = np.random.uniform(0.13, 0.25)
        self.vitesse = direction * speed

    def update(self, dt=1):
        self.position += self.vitesse * dt
        for i in range(3):
            if self.position[i] < 0 or self.position[i] > 1:
                self.vitesse[i] *= -1
                self.position[i] = np.clip(self.position[i], 0, 1)
