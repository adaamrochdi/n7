function [voisins,distances] = voisinage(ind_pixels)

% Paires de pixels voisins de type ouest/est :
p_O = ind_pixels(:,2:end);
p_E = ind_pixels(:,1:end-1);
voisins = [p_O(:) p_E(:)];
distances = ones(length(p_O(:)),1);

% Paires de pixels voisins de type nord/sud :
p_N = ind_pixels(1:end-1,:);
p_S = ind_pixels(2:end,:);
voisins = [voisins ; p_N(:) p_S(:)];
distances = [distances ; ones(length(p_N(:)),1)];

% Paires de pixels voisins de type nord-ouest/sud-est :
p_NO = ind_pixels(1:end-1,1:end-1);
p_SE = ind_pixels(2:end,2:end);
voisins = [voisins ; p_NO(:) p_SE(:)];
distances = [distances ; sqrt(2)*ones(length(p_NO(:)),1)];

% Paires de pixels voisins de type sud-ouest/nord-est :
p_SO = ind_pixels(2:end,1:end-1);
p_NE = ind_pixels(1:end-1,2:end);
voisins = [voisins ; p_SO(:) p_NE(:)];
distances = [distances ; sqrt(2)*ones(length(p_SO(:)),1)];
