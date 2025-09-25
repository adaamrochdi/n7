clear;
close all;

taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);


% Parametres :
R = 7;					% Rayon
a = R;
b = 0.5 * R;
nb_points_affichage_ellipse = 30;
increment_angulaire = 2*pi/nb_points_affichage_ellipse;
t = 0:increment_angulaire:2*pi;
rose = [253 108 158]/255;
q_max = 200;
nb_affichages = 1000;
pas_entre_affichages = floor(q_max/nb_affichages);
temps_pause = 0.001;
beta = 1;
S = 115;
gamma = 5;
T = 0.1;
lambda = 1000;
alpha = 0.99;
affichage_min = -400;
affichage_max = 0;


% Paramètres riz
%{
R = 22;					% Rayon
a = R;
b = 0.35 * R;
lambda = 70;
S = 100;
affichage_min = -100;
affichage_max = 100;
%}

% Lecture et affichage de l'image :
I = imread('colonie.png');
I = rgb2ycbcr(I);
I = double(I(:,:,1));
[nb_lignes,nb_colonnes] = size(I);
figure('Name','Detection de flamants roses par ellipse','Position',[0,0,L,0.58*H]);


liste_q = [];
liste_Uc_config = [];

c = [];
theta = [];
I_moyen = [];

% Recherche de la configuration optimale :
for q = 1:q_max

    % Naissances
    N = poissrnd(lambda); % Nombre de nouvelles ellipses

    c_new = zeros(N,2);
    theta_new = zeros(N,1);
    I_moyen_new = zeros(N,1);
    % Création des N nouvelles ellipses
    for i = 1:N
	    c_i = [nb_colonnes*rand nb_lignes*rand];
	    c_new(i,:) = c_i;
        theta_new(i) = rand*pi;
	    I_moyen_new(i) = calcul_I_moyen_ellipse(I,c_i,theta_new(i), a, b);
    end
    
    % Ajout des nouvelles ellipses à la configuration actuelle
    c = [c; c_new];
    theta = [theta; theta_new];
    I_moyen = [I_moyen; I_moyen_new];

    % Tri des ellipses
    U_i = 1 - 2 ./ (1 + exp(-gamma * (I_moyen / S - 1)));
    [U_i, perm] = sort(U_i, 'descend');
    c = c(perm, :);
    theta = theta(perm);
    I_moyen = I_moyen(perm);
    

    % Morts
    i=1;
    all_recouv = 0; % Le nombre total de recouvrements
    while i <= size(c,1)
        recouv = recouvrement(c,theta,c(i,:),theta(i),a,b); % Nombre de recouvrement sur l'ellipse i
        all_recouv = all_recouv + recouv;
        proba_mort = lambda / (lambda + exp(-(U_i(i) + beta * recouv) / T)); % Probabilité de mort
        if rand < proba_mort % On retire l'ellipse
            c(i,:) = [];
            I_moyen(i) = [];
            U_i(i) = [];
            theta(i) = [];
            converged = 0;
            continue
        end
        i = i + 1;
    end
    
    U_c = sum(U_i) + beta * (all_recouv / 2); % Énergie de la configuration
    liste_q = [liste_q q];
    liste_Uc_config = [liste_Uc_config U_c];
    
    % Affichage
	hold off;
	subplot(1,2,1);
	imagesc(I);
	axis image;
	axis off;
	colormap gray;
	hold on;
	for j = 1:size(c,1)
		x_affich = c(j,1)+a*cos(theta(j))*cos(t) - b*sin(theta(j))*sin(t);
		y_affich = c(j,2)+a*sin(theta(j))*cos(t) + b*cos(theta(j))*sin(t);
		indices = find(x_affich>0 & x_affich<nb_colonnes & y_affich>0 & y_affich<nb_lignes);
		plot(x_affich(indices),y_affich(indices),'Color',rose,'LineWidth',3);
	end
	pause(temps_pause);

    % Courbe d'evolution de l'énergie U(c) :
    subplot(1,2,2);
    plot(liste_q,liste_Uc_config,'.','Color',rose);
    axis([0 q_max affichage_min affichage_max]);
    set(gca,'FontSize',20);
    xlabel('Nombre d''iterations','FontSize',20);
    ylabel('Énergie de la configuration','FontSize',20);

	% Courbe d'evolution de l'énergie U(c) :
	if rem(q,pas_entre_affichages)==0
		liste_q = [liste_q q];
		I_moyen_config = mean(I_moyen);
		liste_Uc_config = [liste_Uc_config I_moyen_config];
		subplot(1,2,2);
		plot(liste_q,liste_Uc_config,'.-','Color',rose,'LineWidth',3);
		axis([0 q_max -400 0]);
		set(gca,'FontSize',20);
		xlabel('Nombre d''iterations','FontSize',20);
		ylabel('Énergie de la configuration','FontSize',20);
    end
    
    % Test de convergence
    if ~converged
        T = alpha * T;
        lambda = alpha * lambda;
    end
    converged = 1;
end