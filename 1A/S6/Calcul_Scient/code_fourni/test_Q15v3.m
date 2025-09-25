close all;
clear all;
format long;
%% Variation de nombre d'itération en fonction de p :
%%%%%%%%%%%%
% PARAMÈTRES
%%%%%%%%%%%%

% Création d'une cellule pour stocker les temps d'exécution pour chaque type de matrice
temps_IMAT = cell(1, 4);

% Valeur de p fixée
p = 3;

for imat = 1:4
    
    % Initialisation des temps pour cette valeur de imat
    temps_IMAT{imat} = [];
    
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
        
        % Génération de la matrice pour chaque taille n et type imat
        [A, D, ~] = matgen_csad(imat, n);
    
        % Temps de calcul
        t_v = cputime;
        
        % Calcul des valeurs propres nécessaires avec subspace_iter_v3
        [W, V, n_ev, it, itv, flag] = subspace_iter_v3(A, m, percentage, p, eps, maxit);
        
        % Temps de calcul
        t_v = cputime - t_v;
        
        % Enregistrement du temps de calcul
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
title("Variation du temps de traitement en fonction de la taille de la matrice ");
