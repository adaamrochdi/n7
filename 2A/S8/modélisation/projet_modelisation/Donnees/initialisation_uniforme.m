function centres = initialisation_uniforme(I, nb_superpixels)
    [nb_lignes, nb_colonnes, ~] = size(I);  
    centres = zeros(nb_superpixels, 5);  
    
    lignes = round(linspace(1, nb_lignes, sqrt(nb_superpixels)));
    colonnes = round(linspace(1, nb_colonnes, sqrt(nb_superpixels)));

    k = 1;
    for i = 1:length(lignes)
        for j = 1:length(colonnes)
            y = min(lignes(i), nb_lignes);  
            x = min(colonnes(j), nb_colonnes);  
            L = I(y, x, 1);  
            a = I(y, x, 2);  
            b = I(y, x, 3);

            centres(k, :) = [L, a, b, y, x]; 
            k = k + 1;
        end
    end
end
