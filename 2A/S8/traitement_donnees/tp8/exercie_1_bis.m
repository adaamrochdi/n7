clear;
close all;

% Lecture de l'image couleur :
u = im2double(imread('Images/texture.png'));
[nb_lignes, nb_colonnes, nb_canal] = size(u);

eta = 0.001;

% Création du masque de fréquence (2D, commun à tous les canaux)
[f_x,f_y] = meshgrid(1:nb_colonnes,1:nb_lignes);
f_x = f_x/nb_colonnes - 0.5;
f_y = f_y/nb_lignes - 0.5;
poids = 1 ./ (1 + (f_x.^2 + f_y.^2) / eta);

% Initialisation
u_bar = zeros(size(u));
s = zeros(size(u));
s_bar = zeros(size(u));

% Application du filtre canal par canal
for c = 1:nb_canal
    s(:,:,c) = fftshift(fft2(u(:,:,c)));
    s_bar(:,:,c) = s(:,:,c) .* poids;
    u_bar(:,:,c) = real(ifft2(ifftshift(s_bar(:,:,c))));
end

% Affichage
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);
figure('Name','Décomposition spectrale douce','Position',[0.2*L,0,0.8*L,H]);

subplot(2,3,1); imshow(u); title('Image originale');
subplot(2,3,2); imshow(u_bar); title('Image filtrée');
subplot(2,3,3); imshow(u - u_bar); title('Image complémentaire');

imwrite(im2uint8(u - u_bar), 'texture1.png');

subplot(2,3,4); imshow(log(1 + abs(s(:,:,1))),[]); title('Spectre R');
subplot(2,3,5); imshow(log(1 + abs(s_bar(:,:,1))),[]); title('Spectre filtré R');
subplot(2,3,6); imshow(log(1 + abs(s(:,:,1) - s_bar(:,:,1))),[]); title('Spectre complémentaire R');
