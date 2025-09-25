function [A, pts] = construire_matrice_adjacence(fx, fy)
    % fx et fy sont 2 x N (chaque colonne = un segment entre deux points)
    
    % 1) Créer une liste de tous les points des segments (extrémités)
    all_points = [fx(1,:)' fy(1,:)'; fx(2,:)' fy(2,:)'];

    % 2) Supprimer les doublons pour obtenir la liste unique des sommets
    [pts, ~, ic] = unique(all_points, 'rows', 'stable');

    % 3) Initialiser la matrice d'adjacence
    n = size(pts, 1);
    A = zeros(n, n);

    % 4) Pour chaque segment, trouver les indices des 2 extrémités
    N = size(fx, 2);
    for i = 1:N
        p1 = [fx(1,i), fy(1,i)];
        p2 = [fx(2,i), fy(2,i)];

        idx1 = find(ismember(pts, p1, 'rows'));
        idx2 = find(ismember(pts, p2, 'rows'));

        % Ajouter une arête entre les deux points
        if ~isempty(idx1) && ~isempty(idx2)
            A(idx1, idx2) = 1;
            A(idx2, idx1) = 1;  % graphe non orienté
        end
    end
end
