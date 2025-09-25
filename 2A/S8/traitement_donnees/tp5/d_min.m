function [existe_q,bornes_V_p,bornes_V_q_chapeau] = d_min(i_p,j_p,u_k,D,t,T)

existe_q = 0;
d_chapeau = inf;
[n, m, ~] = size(u_k);

[R_p_i, R_p_j] = R_p(i_p, j_p, t, D);


% Parcourir tous les q de F'(p)
for i = max(1,(i_p - T + t)):min(n,(i_p + T - t))
    for j = max(1,(j_p - T + t)):min(m, (j_p + T - t))
        if sum(D(max(1,i-t):min(n,i+t),max(1,j-t):min(m,j+t)),"all") == 0
            existe_q = 1;
            % Calcul de la dissemblance
            d_p_q = 0;
            for l = 1:length(R_p_i)
                % Pour ne pas dépasser la taille de l'image
                if i + R_p_i(l) <= n && j + R_p_j(l) <= m && i + R_p_i(l) >= 1 && j + R_p_j(l) >= 1
                    %i_p + R_p_i(l)
                    u_p_l = u_k(min(max(i_p + R_p_i(l), 1), n),min(max(j_p + R_p_j(l), 1), m), :);
                    u_q_l = u_k(i + R_p_i(l),j + R_p_j(l), :);
                    d_p_q = d_p_q + norm(u_p_l(:,:) - u_q_l(:,:)) ^ 2;
                end
            end

            % Mise à jour du minimum
            if d_p_q < d_chapeau
                d_chapeau = d_p_q;
                q_chapeau = [i j];
            end

        end
    end
end

if existe_q
    bornes_V_p = [i_p, j_p, t];
    bornes_V_q_chapeau = [q_chapeau, t];
else
    bornes_V_p = zeros(1,3);
    bornes_V_q_chapeau = zeros(1,3);
end

end