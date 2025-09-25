function probas = probabilites_EM(D_app, parametres_estim, proportion_1, proportion_2, sigma)
    parametres_1 = parametres_estim(1, :);
    parametres_2 = parametres_estim(2, :);
    
    r1 = calcul_r(D_app, parametres_1);
    r2 = calcul_r(D_app, parametres_2);
    
    term1 = proportion_1 * exp(- (r1.^2) / (2 * sigma^2)) / (sigma * sqrt(2 * pi));
    term2 = proportion_2 * exp(- (r2.^2) / (2 * sigma^2)) / (sigma * sqrt(2 * pi));
    
    total = term1 + term2;
    probas(1, :) = term1 ./ total;
    probas(2, :) = term2 ./ total;
end
