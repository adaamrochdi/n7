import numpy as np

class Poisson:
    def __init__(self):
        self.position = np.random.rand(3)
        self.vitesse = np.random.uniform(-0.15, 0.15, 3)

    def update(self, dt=1):
        self.position += self.vitesse * dt
        for i in range(3):
            if self.position[i] < 0 or self.position[i] > 1:
                self.vitesse[i] *= -1
                self.position[i] = np.clip(self.position[i], 0, 1)
