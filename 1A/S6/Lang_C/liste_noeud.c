#define _GNU_SOURCE
#include "liste_noeud.h"
#include <stdlib.h>
#include <math.h>


// Définition d'une structure pour une cellule de la liste
typedef struct cellule {
    noeud_id_t noeud;           // Identifiant du noeud
    float distance;             // Distance du noeud par rapport à l'origine
    noeud_id_t precedent;       // Identifiant du noeud précédent
    struct cellule* suivant;    // Pointeur vers la cellule suivante
} cellule_t;

// Définition d'une structure pour une liste_noeud

struct liste_noeud {
    cellule_t* tete;            // Pointeur vers la première cellule de la liste
};


/**
 * Crée une liste de noeuds vide.
 * @return Un pointeur vers la liste créée, ou NULL en cas d'échec d'allocation.
 */
liste_noeud_t* creer_liste() {
    liste_noeud_t* liste = (liste_noeud_t*)malloc(sizeof(liste_noeud_t));
    if (liste == NULL) {
        return NULL; // Gestion d'erreur, impossible d'allouer la mémoire
    }
    liste->tete = NULL; // Initialise la tête de la liste à NULL
    return liste;
}

/**
 * Détruit la liste et libère la mémoire associée.
 * @param ptr_liste Un double pointeur vers la liste à détruire.
 */
void detruire_liste(liste_noeud_t** ptr_liste) {
    if (ptr_liste == NULL || *ptr_liste == NULL) {
        return; // La liste est déjà NULL ou le pointeur est invalide
    }
    cellule_t* courant = (*ptr_liste)->tete;
    while (courant != NULL) {
        cellule_t* ptr_aux = courant;
        courant = courant->suivant;
        free(ptr_aux); // Libère chaque cellule de la liste
    }
    free(*ptr_liste); // Libère la structure de la liste elle-même
    *ptr_liste = NULL; // Assure que le pointeur externe est mis à NULL
}

/**
 * Teste si la liste est vide.
 * @param liste Un pointeur vers la liste à tester.
 * @return true si la liste est vide, false sinon.
 */
bool est_vide_liste(const liste_noeud_t* liste) {
    return liste == NULL || liste->tete == NULL;
}

/**
 * Vérifie si un noeud spécifique est contenu dans la liste.
 * @param liste Un pointeur vers la liste.
 * @param noeud L'identifiant du noeud à rechercher.
 * @return true si le noeud est trouvé, false sinon.
 */
bool contient_noeud_liste(const liste_noeud_t* liste, noeud_id_t noeud) {
    cellule_t* courant = liste ? liste->tete : NULL;
    while (courant != NULL) {
        if (courant->noeud == noeud) {
            return true;
        }
        courant = courant->suivant;
    }
    return false;
}

/**
 * contient_arrete_liste : vérifie si la liste contient une arête entre deux noeuds spécifiés.
 * @param liste La liste dans laquelle vérifier l'existence de l'arête.
 * @param src Identifiant du noeud source de l'arête.
 * @param tgt Identifiant du noeud cible de l'arête.
 * @return true si l'arête est présente, false sinon.
 */
bool contient_arrete_liste(const liste_noeud_t* liste, noeud_id_t src, noeud_id_t tgt) {
    if (liste == NULL) {
        return false;
    }

    cellule_t* courant = liste->tete;
    while (courant != NULL) {
        if (courant->noeud == tgt && courant->precedent == src) {
            return true;
        }
        courant = courant->suivant;
    }
    return false;
}
/**
 * Récupère la distance associée à un noeud spécifique dans la liste.
 * @param liste Un pointeur vers la liste.
 * @param noeud L'identifiant du noeud pour lequel obtenir la distance.
 * @return La distance du noeud, ou INFINITY si le noeud n'est pas trouvé.
 */
float distance_noeud_liste(const liste_noeud_t* liste, noeud_id_t noeud) {
    if (liste && contient_noeud_liste(liste, noeud)) {
        cellule_t* courant = liste->tete;
        while (courant != NULL) {
            if (courant->noeud == noeud) {
                return courant->distance;
            }
            courant = courant->suivant;
        }
    }
    return INFINITY;
}

/**
 * Récupère l'identifiant du noeud précédent associé à un noeud spécifique dans la liste.
 * @param liste Un pointeur vers la liste.
 * @param noeud L'identifiant du noeud pour lequel obtenir le précédent.
 * @return L'identifiant du noeud précédent, ou NO_ID si le noeud n'est pas trouvé ou n'a pas de précédent.
 */
