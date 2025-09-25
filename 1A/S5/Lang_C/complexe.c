#include "complexe.h"
#include <math.h>

 
 
// Fonctions reelle et imaginaire
double reelle(complexe_t complexe){
    return complexe.real;
}
 
double imaginaire(complexe_t complexe){
    return complexe.im;
}
 
// Procédures set_reelle, set_imaginaire et init
void set_reelle(complexe_t* complexe, double real){
    complexe->real = real;
}
 
void set_imaginaire(complexe_t* complexe, double im){
    complexe->im = im;
}
 
void init(complexe_t* complexe, double real, double im){
    complexe->real = real;
    complexe->im = im;
}
 
// Procédure copie
void copie(complexe_t* resultat, complexe_t autre){
    resultat->real = autre.real;
    resultat->im = autre.im;
}
 
// Algèbre des nombres complexes
void conjugue(complexe_t* resultat, complexe_t op){
    resultat->real = op.real;
    resultat->im = -op.im;
}
 
void ajouter(complexe_t* resultat, complexe_t gauche, complexe_t droite){
    resultat->real = gauche.real + droite.real ;
    resultat->im = gauche.im + droite.im ;
}
 
void soustraire(complexe_t* resultat, complexe_t gauche, complexe_t droite){
    resultat->real = gauche.real - droite.real ;
    resultat->im = gauche.im - droite.im ;
}
 
void multiplier(complexe_t* resultat, complexe_t gauche, complexe_t droite){
    resultat->real = gauche.real * droite.real - gauche.im * droite.im;
    resultat->im = gauche.real * droite.im + gauche.im * droite.real;
}
 
void echelle(complexe_t* resultat, complexe_t op, double facteur){
    resultat->real = op.real*facteur;
    resultat->im = op.im*facteur;
}
 
void puissance(complexe_t* resultat, complexe_t op, int exposant){
    for (int i = 1; i <= exposant; i++){
        multiplier(resultat, *resultat, op);
    }
}
 
// Module et argument
double module_carre(complexe_t complexe){
    return ((complexe.real * complexe.real)+(complexe.im * complexe.im));
}
 
double module(complexe_t complexe){
    return sqrt(module_carre(complexe));
}
 
double argument(complexe_t complexe){
    double a = complexe.real;
    double b = complexe.im;
    if (a > 0) {
        return atan(b / a);
    } else if (a < 0) {
        if (b < 0){
            return (atan(b / a) - M_PI);
        } else if (b > 0) {
            return (atan(b / a) + M_PI);
        } else {
            return M_PI ;
        }
    } else {
        if (b < 0){
            return 3.0 * M_PI / 2.0;
        } else if (b > 0) {
            return M_PI / 2.0 ;
        } else {
            return 0.0 ;
        }
    }
}
