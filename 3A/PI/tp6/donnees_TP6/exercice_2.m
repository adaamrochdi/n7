clear;
close all;
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

load eclairages_avec_mire;
%load eclairages_sans_mire;

figure('Name','Ré-estimation des normales par PS calibrée','Position',[0.2*L,0,0.8*L,H]);

% Lecture des normales du zoom du biface (representees sous forme d'image RGB) :
normales_MVS_RGB = imread('Images/biface_zoom/normales.png');
[nb_lignes,nb_colonnes,nb_canaux] = size(normales_MVS_RGB);

% Affichage des normales obtenues par MVS :
subplot(1,2,1);
imshow(normales_MVS_RGB);
title('Normales obtenues par MVS','FontSize',20);
drawnow;

% Lecture des 105 images du zoom du biface :
images = [];
for i = 0:104
	nom_fichier = sprintf('Images/biface_zoom/%03d.png',i);
	image = double(imread(nom_fichier))/255;
	image = rgb2gray(image);
	image_1D = image(:);
	images = cat(2,images,image_1D);
end

% Re-estimation des normales par stereophotometrie :
normales_PS_2D = PS_calibree(images,eclairages);
normales_PS_XYZ = reshape(transpose(normales_PS_2D),nb_lignes,nb_colonnes,3);

% Affichage des normales ré-estimées par PS calibrée :
subplot(1,2,2);
normales_PS_RGB = 0.5*(normales_PS_XYZ.*reshape([1,-1,-1],1,1,3)+1);
imshow(normales_PS_RGB);
title('Normales ré-estimées par PS calibrée','FontSize',20);
