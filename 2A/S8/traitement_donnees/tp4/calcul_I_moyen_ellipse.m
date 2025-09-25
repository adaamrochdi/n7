function resultat = calcul_I_moyen_ellipse(I,c_i,theta,a,b)

[nb_lignes,nb_colonnes] = size(I);
abscisse = c_i(1,1);
ordonnee = c_i(1,2);
i_min = max(1,floor(ordonnee-a/2));
i_max = min(nb_lignes,ceil(ordonnee+a/2));
j_min = max(1,floor(abscisse-a/2));
j_max = min(nb_colonnes,ceil(abscisse+a/2));
imagette = I(i_min:i_max,j_min:j_max);
[A,O] = meshgrid(1:size(imagette,2),1:size(imagette,1));
A = A-(abscisse-j_min);
O = O-(ordonnee-i_min);
masque = ((A*cos(theta) + O*sin(theta)).^2 / (a^2) + (A*sin(theta) - O*cos(theta)).^2 / (b^2) <=1);
imagette_masquee = imagette.*masque;
resultat = sum(imagette_masquee(:))/sum(masque(:));