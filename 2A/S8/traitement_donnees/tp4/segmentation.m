% Lecture de l'image
img = imread('bateau_test.jpg'); % Remplace par le nom de ton image
img = im2double(img);          % Convertir en double pour traitement

% Dimensions de l'image
[nrows, ncols, nchannels] = size(img);

% Mise en forme des données : chaque pixel devient une ligne
pixels = reshape(img, nrows * ncols, nchannels);  % matrice N x 3 (R,G,B)

% Choisir le nombre de clusters (segments)
k = 3;  % Tu peux modifier ce nombre

% Appliquer K-means
[idx, C] = kmeans(pixels, k, 'Distance', 'sqEuclidean', 'Replicates', 3);

% Remplacer chaque pixel par son centroïde (valeur moyenne du cluster)
segmented_pixels = C(idx, :);

% Reformater l'image segmentée à sa taille d'origine
segmented_img = reshape(segmented_pixels, nrows, ncols, nchannels);


imshow(segmented_img);
title(sprintf('Image segmentée (k = %d)', k));

% Sauvegarde de l’image segmentée
imwrite(segmented_img, sprintf('segmentation_k%d.png', k));

