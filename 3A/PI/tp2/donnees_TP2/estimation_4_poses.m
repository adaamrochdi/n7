function [t_4, R_4] = estimation_4_poses(E_estim)
%--------------------------------------------------------------------------
% estimation_4_poses : calcule les 4 couples (t, R) possibles à partir
% d'une matrice essentielle E.
%
% Entrée :
%   E_estim : matrice essentielle (3x3)
%
% Sorties :
%   t_4 : matrice 3x4 contenant les 4 vecteurs de translation possibles
%   R_4 : tableau 3x3x4 contenant les 4 matrices de rotation possibles
%
% Référence : cours et équations (5) et (12) du sujet TP2 - SfM
%--------------------------------------------------------------------------

    % Décomposition SVD
    [U, ~, V] = svd(E_estim);

    % On s'assure que det(UV') > 0 pour éviter une symétrie impropre
    if det(U*V') < 0
        V = -V;
    end

    % Matrice W (rotation de +pi/2 autour de l'axe z)
    W = [ 0 -1  0;
          1  0  0;
          0  0  1 ];

    % Les deux rotations possibles (équation 12)
    R1 = U * W  * V';
    R2 = U * W' * V';

    % On force la positivité du déterminant pour garantir une rotation directe
    if det(R1) < 0, R1 = -R1; end
    if det(R2) < 0, R2 = -R2; end

    % Les deux translations possibles (équation 5)
    t1 =  U(:,3);
    t2 = -U(:,3);

    % Combinaisons (t, R) → 4 solutions
    t_4 = [t1,  t1,  t2,  t2];
    R_4(:,:,1) = R1;
    R_4(:,:,2) = R2;
    R_4(:,:,3) = R1;
    R_4(:,:,4) = R2;
end
