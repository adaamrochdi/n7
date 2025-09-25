function [A_filtre, pts_filtre, idx_valide] = appliquer_SAT(A, pts, rayons, facteur)
    n = size(pts, 1);
    rayons_s = rayons * facteur;
    
    a_garder = true(n, 1);
    
    for i = 1:n
        for j = 1:n
            if i == j
                continue;
            end     
            dist = sqrt(sum((pts(i,:) - pts(j,:)).^2));
            
            if rayons_s(i) + dist < rayons_s(j)
                a_garder(i) = false;
                break;
            end
        end
    end
    
    pts_filtre = pts(a_garder, :);
    A_filtre = A(a_garder, a_garder);
    idx_valide = find(a_garder);
end