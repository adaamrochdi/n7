close all;
clear all;
format long;
%% Variation de nombre d'itération en fonction de p :
%%%%%%%%%%%%
% PARAMÈTRES
%%%%%%%%%%%%

% Création d'une cellule pour stocker les temps d'exécution pour chaque type de matrice
temps_IMAT = cell(1, 4);

% Vecteur de valeurs de n à tester
n_values = 100:100:500;

for imat = 1:4
    
    % Initialisation des temps pour cette valeur de imat
    temps_IMAT{imat} = [];
    
    % tolérance
    eps = 1e-8;
    % nombre d'itérations max pour atteindre la convergence
    maxit = 10000;
    
    % Génération d'une matrice rectangulaire aléatoire symétrique définie
    % positive A de taille (n x n)
    % A matrice
    % D ses valeurs propres
    fprintf('\n******* création des matrices ******\n');
    for n = n_values
        
        % Génération de la matrice pour chaque valeur de n et type imat
        [A, ~, ~] = matgen_csad(imat, n);
    
        % Temps de calcul
        t_v = cputime;
        
        % Calcul des valeurs propres avec la fonction eig
        eig(A);
        
        % Temps de calcul
        t_v = cputime - t_v;
        
        % Enregistrement du temps de calcul
        temps_IMAT{imat}(end+1) = t_v;
    end

 
    % Afficher
    figure(1);
    plot(n_values, temps_IMAT{imat}, '-');
    hold on;

end

% Légende de la courbe
xlabel('Taille de la matrice (n)');
ylabel("Temps de traitement (s)");
legend('Mat1','Mat2','Mat3','Mat4');
title("Variation du temps de traitement en fonction de la taille");
s