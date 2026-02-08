clear;
close all;
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

load donnees_appariees;
load E_estim;
load Fontaine/matrice_K;

% Estimation de la pose (4 solutions) :
[t_4,R_4] = estimation_4_poses(E_estim);

% Verification :
verif = zeros(1,4);
for j = 1:4
	t_j = t_4(:,j);
	t_j_matrice = [0 -t_j(3) t_j(2) ; t_j(3) 0 -t_j(1) ; -t_j(2) t_j(1) 0];
	R_j = R_4(:,:,j);
	matrice_verif = (t_j_matrice*R_j)./E_estim;
	verif(j) = abs(abs(prod(matrice_verif(:)))-1) < 1e-2;
end

if ~prod(verif)
	fprintf('Erreur : revoyez votre code, svp !\n');
	return;
end

% Coordonnees homogenes des pixels apparies :
p1_tilde = [p1 ; ones(1,nb_paires)];
p2_tilde = [p2 ; ones(1,nb_paires)];

% Points 3D q :
inverse_K = inv(K);
q1 = inverse_K*p1_tilde;
q2 = inverse_K*p2_tilde;

% Reconstruction 3D correspondant aux 4 solutions :
figure('Name','Reconstruction 3D : 4 solutions','Position',[0.1*L,0,0.8*L,H]);
P_4 = zeros(3,size(p1,2),4);
for j = 1:4
	t_j = t_4(:,j);
	R_j = R_4(:,:,j);
	P_j = reconstruction_3D(q1,q2,t_j,R_j);
	P_4(:,:,j) = P_j;
	affichage_resultat(t_j,R_j,P_j,couleurs_P,j);
end

save exercice_1;
