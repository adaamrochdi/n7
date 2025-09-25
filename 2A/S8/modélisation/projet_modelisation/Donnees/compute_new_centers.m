function centres = compute_new_centers(etiquettes,I,nb_superpixels)
%COMPUTE_NEW_CENTERS Summary of this function goes here
%   Detailed explanation goes here
    centres=zeros(nb_superpixels,5);
    L = I(:,:,1);
    A = I(:,:,2);
    B = I(:,:,3);
    for k=1:nb_superpixels
        mask=(etiquettes==k);
        nb = sum(mask(:));
        if nb > 0
            [ligne, colonne] = find(mask);
            x = mean(ligne);
            y = mean(colonne);
            l = mean(L(mask));
            a = mean(A(mask));
            b = mean(B(mask));
            centres(k, :) = [l, a, b, x, y];
        end
        
    end

        
end



