function centres = compute_new_centers2(etiquettes,I,k)
%COMPUTE_NEW_CENTERS Summary of this function goes here
%   Detailed explanation goes here
    centres=zeros(k,3);
    R = I(:,:,1);
    G = I(:,:,2);
    B = I(:,:,3);
    for i=1:k
        mask=(etiquettes==i);
        nb = sum(mask(:));
        if nb > 0
            r = mean(R(mask));
            g = mean(G(mask));
            b = mean(B(mask));
            centres(i, :) = [r,g,b];
        end
        
    end

        
end



