function P = calcul_smart(nb_points_delta_D, indices_delta_D, P, ...
                           D, C, gx, gy, nx_mask, ny_mask, ...
                           nb_lignes, nb_colonnes, t)
%  nx_mask, ny_mask  = gradient(double(D))  doivent être calculés
%                     AVANT l’appel à calcul_smart et passés en argument.

for k = 1:nb_points_delta_D
    ind        = indices_delta_D(k);
    [ip,jp]    = ind2sub(size(D), ind);

    % -------- 1) Confiance C(p) ------------------------------------------
    i1 = max(ip-t,1);  i2 = min(ip+t,nb_lignes);
    j1 = max(jp-t,1);  j2 = min(jp+t,nb_colonnes);
    C_patch = C(i1:i2, j1:j2);
    C_p     = sum(C_patch(:)) / numel(C_patch);

    % -------- 2) Data term D(p) -----------------------------------------
    n_vec = [nx_mask(ip,jp), ny_mask(ip,jp)];       % normale brute
    n_vec = n_vec / (norm(n_vec) + eps);            % normalisée

    iso   = [-gy(ip,jp),  gx(ip,jp)];               % isophote
    D_p   = abs(dot(iso, n_vec)) / 255;             % α = 255

    % -------- 3) Priorité ------------------------------------------------
    P(k) = C_p * D_p;
end
end
