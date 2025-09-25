import matplotlib.pyplot as plt
import numpy as np
import matplotlib.animation as animation
import random
from poisson import Poisson

num_poissons = 70
poissons = [Poisson() for _ in range(num_poissons)]
# Choix du leader
leader = random.choice(poissons)
poissons.remove(leader)
list_leaders = [leader]

fig = plt.figure()
ax = fig.add_subplot(projection="3d")

# Segments pour les poissons bleus
segments = [ax.plot([], [], [], lw=1.5, color='blue')[0] for p in poissons]

# Segment rouge pour le leader
leader_segment = [ax.plot([], [], [], lw=2, color='red')[0]]

ax.set(xlim3d=(0, 1), xlabel='X')
ax.set(ylim3d=(0, 1), ylabel='Y')
ax.set(zlim3d=(0, 1), zlabel='Z')

def contamination (list_leaders, leader_segment, segments , poissons):
        nouveaux_leaders = []
        for poisson in poissons:
            for l in list_leaders:
                distance = np.linalg.norm(poisson.position - l.position)
                if distance < 0.10 and poisson not in list_leaders and poisson not in nouveaux_leaders:

                    variation = np.random.uniform(-0.005, -0.001, 3)
                    poisson.vitesse = l.vitesse + variation

                    nouveaux_leaders.append(poisson)
                    break


        for p in nouveaux_leaders:

            index = poissons.index(p)
            segment_bleu = segments.pop(index)
            segment_bleu.remove()
            list_leaders.append(p)
            poissons.remove(p)

            leader_segment.append(ax.plot([], [], [], lw=1.5, color='green')[0])
    

def update(frame, poissons, segments, list_leaders, leader_segment):
    if frame%5==0 : 
        contamination( list_leaders=list_leaders,
                      leader_segment=leader_segment, segments=segments, poissons=poissons)

    for poisson, segment in zip(poissons, segments):
        poisson.update(dt=0.1)
        pos = poisson.position
        direction = poisson.vitesse
        direction = direction / np.linalg.norm(direction) * 0.05
        start = pos - direction / 2
        end = pos + direction / 2
        segment.set_data([start[0], end[0]], [start[1], end[1]])
        segment.set_3d_properties([start[2], end[2]])

    for l, segment in zip(list_leaders, leader_segment):


        l.update(dt=0.1)
        pos = l.position
        direction = l.vitesse
        direction = direction / np.linalg.norm(direction) * 0.05
        start = pos - direction / 2
        end = pos + direction / 2
        segment.set_data([start[0], end[0]], [start[1], end[1]])
        segment.set_3d_properties([start[2], end[2]])
    return segments + leader_segment

ani = animation.FuncAnimation(
    fig, update,
    frames=200,
    fargs=(poissons, segments, list_leaders, leader_segment),
    interval=100,
    blit=False
)

plt.show()
