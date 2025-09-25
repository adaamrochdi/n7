function [centres, etiquettes] = SLIC(I, nb_superpixels, m, iter_max, epsilon)
    [n_lignes, n_colonnes, ~] = size(I);
    nb_pixels = n_lignes * n_colonnes;
    S = round(sqrt(nb_pixels/nb_superpixels));
    centres = initialisation_uniforme(I, nb_superpixels);
    etiquettes = zeros(n_lignes, n_colonnes);
    E = +inf;
    n = 0;
    [Gx, Gy] = gradient(double(I(:,:,1)));%canal L pour calculer le gradient
    G = sqrt(Gx.^2 + Gy.^2); 
    
    n_voisinage = 3;
    for k = 1:size(centres, 1)
        x = round(centres(k, 4));
        y = round(centres(k, 5));
        xmin = max(1, x - n_voisinage);
        xmax = min(n_lignes, x + n_voisinage);
        ymin = max(1, y - n_voisinage);
        ymax = min(n_colonnes, y + n_voisinage);
        
        sous_gradient = G(xmin:xmax, ymin:ymax);
        [min_grad_val, min_idx] = min(sous_gradient(:));
        [min_x_local, min_y_local] = ind2sub(size(sous_gradient), min_idx);
        
        min_x = xmin + min_x_local - 1;
        min_y = ymin + min_y_local - 1;
        centres(k, 4) = min_x;
        centres(k, 5) = min_y;
        centres(k, 1:3) = I(min_x, min_y, :);
    end
    
    figure;
    
    while E > epsilon && n < iter_max
        % Calcul des distances et assignation des étiquettes
        distances = inf(n_lignes, n_colonnes);
        for i = 1:nb_superpixels
            x = round(centres(i, 4));
            y = round(centres(i, 5));
            xmin = max(1, x - S);
            xmax = min(n_lignes, x + S);
            ymin = max(1, y - S);
            ymax = min(n_colonnes, y + S);
            
            for j = xmin:xmax
                for k = ymin:ymax
                    Dc = sqrt((centres(i, 1) - I(j, k, 1))^2 + ...
                             (centres(i, 2) - I(j, k, 2))^2 + ...
                             (centres(i, 3) - I(j, k, 3))^2);
                    Dp = sqrt((centres(i, 4) - j)^2 + (centres(i, 5) - k)^2);
                    D = Dc + (m/S) * Dp;
                    
                    if D < distances(j, k)
                        distances(j, k) = D;
                        etiquettes(j, k) = i;
                    end
                end
            end
        end
       
        for i = 1:nb_superpixels
            mask = (etiquettes == i);
            CC = bwconncomp(mask);
            
            if CC.NumObjects > 1  % Si un superpixel est fragmenté
                sizes = cellfun(@numel, CC.PixelIdxList);
                [~, max_idx] = max(sizes);
                
                % Réassigner les fragments au voisin connexe le plus proche
                for j = 1:CC.NumObjects
                    if j ~= max_idx
                        fragment_idx = CC.PixelIdxList{j};
                        [rows, cols] = ind2sub(size(etiquettes), fragment_idx);
                        
                        for p = 1:length(rows)
                            x = rows(p);
                            y = cols(p);
                            
                            % Chercher les voisins valides et leurs étiquettes
                            voisins = [];
                            if x > 1 && etiquettes(x-1, y) ~= 0
                                voisins = [voisins, etiquettes(x-1, y)]; % Voisin en haut
                            end
                            if x < n_lignes && etiquettes(x+1, y) ~= 0
                                voisins = [voisins, etiquettes(x+1, y)]; % Voisin en bas
                            end
                            if y > 1 && etiquettes(x, y-1) ~= 0
                                voisins = [voisins, etiquettes(x, y-1)]; % Voisin à gauche
                            end
                            if y < n_colonnes && etiquettes(x, y+1) ~= 0
                                voisins = [voisins, etiquettes(x, y+1)]; % Voisin à droite
                            end
                            
                            % Si des voisins sont trouvés, assigner l'étiquette dominante
                            if ~isempty(voisins)
                                etiquettes(x, y) = mode(voisins);  % Assignation à l'étiquette dominante
                            end
                        end
                    end
                end
            end
        end

    
        
        % Affichage des frontières et des germes sur la même image
        bords = boundarymask(etiquettes);
        imshow(labeloverlay(lab2rgb(I), bords));
        hold on;
        plot(centres(:, 5), centres(:, 4), 'r*', 'MarkerSize', 6);
        title(sprintf('Germes et frontières - Itération %d/%d (Erreur: %.4f)', n, iter_max, E));
        
        hold off;
        drawnow;
        % Calcul des nouveaux centres
        old_centres = centres;
        centres = compute_new_centers(etiquettes, I, nb_superpixels);
        E = norm(old_centres-centres);
        n = n + 1;
    end
    
    
    
end