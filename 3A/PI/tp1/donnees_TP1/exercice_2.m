clear;
close all;

load donnees_appariees;
load Fontaine/matrice_K;

% Coordonnees homogenes des pixels apparies :
p1_tilde = [p1 ; ones(1,nb_paires)];
p2_tilde = [p2 ; ones(1,nb_paires)];

% Points 3D q :
inverse_K = inv(K);
q1 = inverse_K*p1_tilde;
q2 = inverse_K*p2_tilde;

% Estimation robuste de E :
[tirage_estim,E_estim] = estimation_E_robuste(q1,q2,nb_paires);

% Trace des droites epipolaires passant par les 8 points tires aleatoirement :
p1_tilde_estim = p1_tilde(:,tirage_estim);
p2_tilde_estim = p2_tilde(:,tirage_estim);
F_estim = inverse_K'*E_estim*inverse_K;
trace_epipoles(L,H,p1_tilde_estim,p2_tilde_estim,F_estim,I1,I2);

save E_estim E_estim;
