close all;
clear all;
format long;
%% Variation de nombre d'itération en fonction de p :
%%%%%%%%%%%%
% PARAMÈTRES
%%%%%%%%%%%%

% type de la matrice (voir matgen_csad)
% imat == 1 valeurs propres D(i) = i
% imat == 2 valeurs propres D(i) = random(1/cond, 1) avec leur logarithmes
%                                  uniformément répartie, cond = 1e10
% imat == 3 valeurs propres D(i) = cond**(-(i-1)/(n-1)) avec cond = 1e5
% imat == 4 valeurs propres D(i) = 1 - ((i-1)/(n-1))*(1 - 1/cond) avec cond = 1e2

% Création d'une cellule pour stocker les temps d'exécution pour chaque type de matrice
temps_IMAT = cell(1, 4);

for imat = 1:4
    
    % Initialisation des temps pour cette valeur de imat
    temps_IMAT{imat} = [];
    
    % on génère la matrice (1) ou on lit dans un fichier (0)
    % si vous avez déjà généré la matrice d'une certaine taille et d'un type donné
    % vous pouvez mettre cette valeur à 0
    genere = 1;
    
    % tolérance
    eps = 1e-8;
    % nombre d'itérations max pour atteindre la convergence
    maxit = 10000;
    % nombre maximum de couples propres calculés
    m = 20;
    percentage = 0.4;
    
    % Génération d'une matrice rectangulaire aléatoire symétrique définie
    % positive A de taille (n x n)
    % A matrice
    % D ses valeurs propres
    fprintf('\n******* création des matrices ******\n');
    for n = 100:100:500 

        [A, D, ~] = matgen_csad(imat, n);
    
        t_v = cputime;
        [ W, V, it, flag ] = subspace_iter_v0( A, m, eps, maxit);
        t_v = cputime - t_v;
        temps_IMAT{imat}(end+1) = t_v;
    end

 
    % Afficher
    figure(1);
    plot(100:100:500, temps_IMAT{imat}, '-');
    hold on;

end

% Légende de la courbe
xlabel('Taille de la matrice (n)');
ylabel("Temps de traitement (s)");
legend('Mat1','Mat2','Mat3','Mat4');
title("Variation du temps de traitement en fonction de la taille de la matrice");
