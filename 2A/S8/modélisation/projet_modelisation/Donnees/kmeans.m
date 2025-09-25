function [centres, etiquettes] = kmeans(I, k, iter_max, epsilon)
    [n_lignes, n_colonnes, ~] = size(I);
    centres=zeros(k,3);
    centres(1,:) = [255 0 0];
    centres(2,:) = [0 0 255];
    etiquettes = zeros(n_lignes, n_colonnes);
    E = +inf;
    n = 0;
    figure;
    
    while E > epsilon && n < iter_max
        
        distances = inf(n_lignes, n_colonnes);
        for i = 1:n_lignes
            for j = 1:n_colonnes
                for q = 1:k
                    D = sqrt((centres(q, 1) - double(I(i, j, 1)))^2 + ...
                              0.5*(centres(q, 2) - double(I(i, j, 2)))^2 + ...
                              0.8*(centres(q, 3) - double(I(i, j, 3)))^2 );
                    
                    if D < distances(i, j)
                        distances(i, j) = D;
                        etiquettes(i, j) = q;
                    end
                end
            end
        end
        old_centres = centres;
        centres = compute_new_centers2(etiquettes, I, k);
        E = norm(centres-old_centres);
        
        n = n + 1;
    end
    
end