function I_contour = tracer_contour(I_binaire)

    [n_lignes, n_colonnes] = size(I_binaire);

    % Trouver le premier pixel blanc 
    point_trouve = false;
    for i = 50:n_lignes
        for j = 50:n_colonnes
            if I_binaire(i, j) == 1
                point_depart = [i, j];
                point_trouve = true;
                break; 
            end
        end
        if point_trouve
            break; 
        end
    end

    contour = bwtraceboundary(I_binaire, point_depart, 'W');  

    figure; imshow(I_binaire); hold on;
    if ~isempty(contour)
        plot(contour(:,2), contour(:,1), 'g', 'LineWidth', 2);
    else
        disp('Contour non trouvé.');
    end

    I_contour = contour;
end
