#ifndef COMPLEX_H
#define COMPLEX_H
 
// Type utilisateur complexe_t
struct complexe_t{
    double real;
    double im;
};
 
typedef struct complexe_t complexe_t;
 
// Fonctions reelle et imaginaire
/**
 * reelle
 *
 * renvoie la partie réelle d'un complexe
 *
 * Paramètres :
 *   complexe       [in out] Complexe dans lequel chercher la partie réelle
 */
double reelle(complexe_t complexe);
 
/**
 * imaginaire
 *
 * renvoie la partie imaginaire d'un complexe
 *
 * Paramètres :
 *   complexe       [in out] Complexe dans lequel chercher la partie imaginaire
 */
 
double imaginaire(complexe_t complexe);
 
// Procédures set_reelle, set_imaginaire et init
/**
 * set_reelle
 *
 * modifie la partie réelle d'un complexe
 *
 * Paramètres :
 *   complexe       [in out] Complexe dans lequel il faut modifier la partie réelle
 *   real           [in] Réel à mettre dans complexe
 *
 * Post-conditions : la partie réelle de complexe est real
 */
 
void set_reelle(complexe_t* complexe, double real);
 
/**
 * set_imaginaire
 *
 * modifie la partie imaginaire d'un complexe
 *
 * Paramètres :
 *   complexe       [in out] Complexe dans lequel il faut modifier la partie imaginaire
 *   im             [in] Imaginaire à mettre dans complexe
 *
 * Post-conditions : la partie imaginaire de complexe est im
 */
 
void set_imaginaire(complexe_t* complexe, double im);
 
/**
 * init
 *
 * modifie la partie réelle et imaginaire d'un complexe
 *
 * Paramètres :
 *   complexe       [in out] Complexe qu'il faut modifier
 *   real           [in] Réel à mettre dans complexe
 *   im             [in] Imaginaire à mettre dans complexe
 *
 * Post-conditions : la partie réelle de complexe est real et la partie imaginaire de complexe est im
 */
/** PROCÉDURE À DÉCLARER **/
void init(complexe_t* complexe, double real, double im);
 
// Procédure copie
/**
 * copie
 * Copie les composantes du complexe donné en second argument dans celles du premier
 * argument
 *
 * Paramètres :
 *   resultat       [out] Complexe dans lequel copier les composantes
 *   autre          [in]  Complexe à copier
 *
 * Pré-conditions : resultat non null
 * Post-conditions : resultat et autre ont les mêmes composantes
 */
void copie(complexe_t* resultat, complexe_t autre);
 
// Algèbre des nombres complexes
/**
 * conjugue
 * Calcule le conjugué du nombre complexe op et le sotocke dans resultat.
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   op             [in]  Complexe dont on veut le conjugué
 *
 * Pré-conditions : resultat non-null
 * Post-conditions : reelle(*resultat) = reelle(op), complexe(*resultat) = - complexe(op)
 */
void conjugue(complexe_t* resultat, complexe_t op);
 
/**
 * ajouter
 * Réalise l'addition des deux nombres complexes gauche et droite et stocke le résultat
 * dans resultat.
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   gauche         [in]  Opérande gauche
 *   droite         [in]  Opérande droite
 *
 * Pré-conditions : resultat non-null
 * Post-conditions : *resultat = gauche + droite
 */
void ajouter(complexe_t* resultat, complexe_t gauche, complexe_t droite);
 
/**
 * soustraire
 * Réalise la soustraction des deux nombres complexes gauche et droite et stocke le résultat
 * dans resultat.
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   gauche         [in]  Opérande gauche
 *   droite         [in]  Opérande droite
 *
 * Pré-conditions : resultat non-null
 * Post-conditions : *resultat = gauche - droite
 */
void soustraire(complexe_t* resultat, complexe_t gauche, complexe_t droite);
 
/**pi en c
 * multiplier
 * Réalise le produit des deux nombres complexes gauche et droite et stocke le résultat
 * dans resultat.
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   gauche         [in]  Opérande gauche
 *   droite         [in]  Opérande droite
 *
 * Pré-conditions : resultat non-null
 * Post-conditions : *resultat = gauche * droite
 */
void multiplier(complexe_t* resultat, complexe_t gauche, complexe_t droite);
 
/**
 * echelle
 * Calcule la mise à l'échelle d'un nombre complexe avec le nombre réel donné (multiplication
 * de op par le facteur réel facteur).
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   op             [in]  Complexe à mettre à l'échelle
 *   facteur        [in]  Nombre réel à multiplier
 *
 * Pré-conditions : resultat non-null
 * Post-conditions : *resultat = op * facteur
 */
void echelle(complexe_t* resultat, complexe_t op, double facteur);
 
/**
 * puissance
 * Calcule la puissance entière du complexe donné et stocke le résultat dans resultat.
 *
 * Paramètres :
 *   resultat       [out] Résultat de l'opération
 *   op             [in]  Complexe dont on veut la puissance
 *   exposant       [in]  Exposant de la puissance
 *
 * Pré-conditions : resultat non-null, exposant >= 0
 * Post-conditions : *resultat = op * op * ... * op
 *                                 { n fois }
 */
void puissance(complexe_t* resultat, complexe_t op, int exposant);
 
// Module et argument
/**
 * module_carre
 *
 * calcule le module au carré d'un complexe
 *
 * Paramètres :
 *   complexe       [in out] Complexe dont on veut le module au carré
 */
/** FONCTION À DÉCLARER **/
double module_carre(complexe_t complexe);
 
/**
 * module
 *
 * calcule le module d'un complexe
 *
 * Paramètres :
 *   complexe       [in out] Complexe dont on veut le module
 */
/** FONCTION À DÉCLARER **/
double module(complexe_t complexe);
 
/**
 * argument
 *
  * calcule l'argument d'un complexe
 *
 * Paramètres :
 *   complexe       [in out] Complexe dont on veut l'argument
 */
/** FONCTION À DÉCLARER **/
double argument(complexe_t complexe);
 
#endif // COMPLEXE_H
 
