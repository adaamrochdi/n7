function k = recuit_simule(k, AD, beta, T)
    [nb_lignes, nb_colonnes, N] = size(AD); 
    
    for i = 1:nb_lignes
        for j = 1:nb_colonnes
            ks = k(i, j); 
            
            kv = k(max(i-1,1) : min(i+1, nb_lignes), max(j-1,1) : min(j+1, nb_colonnes)); 
            
            u_s1 = AD(i, j, ks) + beta * sum(sum(ks ~= kv)); 
            
            ks2 = randi(N);
            while ks2 == ks
                ks2 = randi(N);
            end
            
            u_s2 = AD(i, j, ks2) + beta * sum(sum(ks2 ~= kv)) - 1;
            
            if u_s2 < u_s1 || rand() < exp(-(u_s2 - u_s1) / T)
                k(i, j) = ks2;
            end
        end
    end
end
