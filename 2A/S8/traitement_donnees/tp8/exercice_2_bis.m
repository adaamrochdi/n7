%--------------------------------------------------------------------------
% ENSEEIHT - 2SN MM - Traitement des donnees audio-visuelles
% TP8 - Décomposition d'image
% exercice_2 : décomposition d’une image par le modèle ROF
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
u = double(imread('Images/texture.png'));
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
epsilon = 0.01;

% Operateur gradient :
e = ones(nb_pixels,1);
Dx = spdiags([-e e],[0 nb_lignes],nb_pixels,nb_pixels);
Dx(end-nb_lignes+1:end,:) = 0;
Dy = spdiags([-e e],[0 1],nb_pixels,nb_pixels);
Dy(nb_lignes:nb_lignes:end,:) = 0;

% Second membre b du systeme :
b = u;
		
% Point fixe :
lambda = 50;			% Poids de la regularisation
u_k = u;
convergence = +Inf;
iteration = 0;
nb_iter_max = 20;

while convergence > 1e-3 && iteration < nb_iter_max

	% Incrementation du nombre d'iterations :
	iteration = iteration + 1;

	% Iteration (6) :
	u_kp1 = next_iter(b,u_k,lambda,Dx,Dy,epsilon);	

	% Test de convergence :
	convergence = norm(u_kp1(:)-u_k(:))/norm(u_k(:));

	% Mise a jour de l'image courante u_k :
	u_k = u_kp1;

	% Affichage de l'image restauree a chaque iteration :
	subplot(1,3,2)
		imagesc(max(0,min(1,reshape(u_k,[nb_lignes nb_colonnes nb_canaux])/u_max)),[0 1])
		if nb_canaux==1
			colormap gray
		end
		axis image off
		title(['Structure (iteration ' num2str(iteration) ')'],'FontSize',20)
        
    subplot(1,3,3)
        imagesc(max(0,min(1,(reshape(u-u_k,[nb_lignes nb_colonnes nb_canaux])/u_max+1)/2)),[0 1])
        if nb_canaux==1
			colormap gray
        end
		axis image off
        title(['Texture (iteration ' num2str(iteration) ')'],'FontSize',20)    
        
	drawnow nocallbacks
	pause(0.1)

end

% Recomposition de la texture (dans [0,1])
texture = reshape(u - u_k, [nb_lignes, nb_colonnes, nb_canaux]);
texture_norm = max(0, min(1, (texture/u_max + 1)/2));  

imwrite(texture_norm, 'texture.png');      


