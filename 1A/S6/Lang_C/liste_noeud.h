#ifndef LISTE_NOEUD_H
#define LISTE_NOEUD_H


#include "graphe.h"
#include <stdbool.h>

typedef struct liste_noeud liste_noeud_t;

/**
 * creer_liste : crée une liste de noeuds, initialement vide
 */
liste_noeud_t* creer_liste();

/**
 * detruire_liste : détruit la liste passée en paramètre
 */
void detruire_liste(liste_noeud_t** liste_ptr);

/**
 * est_vide_liste : test si la liste passée en paramètre est vide
 */
bool est_vide_liste(const liste_noeud_t* liste);

/**
 * contient_noeud_test : vérifie si la liste contient un noeud
*/
bool contient_noeud_liste(const liste_noeud_t* liste, noeud_id_t noeud);

bool contient_arrete_liste(const liste_noeud_t* liste, noeud_id_t src, noeud_id_t tgt);

/**
 * distance_noeud_liste : récupère la distance associée au noeud donné dans la liste donnée.
 */
float distance_noeud_liste(const liste_noeud_t* liste, noeud_id_t noeud);

/**
 * precedent_noeud_liste : récupère le noeud précédent associé au noeud donné dans la liste donnée.
 */
noeud_id_t precedent_noeud_liste(const liste_noeud_t* liste, noeud_id_t noeud);

/**
 * min_noeud_liste : trouve le (un) noeud de la liste dont la distance associée est la plus petite,
 * ou renvoie `NO_ID` si la liste est vide.
 */
noeud_id_t min_noeud_liste(const liste_noeud_t* liste);

/**
 * inserer_noeud_liste : insère le noeud donné dans la liste
 */
void inserer_noeud_liste(liste_noeud_t* liste, noeud_id_t noeud, noeud_id_t precedent, float distance);

/**
 * changer_noeud_liste : modifie les valeurs associées au noeud donné dans la liste donnée.
 */
void changer_noeud_liste(liste_noeud_t* liste, noeud_id_t noeud, noeud_id_t precedent, float distance);

/**
 * supprimer_noeud_liste : supprime le noeud donné de la liste.
 */
void supprimer_noeud_liste(liste_noeud_t* liste, noeud_id_t noeud);


#endif
