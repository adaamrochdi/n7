clear;
close all;
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

figure('Name','Estimation des éclairages sans mire','Position',[0.2*L,0,0.8*L,H]);

% Lecture du masque du biface commun a toutes les images :
masque = imread('Images/biface/masque.png')>0;
masque_1D = masque(:);

% Lecture des normales du biface (representees sous forme d'image RGB) :
normales_RGB = imread('Images/biface/normales.png');
normales_XYZ = (2*double(normales_RGB)/255-1).*reshape([1,-1,-1],1,1,3);
normales_2D = reshape(normales_XYZ,length(masque_1D),3);
normales = normales_2D(masque_1D,:);

% Lecture des 105 images du biface :
images = [];
for i = 0:104
	nom_fichier = sprintf('Images/biface/%03d.png',i);
	image = double(imread(nom_fichier))/255;
	image_2D = reshape(image,length(masque_1D),3);
	images = cat(3,images,image_2D(masque_1D,:));
end
[nb_pixels,nb_canaux,nb_images] = size(images);

% Choix de quatre images affichees en guise de verification :
ind_rouges = [1,25,63,98];					% Indices des eclairages selectionnes
ind_bleus = setdiff(1:nb_images,ind_rouges);		% Indices des autres eclairages

% Initialisation des inconnues :
albedos = median(images,3);
eclairages = zeros(nb_images,3);
eclairages(:,3) = -1;					% Initialisation : eclairages frontaux

% Boucle d'estimation conjointe des albedos et des vecteurs d'eclairage :
pas_albedos = 0.4/nb_images;
pas_eclairages = 0.4/nb_pixels;
valeurs_perte = [];
for i = 0:100

	% Mise a jour des albedos et des eclairages :
	albedos = albedos-pas_albedos*gradient_albedos(images,normales,albedos,eclairages);
	eclairages = eclairages-pas_eclairages*gradient_eclairages(images,normales,albedos,eclairages);

	% Affichage des albedos estimes :
	subplot(3,3,1);
	A_estime = zeros(length(masque_1D),nb_canaux);
	A_estime(masque_1D,:,:) = albedos;
	A_estime = reshape(A_estime,[size(masque),nb_canaux]);
	imshow(A_estime);
	title('Albédos estimés','FontSize',20);

	% Affichage des eclairages estimes :
	subplot(3,3,2);
	intensites = vecnorm(eclairages,2,2);
	directions = eclairages./intensites;
	[theta,rho] = cart2pol(directions(:,1),directions(:,2));
	tailles = 60*intensites/max(intensites);
	polarscatter(theta(ind_rouges),rho(ind_rouges),tailles(ind_rouges),...
			'r','filled','DisplayName','Éclairages sélectionnés');
	hold on;
	polarscatter(theta(ind_bleus),rho(ind_bleus),tailles(ind_bleus),...
			'b','filled','DisplayName','Autres éclairages');
	rlim([0,1]);
	set(gca,'FontSize',10);
	hold off;
	title('Éclairages estimés','FontSize',20);

	% Calcul de la perte :
	rendus = Lambert(normales,albedos,eclairages);
	perte = sum((rendus-images).^2,'all');
	valeurs_perte = [valeurs_perte,perte];

	% Evolution de la "fonction de perte" :
	subplot(3,3,3);
	plot(valeurs_perte);
	set(gca,'FontSize',10);
	xlabel('Iterations','FontSize',20);
	ylabel('Perte','FontSize',20);
	title('Descente de gradient','FontSize',20);

	% Affichage des images simulees :
	I_simulees = zeros(length(masque_1D),nb_canaux,nb_images);
	I_simulees(masque_1D,:,:) = rendus;
	I_simulees = reshape(I_simulees,[size(masque),nb_canaux,nb_images]);
	subplot(3,4,5);
	imshow(I_simulees(:,:,:,ind_rouges(1)));
	ylabel('Images simulées','FontSize',20);
	subplot(3,4,6);
	imshow(I_simulees(:,:,:,ind_rouges(2)));
	subplot(3,4,7);
	imshow(I_simulees(:,:,:,ind_rouges(3)));
	subplot(3,4,8);
	imshow(I_simulees(:,:,:,ind_rouges(4)));

	% Affichage des images d'origine :
	I_origine = zeros(length(masque_1D),nb_canaux,nb_images);
	I_origine(masque_1D,:,:) = images;
	I_origine = reshape(I_origine,[size(masque),nb_canaux,nb_images]);
	subplot(3,4,9);
	imshow(I_origine(:,:,:,ind_rouges(1)));
	ylabel('Images d''origine','FontSize',20);
	subplot(3,4,10);
	imshow(I_origine(:,:,:,ind_rouges(2)));
	subplot(3,4,11);
	imshow(I_origine(:,:,:,ind_rouges(3)));
	subplot(3,4,12);
	imshow(I_origine(:,:,:,ind_rouges(4)));

	drawnow;
end

save eclairages_sans_mire eclairages;
