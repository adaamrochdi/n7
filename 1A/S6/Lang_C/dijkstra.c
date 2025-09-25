#include "dijkstra.h"
#include <stdlib.h>
 
/**
 * construire_chemin_vers - Construit le chemin depuis le noeud de départ donné vers le
 * noeud donné. On passe un chemin en entrée-sortie de la fonction, qui est mis à jour
 * par celle-ci.
 *
 * Le noeud de départ est caractérisé par un prédécesseur qui vaut NO_ID.
 *
 * Ce sous-programme fonctionne récursivement :
 *  1. Si le noeud a pour précédent NO_ID, on a fini (c'est le noeud de départ, le chemin de
 *     départ à départ se compose du simple noeud départ)
 *  2. Sinon, on construit le chemin du départ au noeud précédent (appel récursif)
 *  3. Dans tous les cas, on ajoute le noeud au chemin, avec les caractéristiques associées dans visites
 *
 * @param chemin [in/out] chemin dans lequel enregistrer les étapes depuis le départ vers noeud
 * @param visites [in] liste des noeuds visités créée par l'algorithme de Dijkstra
 * @param noeud noeud vers lequel on veut construire le chemin depuis le départ
 */
void construire_chemin_vers(liste_noeud_t** chemin, liste_noeud_t* visites, noeud_id_t noeud){
 
    if (precedent_noeud_liste(visites, noeud) == NO_ID) {
        *chemin = creer_liste();
        inserer_noeud_liste(*chemin, noeud, NO_ID, 0.0);
    } else {
        noeud_id_t n_prec = precedent_noeud_liste(visites, noeud);
 
        construire_chemin_vers(chemin,visites,n_prec);
 
        double distance = distance_noeud_liste(visites, noeud); 
        inserer_noeud_liste(*chemin, noeud, n_prec, distance);
    }
}
 
 
float dijkstra(
    const struct graphe_t* graphe, 
    noeud_id_t source, noeud_id_t destination, 
    liste_noeud_t** chemin) {
 
    liste_noeud_t* AVisiter = creer_liste(); 
    liste_noeud_t* Visites = creer_liste(); 
    inserer_noeud_liste(AVisiter,  source, NO_ID, 0.0);
    while (!est_vide_liste(AVisiter)){
        noeud_id_t n_c = min_noeud_liste(AVisiter);
        inserer_noeud_liste(Visites, n_c, precedent_noeud_liste(AVisiter, n_c), distance_noeud_liste(AVisiter, n_c));
        supprimer_noeud_liste(AVisiter, n_c);
        int nb = (int)nombre_voisins(graphe, n_c);
        noeud_id_t* voisins = (noeud_id_t*)malloc(nb * sizeof(noeud_id_t));
        noeuds_voisins(graphe, n_c, voisins);
        for (int i=0 ; i<nb ; i++){
            noeud_id_t n_v = voisins[i];
            if (!contient_noeud_liste(Visites, n_v)){
                //D-2.4.1
                float delta_nv = distance_noeud_liste(Visites, n_c) + noeud_distance(graphe, n_c, n_v);
                //D-2.4.2
                float delta = distance_noeud_liste(AVisiter, n_v);
                //D-2.4.3
                if (delta_nv < delta) {
                    if (contient_noeud_liste(AVisiter, n_v)) {
                        changer_noeud_liste(AVisiter, n_v, n_c, delta_nv);
                    } else {
                        inserer_noeud_liste(AVisiter, n_v, n_c, delta_nv);
                    }
                }
            }
        }
        free(voisins);
 
    }
 
    if (chemin != NULL){
         construire_chemin_vers(chemin, Visites, destination);
 
    }  
 
    float distance = (float)distance_noeud_liste(Visites, destination);
    detruire_liste(&AVisiter);
    detruire_liste(&Visites);
    return distance;
}
