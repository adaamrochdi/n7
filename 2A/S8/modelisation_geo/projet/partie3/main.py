import matplotlib.pyplot as plt
import numpy as np
import matplotlib.animation as animation
from scipy.spatial import KDTree
from poisson import Poisson

num_poissons = 130
poissons = [Poisson() for _ in range(num_poissons)]

fig = plt.figure()
ax = fig.add_subplot(projection="3d")

segments = [ax.plot([], [], [], lw=1.5, color='blue')[0] for _ in poissons]

ax.set(xlim3d=(0, 1), xlabel='X')
ax.set(ylim3d=(0, 1), ylabel='Y')
ax.set(zlim3d=(0, 1), zlabel='Z')

def comportement_aoki(poissons):
    positions = np.array([p.position for p in poissons])
    tree = KDTree(positions)

    R_repulsion = 0.07
    R_alignment = 0.15
    R_attraction = 0.2
    k_repulsion = 0.05
    k_alignment = 0.1
    k_attraction = 0.05

    for i, poisson in enumerate(poissons):
        indices = tree.query_ball_point(poisson.position, r=R_attraction)
        F_repulsion = np.zeros(3)
        F_alignment = np.zeros(3)
        F_attraction = np.zeros(3)
        nb_align = 0

        for j in indices:
            if i == j:
                continue
            voisin = poissons[j]
            dist = np.linalg.norm(poisson.position - voisin.position)
            direction = voisin.position - poisson.position
            norme_direction = np.linalg.norm(direction)
            direction_normalisee = direction / (norme_direction + 1e-6)

            if dist < R_repulsion:
                F_repulsion -= direction_normalisee

            elif dist < R_alignment:
                F_alignment += voisin.vitesse
                nb_align += 1

            else:
                F_attraction += direction_normalisee


        if nb_align > 0:
            F_alignment = (F_alignment / nb_align)
        
        poisson.vitesse += (k_repulsion * F_repulsion + 
                           k_alignment * (F_alignment - poisson.vitesse) +
                           k_attraction * F_attraction)

        
        V = 0.1
        norm = np.linalg.norm(poisson.vitesse)
        if norm != 0:
            poisson.vitesse = V * poisson.vitesse / norm



 

def update(frame, poissons, segments):
    comportement_aoki(poissons)

    for poisson, segment in zip(poissons, segments):
        poisson.update(dt=0.1)
        pos = poisson.position
        direction = poisson.vitesse
        direction = direction / np.linalg.norm(direction) * 0.05
        start = pos - direction / 2
        end = pos + direction / 2
        segment.set_data([start[0], end[0]], [start[1], end[1]])
        segment.set_3d_properties([start[2], end[2]])

    return segments


ani = animation.FuncAnimation(
    fig, update,
    frames=200,
    fargs=(poissons, segments),
    interval=100,
    blit=False
)

plt.show()
