%--------------------------------------------------------------------------
% ENSEEIHT - 2SN MM - Traitement des donnees audio-visuelles
% TP8 - Décomposition d'image
% exercice_3 : modèle TV-Hilbert
%--------------------------------------------------------------------------

clear
close all
clc

% Mise en place de la figure pour affichage :
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);
figure('Name','Debruitage par variation totale',...
	'Position',[0.05*L,0.1*H,0.9*L,0.7*H]);

% Lecture de l'image :
u = double(imread('Images/structure.png'));
[nb_lignes,nb_colonnes,nb_canaux] = size(u);
u_max = max(u(:));

% Affichage de l'image :
subplot(1,3,1)
	imagesc(max(0,min(1,u/u_max)),[0 1])
	if nb_canaux==1
		colormap gray
	end
	axis image off
	title('Image originale','FontSize',20)

% Affichage de l'image restauree a l'iteration 0 :
subplot(1,3,2)
	imagesc(max(0,min(1,u/u_max)),[0 1])
	if nb_canaux==1
		colormap gray
	end
	axis image off
	title('Structure (iteration 0)','FontSize',20)
drawnow nocallbacks

% Vectorisation des canaux de u :
nb_pixels = nb_lignes*nb_colonnes;
u = reshape(u,[nb_pixels nb_canaux]);

% Parametre pour garantir la differentiabilite de la variation totale :
epsilon = 0.5;

% Operateur gradient :
e = ones(nb_pixels,1);
Dx = spdiags([-e e],[0 nb_lignes],nb_pixels,nb_pixels);
Dx(end-nb_lignes+1:end,:) = 0;
Dy = spdiags([-e e],[0 1],nb_pixels,nb_pixels);
Dy(nb_lignes:nb_lignes:end,:) = 0;

% Second membre b du systeme :
b = u;
		
% Point fixe :
gamma = 3e-5;			% pas de descente
mu = 2500;
eta = 0.05;
u_bar_k = u;
convergence = +Inf;
iteration = 0;
nb_iter_max = 1000;


% Création du masque de fréquence
[f_x,f_y] = meshgrid(1:nb_colonnes,1:nb_lignes);
f_x = f_x/nb_colonnes-0.5;
f_y = f_y/nb_lignes-0.5;

poids =  reshape(1 ./ (1 + (f_x.^2 + f_y.^2) / eta), [nb_pixels,1]);

tf_u = fft2(u);
tf_u = fftshift(tf_u);

while iteration < nb_iter_max

	% Incrementation du nombre d'iterations :
	iteration = iteration + 1;

	% Iteration (6) :
	u_bar_kp1 = next_iter_3(u_bar_k,gamma,mu,Dx,Dy,epsilon,poids,tf_u);	

	% Test de convergence :
	convergence = norm(u_bar_kp1(:)-u_bar_k(:))/norm(u_bar_k(:));

	% Mise a jour de l'image courante u_bar_k :
	u_bar_k = u_bar_kp1;
    
    if mod(iteration, 50) == 0
	    % Affichage de l'image restauree a chaque iteration :
	    subplot(1,3,2)
		    imagesc(max(0,min(1,reshape(u_bar_k,[nb_lignes nb_colonnes nb_canaux])/u_max)),[0 1])
		    if nb_canaux==1
			    colormap gray
		    end
		    axis image off
		    title(['Structure (iteration ' num2str(iteration) ')'],'FontSize',20)
            
        subplot(1,3,3)
            imagesc(max(0,min(1,(reshape(u-u_bar_k,[nb_lignes nb_colonnes nb_canaux])/u_max+1)/2)),[0 1])
            if nb_canaux==1
			    colormap gray
            end
		    axis image off
            title(['Texture (iteration ' num2str(iteration) ')'],'FontSize',20)    
            
	    drawnow nocallbacks
	    pause(0.1)
    end
% Sauvegarde de la structure
% Sauvegarde de la structure
u_bar_k_image = reshape(u_bar_k, [nb_lignes, nb_colonnes, nb_canaux]);
u_bar_k_image = max(0, min(1, u_bar_k_image / u_max));  % Normalisation
imwrite(im2uint8(u_bar_k_image), 'structure3.png');


end