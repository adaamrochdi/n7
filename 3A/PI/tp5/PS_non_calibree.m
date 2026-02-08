function [rho_estime,N_estime] = PS_non_calibree(I,masque) 
    
    I_masque = I(:, masque);
    
    [U_barre, W_barre, V_barre] = svds(I_masque, 3);
    W_sqrt = sqrt(W_barre);
    M0 = W_sqrt * V_barre'; 
    M1 = impose_integrabilite(M0, masque); 
    M1_x = M1(1, :);
    M1_y = M1(2, :);
    M1_z = M1(3, :);
    mean_M1x = mean(M1_x);
    mean_M1y = mean(M1_y);
    mean_M1z = mean(M1_z);
    alpha_hat = -mean_M1x / mean_M1z;
    beta_hat  = -mean_M1y / mean_M1z;
    N_ITER = 100; 
    gamma_best = 1;
    min_variance = inf;
    M_prime_x = M1_x + alpha_hat * M1_z; 
    M_prime_y = M1_y + beta_hat  * M1_z;
    for i = 1:N_ITER
        gamma_test = rand(); 
        M_z_test = gamma_test * M1_z;
        rho_test = sqrt(M_prime_x.^2 + M_prime_y.^2 + M_z_test.^2);
        min_rho = min(rho_test);
        max_rho = max(rho_test);
        if max_rho ~= min_rho
            rho_norm = (rho_test - min_rho) / (max_rho - min_rho);
        else
            rho_norm = zeros(size(rho_test));
        end
        current_variance = var(rho_norm);
        if current_variance < min_variance
            min_variance = current_variance;
            gamma_best = gamma_test;
        end
    end
    M_estime = zeros(3, size(M1, 2));
    M_estime(1, :) = M_prime_x;
    M_estime(2, :) = M_prime_y;
    M_estime(3, :) = gamma_best * M1_z;
    rho_estime_masque = sqrt(sum(M_estime.^2, 1));
    rho_norm_factor = rho_estime_masque + 1e-6 * (rho_estime_masque == 0);
    N_estime_masque = M_estime ./ repmat(rho_norm_factor, 3, 1);
    taille_image = size(I, 2); 
    rho_estime = zeros(1, taille_image);
    N_estime = zeros(3, taille_image);
    
    rho_estime(1, masque) = rho_estime_masque;
    N_estime(:, masque) = N_estime_masque;

end