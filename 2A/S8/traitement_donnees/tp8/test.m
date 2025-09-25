clear;
close all;

%% === Lecture des deux images ===
structure_img = im2double(imread('structure3.png'));   % image contenant la structure
texture_img = im2double(imread('texture3.png'));       % image contenant la texture

%% === Redimensionnement si nécessaire ===
if ~isequal(size(structure_img), size(texture_img))
    texture_img = imresize(texture_img, [size(structure_img,1), size(structure_img,2)]);
end

%% === Fusion ===
% Option 1 : fusion directe
% fusion = structure_img + texture_img;

% Option 2 : pondération (facultatif)
alpha = 0.45; beta = 0.8;
fusion = alpha * structure_img + beta * texture_img;

% Clip pour rester entre 0 et 1
fusion = max(0, min(1, fusion));

%% === Affichage ===
figure;
subplot(1,3,1); imshow(structure_img); title('Structure');
subplot(1,3,2); imshow(texture_img); title('Texture');
subplot(1,3,3); imshow(fusion); title('Fusion');

%% === Sauvegarde ===
imwrite(im2uint8(fusion), 'fusion_resultat3.png');
