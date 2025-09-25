clear;
close all;

taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);


% Parametres :
S = 140;
gama = 5;
T_0 =0.1;
lambda_0 = 100;
alpha = 0.99;
R = 7;		% Rayon des disques
Beta = 3;
nb_points_affichage_disque = 30;
increment_angulaire = 2*pi/nb_points_affichage_disque;
theta = 0:increment_angulaire:2*pi;
rose = [253 108 158]/255;
q_max = 50000;
nb_affichages = 1000;
pas_entre_affichages = floor(q_max/nb_affichages);
temps_pause = 0.0001;
 N_test = 1000;
P_test = R*(2*rand(N_test,2)-1);
interieur = (P_test(:,1).^2+P_test(:,2).^2<=R^2);
P_test = P_test(interieur,:);

% Lecture et affichage de l'image :
I = imread('colonie.png');
I = rgb2ycbcr(I);
I = double(I(:,:,1));
[nb_lignes,nb_colonnes] = size(I);
figure('Name',['Detection de  flamants roses'],'Position',[0,0,L,0.58*H]);



liste_q = 0;
I_moyen = [];
I_moyen_config = mean(I_moyen);
liste_I_moyen_config = I_moyen_config;
%Initialisation des données%
lambda = lambda_0 ;
T = T_0;
c = [];
U_i = [];
I_moyen = [];

% Recherche de la configuration optimale :
for q = 1:150
    %                  Implémentation de l'algo                              %

    %Etape 1: Naissance 
   %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    N = poissrnd(lambda);
    new_c = zeros(N,2);
    new_I_moyen = zeros(N,1);
    for i=1:N
        c_i = [nb_colonnes*rand nb_lignes*rand];
        new_I_moyen(i) = calcul_I_mc(I,c_i,R,P_test);
        new_c(i,:) = c_i;
    end
    c = cat(1,c,new_c);
    I_moyen = cat(1,I_moyen,new_I_moyen);

    %Etape 2: Trie du disque 
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    new_U_i = calcul_Uc(gama,S ,new_I_moyen);
    U_i = cat(1,U_i,new_U_i);
    [U_i, index] = sort(U_i,'descend');

    c = c(index ,:);
    I_moyen = I_moyen(index,:);

    % Etape 3: Morts : 
    %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    probas = calcul_Proba(c,U_i,T,lambda,R);
    list_centres_supp = [];

    for i = 1:N
        if rand < probas(i)
            list_centres_supp =[list_centres_supp i];
        end
    end
    c(list_centres_supp , :) = [];
    I_moyen(list_centres_supp) = [];
    U_i(list_centres_supp) = [] ;

    U = calcule_U(Beta,U_i,c,R,P_test);
    

    T = alpha*T;
    lambda = alpha*lambda;


    % Afficahge 

    fprintf('Itération %d | Niveau de gris moyen : %.2f | Température : %.3f | Lambda : %.2f\n', ...
        q, I_moyen_config, T, lambda);
	hold off;
	subplot(1,2,1);
	imagesc(I);
	axis image;
	axis off;
	colormap gray;
	hold on;
    
     for j = 1:size(c,1)
	        x_affich = c(j,1)+R*cos(theta);
	        y_affich = c(j,2)+R*sin(theta);
	        indices = find(x_affich>0 & x_affich<nb_colonnes & y_affich>0 & y_affich<nb_lignes);
	        plot(x_affich(indices),y_affich(indices),'Color',rose,'LineWidth',3);
     end
     pause(temps_pause);
    
	

	% Courbe d'evolution du niveau de gris moyen :
	
		liste_q = [liste_q q];
		I_moyen_config = mean(I_moyen);
		liste_I_moyen_config = [liste_I_moyen_config I_moyen_config];
		subplot(1,2,2);
		plot(liste_q,liste_I_moyen_config,'.-','Color',rose,'LineWidth',3);
		axis([0 q_max 0 255]);
		set(gca,'FontSize',20);
		xlabel('Nombre d''iterations','FontSize',20);
		ylabel('Niveau de gris moyen','FontSize',20);
	
end
