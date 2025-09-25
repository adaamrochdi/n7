clear;
close all;
% % Nombre d'images utilisees
nb_images = 36; 

% chargement des images
for i = 1:nb_images
    if i<=10
        nom = sprintf('images/viff.00%d.ppm',i-1);
    else
        nom = sprintf('images/viff.0%d.ppm',i-1);
    end;
    % im est une matrice de dimension 4 qui contient 
    % l'ensemble des images couleur de taille : nb_lignes x nb_colonnes x nb_canaux 
    % im est donc de dimension nb_lignes x nb_colonnes x nb_canaux x nb_images
    im(:,:,:,i) = imread(nom); 
end;

% Affichage des images
figure; 
subplot(2,2,1); imshow(im(:,:,:,1)); title('Image 1');
subplot(2,2,2); imshow(im(:,:,:,9)); title('Image 9');
subplot(2,2,3); imshow(im(:,:,:,17)); title('Image 17');
subplot(2,2,4); imshow(im(:,:,:,25)); title('Image 25');

% %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% A COMPLETER                                             %
% Calculs des superpixels                                 % 
% Conseil : afficher les germes + les régions             %
% à chaque étape / à chaque itération                     %
% %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
I = im(:,:,:,1); 
I_lab = rgb2lab(I); 

nb_superpixels =150;  
m = 10;  
iter_max = 50;  
epsilon = 10;

[centres, etiquettes] = SLIC(I_lab, nb_superpixels, m, iter_max, epsilon);
% Affichage final avec les frontières et les germes
figure;
bords = boundarymask(etiquettes);
imshow(labeloverlay(I, bords));
title(sprintf('Résultat final: %d superpixels ', nb_superpixels));
drawnow;


I_segmentee=segmenter(I,centres,etiquettes);
drawnow;

% ........................................................%
% 
% 
% %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% A COMPLETER                                             %
% Binarisation de l'image à partir des superpixels        %
% %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
I_binaire1=binariser(etiquettes,centres,125);
figure;
imshow(I_binaire1);
drawnow;


[centres, etiquettes] = kmeans(I, 2, iter_max, epsilon);

[~, dino_class] = max(centres(:,1));  

img_binaire = etiquettes == dino_class;
I_binaire = imfill(img_binaire, 'holes');
I_binaire = bwareaopen(I_binaire, 50);  
imshow(I_binaire);
title('Binairisation');
drawnow;
% Affichage des résultats
% ........................................................%
% 

I_contour = tracer_contour(I_binaire);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% A FAIRE SI VOUS UTILISEZ LES MASQUES BINAIRES FOURNIS   %
% Chargement des masques binaires                         %
% de taille nb_lignes x nb_colonnes x nb_images           %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% ... 

nb_images = 36; % Nombre d'images

% chargement des images
for i = 1:nb_images
    if i<=10
        nom = sprintf('images/viff.00%d.ppm',i-1);
    else
        nom = sprintf('images/viff.0%d.ppm',i-1);
    end;
    % L'ensemble des images de taille : nb_lignes x nb_colonnes x nb_canaux
    % x nb_images
    im(:,:,:,i) = imread(nom); 