noeud_id_t precedent_noeud_liste(const liste_noeud_t* liste, noeud_id_t noeud) {
    if (liste && contient_noeud_liste(liste, noeud)) {
        cellule_t* courant = liste->tete;
        while (courant != NULL) {
            if (courant->noeud == noeud) {
                return courant->precedent;
            }
            courant = courant->suivant;
        }
    }
    return NO_ID;
}

/**
 * Trouve le noeud ayant la distance minimale dans la liste.
 * @param liste Un pointeur vers la liste.
 * @return L'identifiant du noeud ayant la distance minimale, ou NO_ID si la liste est vide.
 */
noeud_id_t min_noeud_liste(const liste_noeud_t* liste) {
    if (liste == NULL || liste->tete == NULL) {
        return NO_ID;
    }
    cellule_t* courant = liste->tete;
    float distance_min = courant->distance;
    noeud_id_t noeud_min = courant->noeud;
    while (courant != NULL) {
        if (courant->distance < distance_min) {
            distance_min = courant->distance;
            noeud_min = courant->noeud;
        }
        courant = courant->suivant;
    }
    return noeud_min;
}

/**
 * Insère un nouveau noeud dans la liste.
 * @param liste Un pointeur vers la liste.
 * @param noeud L'identifiant du nouveau noeud.
 * @param precedent L'identifiant du noeud précédent.
 * @param distance La distance du noeud par rapport à l'origine.
 */
void inserer_noeud_liste(liste_noeud_t* liste, noeud_id_t noeud, noeud_id_t precedent, float distance) {
    if (liste == NULL) return;
    cellule_t* nouvelle_cellule = (cellule_t*)malloc(sizeof(cellule_t));
    if (nouvelle_cellule == NULL) return;
    nouvelle_cellule->noeud = noeud;
    nouvelle_cellule->precedent = precedent;
    nouvelle_cellule->distance = distance;
    nouvelle_cellule->suivant = liste->tete;
    liste->tete = nouvelle_cellule;
}

/**
 * Met à jour les informations d'un noeud spécifique dans la liste.
 * @param liste Un pointeur vers la liste.
 * @param noeud L'identifiant du noeud à mettre à jour.
 * @param precedent Le nouvel identifiant de noeud précédent.
 * @param distance La nouvelle distance à mettre à jour.
 */


void changer_noeud_liste(liste_noeud_t* liste, noeud_id_t noeud, noeud_id_t precedent, float distance) {
    if (liste == NULL) return; // Si la liste n'existe pas, on ne fait rien

    cellule_t* courant = liste->tete;
    cellule_t* dernier = NULL; // Garder trace du dernier noeud pour éventuellement ajouter un nouveau noeud

    while (courant != NULL) {
        if (courant->noeud == noeud) {
            courant->precedent = precedent;  // Met à jour le noeud précédent
            courant->distance = distance;    // Met à jour la distance
            return; // Sortie après la mise à jour
        }
        dernier = courant; // Mise à jour du dernier noeud visité
        courant = courant->suivant;
    }

    cellule_t* nouvelle_cellule = (cellule_t*)malloc(sizeof(cellule_t));
    if (nouvelle_cellule == NULL) return; // Gestion d'erreur pour l'allocation

    nouvelle_cellule->noeud = noeud;
    nouvelle_cellule->precedent = precedent;
    nouvelle_cellule->distance = distance;
    nouvelle_cellule->suivant = NULL;

    if (dernier == NULL) { // La liste était initialement vide
        liste->tete = nouvelle_cellule;
    } else {
        dernier->suivant = nouvelle_cellule;
    }
}


/**
 * Supprime un noeud spécifique de la liste.
 * @param liste Un pointeur vers la liste.
 * @param noeud L'identifiant du noeud à supprimer.
 */
void supprimer_noeud_liste(liste_noeud_t* liste, noeud_id_t noeud) {
    if (liste == NULL || liste->tete == NULL) return;
    cellule_t* courant = liste->tete;
    cellule_t* precedent = NULL;
    while (courant != NULL) {
        if (courant->noeud == noeud) {
            if (precedent == NULL) {
                liste->tete = courant->suivant;
            } else {
                precedent->suivant = courant->suivant;
            }
            free(courant);
            return;
        }
        precedent = courant;
        courant = courant->suivant;
    }
}
