function [poids , argument] = estimation_poids(mu_test,sigma_test,liste_nvg,F)

    N = length(mu_test); 
    A = zeros(length(liste_nvg), N);
    for j = 1:N
        mu_j = mu_test(j);
        sigma_j = sigma_test(j);
        A(:, j) = (1 / (sigma_j * sqrt(2 * pi))) * exp(-((liste_nvg - mu_j).^2) / (2 * sigma_j^2));
    end

   poids = A \ (F');

   estime = A * poids;
   argument = sum((F' - estime).^2);
end