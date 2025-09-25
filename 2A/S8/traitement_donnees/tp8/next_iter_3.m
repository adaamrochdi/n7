function u_bar_kp1 = next_iter_3(u_bar_k,gamma,mu,Dx,Dy,epsilon,poids, tf_u)
    
    % Terme fréquentiel
    tf_u_k = fft2(u_bar_k);
    tf_u_k = fftshift(tf_u_k);			% Permet de positionner l'origine (0,0) au centre
    
    terme_freq = real(ifft2(ifftshift(    poids.*(tf_u_k - tf_u)    )));

    % Terme compliqué
    u_bar_x = Dx * u_bar_k;
    u_bar_y = Dy * u_bar_k;
    u_bar_xx = - Dx' * u_bar_x;
    u_bar_xy = - Dx' * u_bar_y;
    u_bar_yy = -Dy' * u_bar_y;

    terme_complique = (u_bar_xx .* (u_bar_y.^2 + epsilon) + u_bar_yy .* (u_bar_x.^2 + epsilon) - 2 * u_bar_x .* u_bar_y .* u_bar_xy) ./ ...
        (u_bar_x.^2 + u_bar_y.^2 + epsilon).^(3/2);
    
    % Matrice finale
    A = terme_freq - mu * terme_complique;

    u_bar_kp1 = u_bar_k - gamma * A;

end
