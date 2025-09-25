function probas = probabilites(D_app, parametres_estim, sigma)
    parametres_1 = parametres_estim(1, :);
    parametres_2 = parametres_estim(2, :);
    
    r1 = calcul_r(D_app, parametres_1);
    r2 = calcul_r(D_app, parametres_2);
    
    term1 = exp(- (r1.^2) / (2 * sigma^2)) / (sigma * sqrt(2 * pi));
    term2 = exp(- (r2.^2) / (2 * sigma^2)) / (sigma * sqrt(2 * pi));
    
    probas(1, :) = 0.5 * term1 ./ (0.5 * term1 + 0.5 * term2);
    probas(2, :) = 0.5 * term2 ./ (0.5 * term1 + 0.5 * term2);
end
