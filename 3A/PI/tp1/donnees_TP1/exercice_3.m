clear;
close all;

load donnees_appariees;
load E_estim;
load Fontaine/matrice_K;
load Fontaine/R_solution;

% Coordonnees homogenes des pixels apparies :
p1_tilde = [p1 ; ones(1,nb_paires)];
p2_tilde = [p2 ; ones(1,nb_paires)];

% Points 3D q :
inverse_K = inv(K);
q1 = inverse_K*p1_tilde;
q2 = inverse_K*p2_tilde;

% Estimation de la translation :
t_estim = estimation_t(E_estim,R_solution);

% Calcul des points 3D reconstruits :
P = reconstruction_3D(q1,q2,t_estim,R_solution);

% Affichage du resultat :
figure('Name','Reconstruction 3D','Position',[0.1*L,0,0.8*L,H]);
affichage_resultat(t_estim,R_solution,P,couleurs_P);
