function [Imoscoul] = mosaiquecoul(Im1_coul, Im2_coul, H)
% Calcul d'une mosaïque d'image en couleur à partir de 2 images : Im1_coul et Im2_coul
% connaissant l'homographie H entre les 2. 
% L'homographie est appliquée à chaque canal.

% On récupère la taille des deux images.
[nblI1 nbcI1 nchanaux] = size(Im1_coul);
[nblI2 nbcI2 ~] = size(Im2_coul); 

% On calcule l'homographie inverse, normalisée.
Hinv=inv(H);
Hinv=Hinv./Hinv(3,3);

% Calcul des dimensions de la mosaïque. 
% Coins de l'image 2 (en colonnes/lignes).
xy_coinsI2_R2 = [1 1; nbcI2 1; nbcI2 nblI2; 1 nblI2];
% Application de l'homographie Hinv sur ces coins.
xy_coinsI2_R1 = appliquerHomographie(Hinv,xy_coinsI2_R2);

% Détermination des dimensions de la mosaïque.
xmin=floor(min([xy_coinsI2_R1(:,1)' 1]));
ymin=floor(min([xy_coinsI2_R1(:,2)' 1]));
xmax=ceil(max([xy_coinsI2_R1(:,1)' nbcI1]));
ymax=ceil(max([xy_coinsI2_R1(:,2)' nblI1]));

% Calcul de la taille de la mosaïque.
nblImos=ymax-ymin+1;
nbcImos=xmax-xmin+1;
Imoscoul=zeros(nblImos, nbcImos, nchanaux); % Initialisation 3D

% Calcul de l'origine de l'image I1 dans le repère de la mosaïque Imoscoul. 
O1x_Rmos = 1-(xmin-1);
O1y_Rmos = 1-(ymin-1);

% Copie de l'image I1 dans la mosaïque pour chaque canal. 
for c=1:nchanaux
    Imoscoul(O1y_Rmos:O1y_Rmos+nblI1-1, O1x_Rmos:O1x_Rmos+nbcI1-1, c) = Im1_coul(:,:,c);
end

% Copie de l'image I2 transformée par l'homographie H (avec fusion pondérée). 
for x=1:nbcImos,
  for y=1:nblImos,
    % Coordonnées dans le repère I1 (colonne x_R1, ligne y_R1)
    y_R1=y-O1y_Rmos;
    x_R1=x-O1x_Rmos;

    % Estimation des coordonnées projetées dans I2. (Géométrie 2D)
    xy_R2 = appliquerHomographie(H,[x_R1 y_R1]);
    
    x_R2=round(xy_R2(1)); 
    y_R2=round(xy_R2(2));

    % On vérifie que xy_R2 appartient bien à l'image I2 
    if(x_R2>=1 & x_R2<=nbcI2 & y_R2>=1 & y_R2<=nblI2)
        
        % Boucle sur les 3 canaux pour la fusion des valeurs de pixels
        for c=1:nchanaux
            
            I2_val = Im2_coul(y_R2, x_R2, c); % Valeur du pixel dans I2 pour le canal 'c'
            
            if (y_R1 >= 1 & y_R1 <= nblI1 & x_R1 >= 1 & x_R1 <= nbcI1) 
                d1 = nbcI1 - x_R1; 
                d2 = x_R2;
                p1 = d1 / (d1 + d2);
                p2 = d2 / (d1 + d2);
                
                I1_val = Im1_coul(y_R1, x_R1, c); 
                
                Imoscoul(y,x,c) = p1 * I1_val + p2 * I2_val;
                
            else 
                Imoscoul(y, x, c) = I2_val; 
            end
        end 
        
    end 
  end
end


end