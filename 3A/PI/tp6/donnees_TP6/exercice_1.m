clear;
close all;
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

% Lecture du masque des spheres commun a toutes les images :
masque = imread('Images/spheres/masque.png')>0;
masque_1D = masque(:);

% Lecture des normales des spheres (representees sous la forme d'une image RGB) :
normales_RGB = imread('Images/spheres/normales.png');
normales_XYZ = (2*double(normales_RGB)/255-1).*reshape([1,-1,-1],1,1,3);
normales_2D = reshape(normales_XYZ,length(masque_1D),3);
normales = normales_2D(masque_1D,:);

% Affichage des normales en representation RGB :
figure('Name','Donnees','Position',[0,0,0.4*L,H]);
subplot(2,1,2);
imagesc(normales_RGB);
axis equal;
axis off;
grid off;
title('Normales','FontSize',20);

% Lecture des 105 images de spheres :
images = [];
for i = 0:104
	nom_fichier = sprintf('Images/spheres/%03d.png',i);
	image = double(imread(nom_fichier))/255;
	image = rgb2gray(image);
	image_1D = image(:);
	images = cat(2,images,image_1D(masque_1D));
end

% Affichage de la derniere image lue :
subplot(2,1,1);
imagesc(image);
colormap gray;
axis equal;
axis off;
grid off;
title('Une des 105 images','FontSize',20);

% Estimation des directions d'eclairage (coordonnees polaires) et des intensites :
[theta,rho,psi] = estimation_avec_mire(images,normales);

% Affichage des directions d'eclairage en coordonnees polaires :
figure('Name','Directions d''eclairage estimees','Position',[0.4*L,0.2*H,0.6*L,0.8*H]);
polarscatter(theta,rho,60*psi/max(psi),'r','filled');
rlim([0,1]);
set(gca,'FontSize',20);
title('Eclairages estimés','FontSize',20);

% Sauvegarde des eclairages estimes :
[x,y] = pol2cart(theta,rho);
directions = [x ; y ; -sqrt(1-(x.^2+y.^2))];
eclairages = transpose(directions.*repmat(psi,3,1));
save eclairages_avec_mire eclairages;
