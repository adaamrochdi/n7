clear;
close all;

% Lecture des images (structure couleur, texture couleur)
u  = im2double(imread('Images/structure.png'));
u2 = im2double(imread("Images/texture.png"));

% Redimensionnement
u2 = imresize(u2, [size(u,1), size(u,2)]);

% Vérification des canaux
if size(u,3) == 1
    u = repmat(u, [1,1,3]);
end
if size(u2,3) == 1
    u2 = repmat(u2, [1,1,3]);
end

[nb_lignes, nb_colonnes, ~] = size(u);

% Grille fréquentielle
[f_x, f_y] = meshgrid(1:nb_colonnes, 1:nb_lignes);
f_x = f_x / nb_colonnes - 0.5;
f_y = f_y / nb_lignes - 0.5;

% Filtre de décomposition
eta = 0.05;
Phi = 1 ./ (1 + (f_x.^2 + f_y.^2) / eta);

% Fusion dans chaque canal
u_mix = zeros(size(u));
for c = 1:3
    s1 = fftshift(fft2(u(:,:,c)));     % structure
    s2 = fftshift(fft2(u2(:,:,c)));    % texture

    s_mix = Phi .* s1 + (1 - Phi) .* s2;
    u_mix(:,:,c) = real(ifft2(ifftshift(s_mix)));
end

% Clipping
u_mix = min(max(u_mix, 0), 1);

% Affichage
figure('Name','Transfert texture RGB');
subplot(1,3,1); imshow(u);    title('Structure (couleur)');
subplot(1,3,2); imshow(u2);   title('Texture (couleur)');
subplot(1,3,3); imshow(u_mix); title('Image recomposée');
