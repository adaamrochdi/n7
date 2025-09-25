function parametres_MV = max_vraisemblance_2(D_app, parametres_test, sigma)

    nb_tirages = size(parametres_test, 1);
    table = zeros(nb_tirages,1);
    
    for i = 1:nb_tirages
        parametres_1 = squeeze(parametres_test(i, 1, :)); 
        parametres_2 = squeeze(parametres_test(i, 2, :));

        r1 = calcul_r(D_app, parametres_1);
        r2 = calcul_r(D_app, parametres_2);

        terme1 = exp(- (r1.^2) / (2 * sigma^2)) / (sigma * sqrt(2 * pi));
        terme2 = exp(- (r2.^2) / (2 * sigma^2)) / (sigma * sqrt(2 * pi));
        
        L = log(0.5 * terme1 + 0.5 * terme2);
        table(i) = sum(L);
    end

    [~, indice_max] = max(table);

    parametres_MV = squeeze(parametres_test(indice_max, :, :));
end
