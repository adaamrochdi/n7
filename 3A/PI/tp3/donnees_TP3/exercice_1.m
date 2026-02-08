clear;
close all;
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

load lapin;

% Choix et affichage d'une image de reference :
ind_ref = 1;
I_ref = I(:,:,ind_ref);
figure('Name','Image de reference','Position',[0.3*L,0.45*H,0.35*L,0.55*H]);
imagesc(I_ref);
colormap gray;
axis equal;
axis off;
hold on;

% Affichage des images temoins :
ind_tem = 1:size(I,3);
ind_tem(ind_ref) = [];
figure('Name','Images temoins','Position',[0.65*L,0.45*H,0.35*L,0.55*H]);
I_tem = I(:,:,ind_tem);
nb_tem = length(ind_tem);
nb_col = ceil(nb_tem/2);
for k = 1:nb_tem
	subplot(2,nb_col,k);
	imagesc(I_tem(:,:,k));
	colormap gray;
	axis equal;
	axis off;
	hold on;
end

% Choix d'un point de l'image de reference :
figure(1);
disp('Cliquez sur un point de l''image de reference');
[u_ref,v_ref] = ginput(1);				% Coordonnees dans le repere pixels
plot(u_ref,v_ref,'xr','MarkerSize',10,'LineWidth',5);
if M(round(v_ref),round(u_ref),ind_ref)==0
	disp('Ce point est en dehors du masque !');
	return;
end

% Reprojections dans les n images temoins :
R_ref = R(:,:,ind_ref);
t_ref = t(:,ind_ref);
M_tem = M(:,:,ind_tem);
R_tem = R(:,:,ind_tem);
t_tem = t(:,ind_tem);
valeurs_z = 1.5:0.002:2.5;
[reprojections,erreurs] = calcul_argument(I_ref,R_ref,t_ref,I_tem,M_tem,R_tem,t_tem,u_ref,v_ref,K,valeurs_z);
figure(2);
for k = 1:nb_tem
	subplot(2,nb_col,k);
	plot(reprojections(:,1,k),reprojections(:,2,k),'.r','MarkerSize',4,'LineWidth',5);
end

% Trace des erreurs de reprojection en fonction de la profondeur :
figure('Name','Erreurs de reprojection','Position',[0.3*L,0.05*H,0.7*L,0.22*H]);
plot(valeurs_z,erreurs,'r','LineWidth',1);
hold on;
somme_erreurs = sum(erreurs,2);
plot(valeurs_z,somme_erreurs,'g','LineWidth',3);
xlabel('Profondeur','FontSize',20);
ylabel('Erreur','FontSize',20);
axis([ valeurs_z(1) valeurs_z(end) 0 max(somme_erreurs) ]);
