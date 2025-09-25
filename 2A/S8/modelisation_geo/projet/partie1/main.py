import matplotlib.pyplot as plt
import numpy as np
import matplotlib.animation as animation
from poisson import Poisson

num_poissons = 150
poissons = [Poisson() for _ in range(num_poissons)]

fig = plt.figure()
ax = fig.add_subplot(projection="3d")

segments = [ax.plot([], [], [], lw=1.5,color='blue')[0] for _ in poissons]

ax.set(xlim3d=(0, 1), xlabel='X')
ax.set(ylim3d=(0, 1), ylabel='Y')
ax.set(zlim3d=(0, 1), zlabel='Z')

def update(frame, poissons, segments):
    for poisson, segment in zip(poissons, segments):
        poisson.update(dt=0.1)
        pos = poisson.position
        direction = poisson.vitesse
        direction = direction / np.linalg.norm(direction) * 0.07  
        start = pos - direction / 2
        end = pos + direction / 2

        xs = [start[0], end[0]]
        ys = [start[1], end[1]]
        zs = [start[2], end[2]]

        segment.set_data(xs, ys)
        segment.set_3d_properties(zs)

    return segments

ani = animation.FuncAnimation(
    fig, update, frames=200, fargs=(poissons, segments), interval=100, blit=False
)

plt.show()
