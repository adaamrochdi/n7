clear;
close all;

load exercice_1;

% Determination de la "bonne" pose et affichage du resultat :
[t,R,P] = estimation_bonne_pose(t_4,R_4,P_4);
figure('Name','Reconstruction 3D','Position',[0.1*L,0,0.8*L,H]);
affichage_resultat(t,R,P,couleurs_P);