end;
% chargement des masques (pour l'elimination des fonds bleus)
% de taille nb_lignes x nb_colonnes x nb_images
load mask;
fprintf('Chargement des donnees termine\n');

% Affichage des images
figure; 
subplot(2,2,1); imshow(im(:,:,:,1)); title('Image 1');
subplot(2,2,2); imshow(im(:,:,:,9)); title('Image 9');
subplot(2,2,3); imshow(im(:,:,:,17)); title('Image 17');
subplot(2,2,4); imshow(im(:,:,:,25)); title('Image 25');

% Affichage des masques associes
figure;
subplot(2,2,1); imshow(im_mask(:,:,1)); title('Masque image 1');
subplot(2,2,2); imshow(im_mask(:,:,9)); title('Masque image 9');
subplot(2,2,3); imshow(im_mask(:,:,17)); title('Masque image 17');
subplot(2,2,4); imshow(im_mask(:,:,25)); title('Masque image 25');

figure;
masque = ~im_mask(:,:,1); 
imshow(masque);
I_contour = tracer_contour(masque);

[fx, fy] = filtrage_squelette(I_contour, masque);  
% Construire la matrice d'adjacence originale
[A, pts] = construire_matrice_adjacence(fx, fy);

% Afficher l'axe médian original
figure; 
imshow(masque); 
hold on;
gplot(A, pts, '-b');
title('Axe médian original');

% Calculer les rayons pour chaque point du squelette
rayons = calculer_rayons(pts, I_contour);

% Appliquer Scale Axis Transform avec un facteur d'échelle
facteur_echelle = 1.15;  % Vous pouvez ajuster ce paramètre
[A_filtre, pts_filtre, idx_keep] = appliquer_SAT(A, pts, rayons, facteur_echelle);

% Afficher l'axe médian filtré
figure; 
imshow(masque); 
hold on;
gplot(A_filtre, pts_filtre, '-b');
title(['Axe médian filtré (SAT avec facteur ', num2str(facteur_echelle), ')']);

% Visualiser l'axe médian avec les cercles inscrits
rayons_filtres = calculer_rayons(pts_filtre, I_contour);
visualiser_cercles_axe_median(masque, pts_filtre, rayons_filtres);

% Afficher l'axe médian filtré superposé avec les cercles
figure;
imshow(masque);
hold on;
gplot(A_filtre, pts_filtre, '-b');
theta = linspace(0, 2*pi, 100);
for i = 1:size(pts_filtre, 1)
    x = pts_filtre(i, 1) + rayons_filtres(i) * cos(theta);
    y = pts_filtre(i, 2) + rayons_filtres(i) * sin(theta);
    plot(x, y, 'r-', 'LineWidth', 0.5);
end
title('Axe médian filtré avec cercles inscrits');


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% A DECOMMENTER ET COMPLETER                              %
% quand vous aurez les images segmentées                  %
% Affichage des masques associes                          %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% figure;
subplot(2,2,1); ... ; title('Masque image 1');
subplot(2,2,2); ... ; title('Masque image 9');
subplot(2,2,3); ... ; title('Masque image 17');
subplot(2,2,4); ... ; title('Masque image 25');

% chargement des points 2D suivis 
% pts de taille nb_points x (2 x nb_images)
% sur chaque ligne de pts 
% tous les appariements possibles pour un point 3D donne
% on affiche les coordonnees (xi,yi) de Pi dans les colonnes 2i-1 et 2i
% tout le reste vaut -1
pts = load('viff.xy');
% Chargement des matrices de projection
% Chaque P{i} contient la matrice de projection associee a l'image i 
% RAPPEL : P{i} est de taille 3 x 4
load dino_Ps;

% Reconstruction des points 3D
X = []; % Contient les coordonnees des points en 3D
color = []; % Contient la couleur associee
% Pour chaque couple de points apparies
for i = 1:size(pts,1)
    % Recuperation des ensembles de points apparies
    l = find(pts(i,1:2:end)~=-1);
    % Verification qu'il existe bien des points apparies dans cette image
    if size(l,2) > 1 & max(l)-min(l) > 1 & max(l)-min(l) < 36
        A = [];
        R = 0;
        G = 0;
        B = 0;
        % Pour chaque point recupere, calcul des coordonnees en 3D
        for j = l
            A = [A;P{j}(1,:)-pts(i,(j-1)*2+1)*P{j}(3,:);
            P{j}(2,:)-pts(i,(j-1)*2+2)*P{j}(3,:)];
            R = R + double(im(int16(pts(i,(j-1)*2+1)),int16(pts(i,(j-1)*2+2)),1,j));
            G = G + double(im(int16(pts(i,(j-1)*2+1)),int16(pts(i,(j-1)*2+2)),2,j));
            B = B + double(im(int16(pts(i,(j-1)*2+1)),int16(pts(i,(j-1)*2+2)),3,j));
        end;
        [U,S,V] = svd(A);
        X = [X V(:,end)/V(end,end)];
        color = [color [R/size(l,2);G/size(l,2);B/size(l,2)]];
    end;
end;
fprintf('Calcul des points 3D termine : %d points trouves. \n',size(X,2));

%affichage du nuage de points 3D
figure;
hold on;
for i = 1:size(X,2)
    plot3(X(1,i),X(2,i),X(3,i),'.','col',color(:,i)/255);
end;
axis equal;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% A COMPLETER                  %
% Tetraedrisation de Delaunay  %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

T = DelaunayTri(X(1,:)',X(2,:)', X(3,:)') ;                  

% A DECOMMENTER POUR AFFICHER LE MAILLAGE
fprintf('Tetraedrisation terminee : %d tetraedres trouves. \n',size(T,1));
%Affichage de la tetraedrisation de Delaunay
figure;
tetramesh(T);

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% A DECOMMENTER ET A COMPLETER %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Calcul des barycentres de chacun des tetraedres
% Calcul des barycentres de chacun des tetraedres
% Calcul des barycentres de chacun des tetraedres
poids = [ 1 1 1 1 ; 4 1 1 1 ; 1 4 1 1 ; 1 1 4 1 ; 1 1 1 4 ];
nb_barycentres = size(poids,1);

for i = 1:size(T,1)
    Ti = T(i,:); 
    Pi = T.X(Ti,:);

    %Calcul des barycentres differents en fonction des poids differents
    %En commencant par le barycentre avec poids uniformes

    for k=1:nb_barycentres
        
        poids_k = poids(k, :);
        somme_poids = sum(poids_k);
        coords_ponderes = Pi.*poids(k,:)' ;

        C_g(:,i,k) = [sum(coords_ponderes,1)/somme_poids,1]';
    end
end

% A DECOMMENTER POUR VERIFICATION 
% A RE-COMMENTER UNE FOIS LA VERIFICATION FAITE
% Visualisation pour vérifier le bon calcul des barycentres
% for i = 1:nb_images
%    for k = 1:nb_barycentres
%        o = P{i}*C_g(:,:,k);
%        o = o./repmat(o(3,:),3,1);
%        imshow(im_mask(:,:,i));
%        hold on;
%        plot(o(2,:),o(1,:),'rx');
%        pause;
%        close;
%    end
% end

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% A DECOMMENTER ET A COMPLETER %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Copie de la triangulation pour pouvoir supprimer des tetraedres
% Pour chaque barycentre
tri = T.Triangulation;

remov_ind = [];
[row,col] = size(im_mask(:,:,1));

for k=1:nb_barycentres
  for i = 1:nb_images
        o = P{i}*C_g(:,:,k);
        o = o./repmat(o(3,:),3,1);

        for j  = 1:size(o,2)
            u=o(1,j);
            v=o(2,j);
            if ~ismember(j,remov_ind)
                if (u  <= row && u>=1)&&((u  <= col && u>=1))
                    if im_mask(round(u),round(v),i) == 1
                         remov_ind = [remov_ind, j];
                    end
                end
            end
        end

  end
end
remov_ind = unique(remov_ind);
tri(remov_ind,:)  = [];

% A DECOMMENTER POUR AFFICHER LE MAILLAGE RESULTAT
% Affichage des tetraedres restants
fprintf('Retrait des tetraedres exterieurs a la forme 3D termine : %d tetraedres restants. \n',size(tri,1));
figure;
trisurf(tri,X(1,:),X(2,:),X(3,:));

% Sauvegarde des donnees
save donnees;

%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% CONSEIL : A METTRE DANS UN AUTRE SCRIPT %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% load donnees;
% Calcul des faces du maillage à garder
% FACES = ...;
% ...

% fprintf('Calcul du maillage final termine : %d faces. \n',size(FACES,1));

% Affichage du maillage final
% figure;
% hold on
% for i = 1:size(FACES,1)
%    plot3([X(1,FACES(i,1)) X(1,FACES(i,2))],[X(2,FACES(i,1)) X(2,FACES(i,2))],[X(3,FACES(i,1)) X(3,FACES(i,2))],'r');
%    plot3([X(1,FACES(i,1)) X(1,FACES(i,3))],[X(2,FACES(i,1)) X(2,FACES(i,3))],[X(3,FACES(i,1)) X(3,FACES(i,3))],'r');
%    plot3([X(1,FACES(i,3)) X(1,FACES(i,2))],[X(2,FACES(i,3)) X(2,FACES(i,2))],[X(3,FACES(i,3)) X(3,FACES(i,2))],'r');
% end;
