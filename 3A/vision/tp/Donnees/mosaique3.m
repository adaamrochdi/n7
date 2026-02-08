function [Imos3] = mosaique3(Im1_coul, Im2_coul, Im3_coul, H_1_2, H_2_3)
% [Imos3] = mosaique3(Im1_coul, Im2_coul, Im3_coul, H_1_2, H_2_3)
% Calcule la mosaique de 3 images couleur.
% H_1_2 : Homographie de I1 vers I2 (directe)
% H_2_3 : Homographie de I2 vers I3 (directe)

% Dimensions des images
[nblI1 nbcI1 nchanaux] = size(Im1_coul);
[nblI2 nbcI2 ~] = size(Im2_coul);
[nblI3 nbcI3 ~] = size(Im3_coul);


H_1_2_proj = H_1_2; 
H_1_2_proj = H_1_2_proj ./ H_1_2_proj(3,3); % Normalisation

% H_3_2 : Homographie I3 vers I2 (Projection I3 -> I2)
H_3_2_proj = inv(H_2_3); 
H_3_2_proj = H_3_2_proj ./ H_3_2_proj(3,3); % Normalisation

% 2. --- CALCUL DES DIMENSIONS GLOBALES DANS LE REPÈRE I2 ---

% Coins de l'image 1 et 3
xy_coinsI1_R1 = [1 1; nbcI1 1; nbcI1 nblI1; 1 nblI1];
xy_coinsI3_R3 = [1 1; nbcI3 1; nbcI3 nblI3; 1 nblI3]; 

% Projection des coins de I1 dans le repère de I2 (H_1_2_proj)
xy_coinsI1_R2 = appliquerHomographie(H_1_2_proj, xy_coinsI1_R1);
% Projection des coins de I3 dans le repère de I2 (H_3_2_proj)
xy_coinsI3_R2 = appliquerHomographie(H_3_2_proj, xy_coinsI3_R3);

% Calcul des dimensions MIN/MAX globales
% La base de comparaison est I2 (1, nbcI2, nblI2)
all_x = [1, nbcI2, xy_coinsI1_R2(:,1)', xy_coinsI3_R2(:,1)'];
all_y = [1, nblI2, xy_coinsI1_R2(:,2)', xy_coinsI3_R2(:,2)'];

xmin=floor(min(all_x));
ymin=floor(min(all_y));
xmax=ceil(max(all_x));
ymax=ceil(max(all_y));

% Dimensions et initialisation de la mosaïque
nblImos=ymax-ymin+1;
nbcImos=xmax-xmin+1;
Imos3=zeros(nblImos, nbcImos, nchanaux); 

% Calcul de l'origine de I2 (la base) dans le repère de la mosaïque
O2x_Rmos = 1-(xmin-1);
O2y_Rmos = 1-(ymin-1);

% Copie de l'image I2 (base) dans la mosaïque pour chaque canal.
for c=1:nchanaux
    Imos3(O2y_Rmos:O2y_Rmos+nblI2-1, O2x_Rmos:O2x_Rmos+nbcI2-1, c) = Im2_coul(:,:,c);
end

% 3. --- HOMOGRAPHIES DE RÉTRO-PROJECTION (I2 -> Ii) ---

% H_2_1 : Homographie I2 vers I1
H_2_1_retro = inv(H_1_2_proj);
H_2_1_retro = H_2_1_retro ./ H_2_1_retro(3,3);

% H_2_3 : Homographie I2 vers I3 (déjà fournie)
H_2_3_retro = H_2_3;
H_2_3_retro = H_2_3_retro ./ H_2_3_retro(3,3);

% 4. --- BOUCLE DE RÉTRO-PROJECTION ET FUSION ---

for x=1:nbcImos 
  for y=1:nblImos 
    
    % Coordonnées dans le repère de I2 (la nouvelle référence)
    y_R2=y-O2y_Rmos;
    x_R2=x-O2x_Rmos;
    is_in_I2 = (y_R2 >= 1 && y_R2 <= nblI2 && x_R2 >= 1 && x_R2 <= nbcI2);
    
    % Rétro-projection vers I1 (Utilisation de H_2_1_retro)
    xy_R1 = appliquerHomographie(H_2_1_retro, [x_R2 y_R2]); 
    x_R1=round(xy_R1(1)); y_R1=round(xy_R1(2));
    is_in_I1 = (x_R1>=1 && x_R1<=nbcI1 && y_R1>=1 && y_R1<=nblI1);
    
    % Rétro-projection vers I3 (Utilisation de H_2_3_retro)
    xy_R3 = appliquerHomographie(H_2_3_retro, [x_R2 y_R2]);
    x_R3=round(xy_R3(1)); y_R3=round(xy_R3(2));
    is_in_I3 = (x_R3>=1 && x_R3<=nbcI3 && y_R3>=1 && y_R3<=nblI3);
    
    for c=1:nchanaux
        final_val = Imos3(y, x, c); % Valeur actuelle (vient de I2 ou est zéro)
        
        % 1. Fusion I1 avec I2 (à gauche)
        if is_in_I1
            I1_val = Im1_coul(y_R1, x_R1, c);
            
            if is_in_I2 
                % I1 / I2 fusion
                I2_val = Im2_coul(y_R2, x_R2, c);
                d1 = nbcI1 - x_R1; d2 = x_R2; % D2 est distance au bord gauche de I2
                p1 = d1 / (d1 + d2); p2 = d2 / (d1 + d2);
                final_val = p1 * I1_val + p2 * I2_val;
            else
                % I1 seule (dans la zone de déformation)
                final_val = I1_val;
            end
        end
        
        % 2. Fusion I3 avec I2 (à droite)
        if is_in_I3
            I3_val = Im3_coul(y_R3, x_R3, c);
            
            % La valeur courante (final_val) contient soit I2, soit I1/I2 fusionné.
            if is_in_I2 
                 % Fusion I3 / I2 (I2 est le voisin le plus direct de I3)
                 I2_val = Im2_coul(y_R2, x_R2, c); % Recharger I2_val
                 
                 d2_cur = nbcI2 - x_R2; % Distance I2 au bord droit
                 d3_new = x_R3;         % Distance I3 au bord gauche
                 
                 p_cur = d2_cur / (d2_cur + d3_new); % Poids pour la valeur courante (I2 ou I1/I2)
                 p_new = d3_new / (d2_cur + d3_new); 
                 
                 final_val = p_cur * final_val + p_new * I3_val;
                 
            elseif is_in_I1
                 % I3 chevauche I1 (cas rare sans I2)
                 d1_cur = nbcI1 - x_R1; 
                 d3_new = x_R3;         
                 p_cur = d1_cur / (d1_cur + d3_new); 
                 p_new = d3_new / (d1_cur + d3_new);
                 final_val = p_cur * final_val + p_new * I3_val;
            else
                 % I3 seule
                 final_val = I3_val;
            end
        end
        Imos3(y, x, c) = final_val; 
    end
  end
end
end