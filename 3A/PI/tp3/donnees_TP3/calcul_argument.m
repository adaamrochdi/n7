function [reprojections,erreurs] = calcul_argument(I_ref,R_ref,t_ref,I_tem,M_tem,R_tem,t_tem,u_ref,v_ref,K,valeurs_z)

n = size(I_tem,3);
N = length(valeurs_z);
[n_lignes, n_colonnes] = size(I_ref);

erreurs = NaN(N, n);
reprojections = NaN(N, 2, n);

for j = 1:N
    z = valeurs_z(j);
    for i = 1:n
        I_i = I_tem(:,:,i);
        R_i = R_tem(:,:,i);
        t_i = t_tem(:,i);
        M_i = M_tem(:,:,i);

        P_ref = [u_ref, v_ref, 1];
        P = z * (K \ P_ref');
        P = R_ref' * (P - t_ref);
        P_i = R_i * P + t_i;
        p = K * P_i / P_i(3);

        p_i = round(p(2));
        p_j = round(p(1));

        if (p_i >= 1 && p_i <= n_lignes) && (p_j >= 1 && p_j <= n_colonnes)
            if M_i(p_i, p_j) == 1
                erreurs(j, i) = abs(I_i(p_i, p_j) - I_ref(round(v_ref), round(u_ref)));
                reprojections(j, :, i) = [p(1), p(2)];
            end
        end
    end
end

end