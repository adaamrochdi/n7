clear;
close all;
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

% Donnees de synthese :
load Donnees_synthese/vase_brillant_22;

% Donnees reelles :
% load Donnees_reelles/visage_27;

[nb_lignes,nb_colonnes] = size(masque);
[n,r] = size(I);

% Correction des images :
I(:,masque) = correction_images(I(:,masque));

% Affichage des images corrigees :
figure('Name','Donnees corrigees','Position',[0,0,0.5*L,0.38*H]);
n_c = min(4,ceil(sqrt(n)));
n_l = min(2,ceil(n/n_c));
for k = 1:n_c*n_l
	Ik = reshape(I(k,:),size(masque));
	subplot(n_l,n_c,k);
	imagesc(Ik);
	axis image;
	axis off;
	title(['$\mathbf{s}_{' num2str(k,'%2d') '}$'],'Interpreter','Latex','FontSize',20);
end
colormap gray;
drawnow;

% Estimation de la carte d'albedo et du champ de normales :
[rho_estime,N_estime] = PS_calibree(I,S);

% Integration du champ de normales :
p_estime = reshape(-N_estime(1,:)./N_estime(3,:),size(masque));
q_estime = reshape(-N_estime(2,:)./N_estime(3,:),size(masque));
p_estime(~masque) = 0;
q_estime(~masque) = 0;
z_estime = integration_SCS(q_estime,p_estime);
z_estime(~masque) = NaN;

% Affichage du modele 3D :
figure('Name','Modele 3D','Position',[0.5*L,0,0.5*L,H]);
rho_estime = reshape(rho_estime,size(masque));
affichage_modele_3D(rho_estime,z_estime);

% Affichage complementaire pour les images de synthese :
if exist('N','var')

	% Calcul de l'ecart angulaire :
	EA = rad2deg(acos(sum(N.*N_estime)));

	% Affichage de l'ecart angulaire :
	figure('Name','Resultat complementaire','Position',[0.25*L,0.66*H,0.25*L,0.38*H]);
	imagesc(reshape(EA,size(masque)),[0 10]);
	title('Ecart angulaire','FontSize',15);
	hc = colorbar;
	colormap(hc,jet);
	axis image;
	axis off;

	% Calcul de l'ecart angulaire moyen :
	interieur = find(masque);			% Interieur du domaine de reconstruction
	EAM = mean(EA(interieur));			% La moyenne doit etre calculee sur l'interieur
	disp(['Ecart angulaire moyen sur les normales : ' num2str(EAM,'%.2f') ' degres']);
end
