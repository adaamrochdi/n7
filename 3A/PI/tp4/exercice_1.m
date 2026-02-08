clear;
close all;
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

% Lecture et affichage de l'image :
I = imread('Donnees/image_Beethoven.png');
pas_decimation = 2;
I = I(1:pas_decimation:end,1:pas_decimation:end,:);		% Decimation de l'image
I_max = 255;
I = double(rgb2gray(I))/I_max;					% Reels compris entre 0 et 1
figure('Name','Resolution iterative du SfS','Position',[0,0,0.5*L,0.7*H]);
subplot(2,2,1);
imagesc(I);
axis equal;
axis off;
colormap gray;
title('Image','Interpreter','Latex','Fontsize',30);

% Le niveau de gris est tronque pour eviter les divisions par 0 :
I = max(I,0.1);

% Lecture et affichage du masque :
masque = imread('Donnees/masque_Beethoven.png');
masque = masque(1:pas_decimation:end,1:pas_decimation:end);	% Decimation du masque
masque = masque>0;
subplot(2,2,2);
imagesc(masque);
axis equal;
axis off;
colormap gray;
hold on;
title('Masque','Interpreter','Latex','Fontsize',30);
drawnow;

% Initialisation de la solution :
z = zeros(size(I)); 

% Schema iteratif :
nb_iterations_max = 500;
epsilon = 1e-6;
k = 1;
convergence = 0;
while k<=nb_iterations_max & ~convergence

	% Sauvegarde de l'iteration courante :
	z_k_moins_1 = z;

	% Pas de l'iteration :
	z = lax_friedrichs(z_k_moins_1,I,masque);
	
	% Affichage du resultat courant :
	relief_et_image(z,k);
	pause(0.001);
	
	% Test de convergence :
	if norm(z_k_moins_1(masque)-z(masque))./norm(z(masque))<epsilon
		convergence = 1;
	end
	k = k+1;
end

% Simulation d'un eclairage tournant :
figure('Name','Reeclairage du relief reconstruit','Position',[0.5*L,0,0.5*L,0.7*H]);
reeclairage(z);
