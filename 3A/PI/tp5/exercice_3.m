clear;
close all;
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

% Donnees de synthese :
% load Donnees_synthese/vase_brillant_22;

% Donnees reelles :
% load Donnees_reelles/sphere_8;
load Donnees_reelles/visage_27;
% load Donnees_reelles/Buddha_10;

[nb_lignes,nb_colonnes] = size(masque);
[n,r] = size(I);

% Affichage des images :
figure('Name','Donnees','Position',[0,0,0.5*L,0.38*H]);
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

% Correction des images :
I(:,masque) = correction_images(I(:,masque));

% Estimation de la carte d'albedo et du champ de normales :
[rho_estime,N_estime] = PS_non_calibree(I,masque);

% Integration du champ de normales :
p_estime = reshape(-N_estime(1,:)./N_estime(3,:),size(masque));
q_estime = reshape(N_estime(2,:)./N_estime(3,:),size(masque));
p_estime(~masque) = 0;
q_estime(~masque) = 0;
z_estime = integration_SCS(q_estime,p_estime);
if z_estime(floor(nb_lignes/2),floor(nb_colonnes/2))<z_estime(1,1)
	z_estime = -z_estime;			% Ambiguite concave/convexe
end
z_estime(~masque) = NaN;

% Affichage du modele 3D :
figure('Name','Modele 3D','Position',[0.5*L,0,0.5*L,H]);
rho_estime = reshape(rho_estime,size(masque));
affichage_modele_3D(rho_estime,z_estime);
