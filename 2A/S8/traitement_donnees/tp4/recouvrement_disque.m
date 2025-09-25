
function ratio = recouvrement_disque(c_i, c_j, R, P_test)

    % 1) On place les points d'essai dans le disque i
    P_i = c_i + P_test;                  % N × 2

    % 2) On teste lesquels tombent aussi dans le disque j
    dx = P_i(:,1) - c_j(1);
    dy = P_i(:,2) - c_j(2);
    inside = (dx.^2 + dy.^2) <= R^2;     % booléen N×1

    % 3) Proportion ⇒ ≈ aire(D_i ∩ D_j) / aire(D_i)
    ratio = mean( inside );              % entre 0 et 1

end
