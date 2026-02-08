clear;
close all;
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

load lapin;
echelle = 1;

% Redimensionnement des images et des masques :
nb_images = size(I,3);
if echelle~=1
	K = echelle*K;
	K(3,3) = 1;
	for k = 1:nb_images
		I_redim(:,:,k) = imresize(I(:,:,k),echelle);
		M_redim(:,:,k) = imresize(M(:,:,k),echelle);
	end
	I = I_redim;
	M = M_redim;
	clear I_redim M_redim;
end
I = double(I)/255;
M = M>0;

% Choix et affichage de l'image de reference :
ind_ref = 1;
I_ref = I(:,:,ind_ref);
figure('Name','Image de reference','Position',[0.3*L,0.45*H,0.35*L,0.55*H]);
imagesc(I_ref);
colormap gray;
axis equal;
axis off;
drawnow;

% Vectorisation de l'image de reference :
I_ref = I(:,:,ind_ref);
[nb_lignes,nb_colonnes] = size(I_ref);
nb_pixels = nb_lignes*nb_colonnes;
I_ref_9 = pretraitement(I_ref);
I_ref_vect = reshape(I_ref_9,nb_pixels,9);

% Erosion du masque de l'image de reference (pour tenir compte des fenetres 3 x 3) :
M_ref = M(:,:,ind_ref);
M_ref_9 = pretraitement(M_ref);
M_ref = sum(M_ref_9,3);
M_ref = M_ref>=9;

% Vectorisation des images temoins :
ind_tem = 1:size(I,3);
ind_tem(ind_ref) = [];
I_tem = I(:,:,ind_tem);
n = length(ind_tem);
I_tem_vect = zeros(nb_pixels,9,n);
for k = 1:n
	I_tem_9 = pretraitement(I_tem(:,:,k));
	I_tem_vect(:,:,k) = reshape(I_tem_9,[nb_pixels,9]);
end

% Resolution du probleme (9) :
R_ref = R(:,:,ind_ref);
t_ref = t(:,ind_ref);
M_tem = M(:,:,ind_tem);
R_tem = R(:,:,ind_tem);
t_tem = t(:,ind_tem);
valeurs_z = 1.5:0.002:2.5;
z = MVS(I_ref_vect,M_ref,R_ref,t_ref,I_tem_vect,M_tem,R_tem,t_tem,K,valeurs_z);

% Affichage du resultat :
figure('Name','Reconstruction 3D','Position',[0.65*L,0.45*H,0.35*L,0.55*H]);
M_ref = M(:,:,ind_ref);
affichage_MVS(M_ref,K,z);