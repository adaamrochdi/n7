clear;
close all;
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

% Lecture et affichage de l'image :
I = imread('Donnees/Lena.png');
pas_decimation = 4;
% I = imread('Donnees/cerf.png');
% pas_decimation = 2;
I = I(1:pas_decimation:end,1:pas_decimation:end,:);		% Decimation de l'image
I_max = 255;
I = double(rgb2gray(I))/I_max;					% Reels compris entre 0 et 1
figure('Name','Image oÄfastriginale','Position',[0,0,0.5*L,0.7*H]);
imagesc(I);
axis equal;
axis off;
colormap gray;
drawnow;

% Le niveau de gris est tronque pour eviter les divisions par 0 :
I = max(I,0.1);

% Indices absolus des paires de pixels voisins :
[nb_lignes,nb_colonnes] = size(I);
nb_pixels = nb_lignes*nb_colonnes;
ind_pixels = reshape(1:nb_pixels,nb_lignes,nb_colonnes);
[voisins,distances] = voisinage(ind_pixels);

% Interpretation du niveau de gris comme une pente (equation eikonale) :
pente = sqrt(1./I.^2-1);
pente_moyenne = 0.5*(pente(voisins(:,1))+pente(voisins(:,2)));

% Variation de profondeur entre pixels voisins :
delta_z = pente_moyenne.*distances;

% Symetrisation des paires de pixels voisins :
voisins = [voisins ; flip(voisins,2)];
delta_z = [delta_z ; delta_z];

% Matrice creuse decrivant le systeme de voisinage des "8 plus proches voisins" :
M_voisins = sparse(voisins(:,1),voisins(:,2),1,nb_pixels,nb_pixels);

% Matrice creuse contenant les variations de profondeur entre pixels voisins :
M_delta_z = sparse(voisins(:,1),voisins(:,2),delta_z,nb_pixels,nb_pixels);


%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
% Algorithme du fast marching %
%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

% Initialisation des vecteurs "calcules" et "proches" :
calcules = true(nb_lignes,nb_colonnes);
autres = ~calcules;
calcules(2:end-1,2:end-1) = false;
proches = ~calcules;
indices_classe_P = find(proches);
for ind_p = indices_classe_P'
	voisins_p = find(M_voisins(:,ind_p));		% Indices des voisins de p
	voisins_p = voisins_p(calcules(voisins_p));	% Indices des voisins de p appartenant a C
	if ~length(voisins_p)
		autres(ind_p) = true;
	end
end
proches = proches & ~autres;
calcules = calcules(:);
proches = proches(:);

% Affichage du front initial :
front = zeros(nb_lignes,nb_colonnes);			% La troisieme classe est initialisee a 0
front(proches) = 1;
front(calcules) = 0;
figure('Name','Front d''onde du fast marching','Position',[0.5*L,0,0.5*L,0.7*H]);
imshow(front,'InitialMagnification','fit');
drawnow;

% Initialisation de z :
z = zeros(nb_lignes,nb_colonnes);

% Calcul de la profondeur en chaque pixel de P (equation (10)) :
indices_classe_P = find(proches);
for ind_p = indices_classe_P'
	voisins_p = find(M_voisins(:,ind_p));		% Indices des voisins de p
	voisins_p = voisins_p(calcules(voisins_p));	% Indices des voisins de p appartenant a C
	z(ind_p) = min(z(voisins_p)+M_delta_z(voisins_p,ind_p));
end

% Boucle du fast marching :
z = fast_marching(calcules,proches,front,M_voisins,M_delta_z,z);

% Affichage du resultat :
close(2);
figure('Name','Reeclairage du relief reconstruit','Position',[0.5*L,0,0.5*L,0.7*H]);
z = reshape(z,nb_lignes,nb_colonnes);
reeclairage(z);
