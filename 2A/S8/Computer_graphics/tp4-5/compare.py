# cherche un chemin entre deux nœuds dans un arbre en essayant d’abord de descendre via les enfants,
# puis de remonter via les parents ; si aucun chemin n’est trouvé, elle retourne "Erreur".

def getPath(debut, fin):
    # Cas 1 : chercher de debut vers fin (descente)
    stack = [(debut, [debut])]
    while stack:
        noeudcourant, chemin = stack.pop()
        if noeudcourant == fin:
            return chemin
        for child in noeudcourant.children:
            stack.append((child, chemin + [child]))

    # Cas 2 : remonter de debut vers fin (montée)
    chemin = []
    noeudcourant = debut
    while noeudcourant:
        chemin.append(noeudcourant)
        if noeudcourant == fin:
            return chemin
        noeudcourant = noeudcourant.parent

    return "Erreur"

