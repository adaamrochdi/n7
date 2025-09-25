#include "complexe.h"
#include "mandelbrot.h"
 
int mandelbrot(complexe_t z0, complexe_t c, double seuil, int maxit) {
    complexe_t zn = z0;
    int nbr_iterations = 0;
 
    while (module_carre(zn) <= seuil && nbr_iterations <= maxit) {
        // Calculer z(n+1) = z(n)**2 + c
        multiplier(&zn, zn, zn);
        ajouter(&zn, zn, c);
        nbr_iterations++;
    }
 
    return nbr_iterations;
}
