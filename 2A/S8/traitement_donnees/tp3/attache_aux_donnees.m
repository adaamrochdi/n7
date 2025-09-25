function AD = attache_aux_donnees(I,moyennes,variances)
AD=zeros(100,100,4);
[nb_lignes,nb_colonnes]=size(I);
    for i=1:nb_lignes
        for j=1:nb_colonnes 
            for k = 1:4
                AD(i, j, k) = 0.5 * (log(variances(k)) + (I(i,j) - moyennes(k))^2 / variances(k));
            end
        end
    end
end
