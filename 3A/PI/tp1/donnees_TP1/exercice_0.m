%% 
clear;
close all;
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

nb_points_affiches = 1000;

% Lecture des images :
I1 = imread('Fontaine/im1.png');
I2 = imread('Fontaine/im2.png');

% Detection des points d'interet :
RI1 = selection_RI(I1,L,H);
p1_interet = detectMinEigenFeatures(rgb2gray(I1),'ROI',RI1,'MinQuality',0.0001);
RI2 = selection_RI(I2,L,H);
p2_interet = detectMinEigenFeatures(rgb2gray(I2),'ROI',RI2,'MinQuality',0.0001);

% Affichage des images et des points d'interet :
close all;
figure('Name','Detection des points d''interet','Position',[0.2*L,0,0.6*L,0.5*H]);
subplot(1,2,1);
imagesc(I1);
title('Points d''interet de l''image gauche','FontSize',20);
axis equal;
axis off;
hold on;
plot(p1_interet.selectStrongest(nb_points_affiches));
subplot(1,2,2);
imagesc(I2);
title('Points d''interet de l''image droite','FontSize',20);
axis equal;
axis off;
hold on;
plot(p2_interet.selectStrongest(nb_points_affiches));

% Mise en correspondance des points d'interet :
traqueur = vision.PointTracker('MaxBidirectionalError',1,'NumPyramidLevels',5);
p1_interet = p1_interet.Location;
initialize(traqueur,p1_interet,I1);
[p2_interet,indices_droite] = step(traqueur,I2);
p1 = p1_interet(indices_droite,:);
p2 = p2_interet(indices_droite,:);
nb_paires = size(p1,1);

% Affichage des appariements :
figure('Name','Paires de points d''interet');
pas = max(floor(nb_paires/nb_points_affiches),1);
showMatchedFeatures(I1,I2,p1(1:pas:end,:),p2(1:pas:end,:));

% Transposition de p1 et p2 pour coller aux notations du cours :
p1 = transpose(p1);
p2 = transpose(p2);

% La couleur d'un point 3D est sa couleur dans l'image gauche :
[nb_lignes,nb_colonnes,nb_canaux] = size(I1);
nb_pixels = nb_lignes*nb_colonnes;
couleurs = reshape(I1,[nb_pixels,nb_canaux]);
j_p1 = round(p1(1,:));					% u correspond à j
i_p1 = round(p1(2,:));					% v correspond à i
indices_couleurs = sub2ind([nb_lignes,nb_colonnes],i_p1,j_p1);
couleurs_P = couleurs(indices_couleurs,:);

save donnees_appariees;
