function [ImosN] = mosaiqueN(I_list, H_list)
% [ImosN] = mosaiqueN(I_list, H_list)
% Calcule la mosaïque pour N images couleur en utilisant l'image centrale comme référence.

N = length(I_list);
if N < 2
    error('N doit être supérieur ou égal à 2 pour créer une mosaïque.');
end

% --- 1. DÉTERMINATION DE L'IMAGE DE RÉFÉRENCE (CENTRE) ---
ref_idx = ceil(N/2);
Im_ref = I_list{ref_idx}; 
[nbl_ref, nbc_ref, n_chanaux] = size(Im_ref);

% --- 2. CALCUL DES HOMOGRAPHIES VERS LA RÉFÉRENCE (H_i_ref) ---

% H_i_ref : Homographie I_i -> I_ref
H_i_ref = cell(1, N);
H_i_ref{ref_idx} = eye(3); % H_ref_ref est l'identité

for i = 1:N
    if i == ref_idx
        continue;
    end
    
    % Chaînage de H_i vers I_ref. On utilise une matrice temporaire 'H_temp'
    % pour accumuler le produit matriciel H_i -> I_ref.
    
    H_temp = eye(3);
    
    % Déterminer le chemin : i doit aller jusqu'à ref_idx
    
    % Cas 1: i < ref_idx (Ex: I1 -> I2) -> Utilise les H_list directement
    if i < ref_idx
        for j = i : ref_idx - 1 
            H_temp = H_list{j} * H_temp; % H_j_(j+1) * H_prev
        end
        
    % Cas 2: i > ref_idx (Ex: I3 -> I2) -> Utilise les H_list inverses
    elseif i > ref_idx
        for j = i - 1 : -1 : ref_idx
            % H_j+1_j = inv(H_j_(j+1))
            H_j_to_jplus1 = H_list{j};
            H_inv = inv(H_j_to_jplus1);
            H_inv = H_inv ./ H_inv(3,3);
            
            H_temp = H_inv * H_temp; % H_curr_to_prev * H_prev
        end
    end
    
    H_i_ref{i} = H_temp ./ H_temp(3,3); % Normalisation finale
end

% --- 3. CALCUL DES DIMENSIONS GLOBALES (Bounding Box) ---

all_x = [1, nbc_ref];
all_y = [1, nbl_ref];

for i = 1:N
    if i == ref_idx
        continue;
    end
    [nbl, nbc, ~] = size(I_list{i});
    corners = [1 1; nbc 1; nbc nbl; 1 nbl]; 
    
    projected_corners = appliquerHomographie(H_i_ref{i}, corners); 
    
    all_x = [all_x, projected_corners(:,1)'];
    all_y = [all_y, projected_corners(:,2)'];
end

xmin = floor(min(all_x));
ymin = floor(min(all_y));
xmax = ceil(max(all_x));
ymax = ceil(max(all_y));

nblImos = ymax - ymin + 1;
nbcImos = xmax - xmin + 1;

ImosN = zeros(nblImos, nbcImos, n_chanaux); 
   
% Calcul de l'origine de l'image de référence (I_ref) dans la mosaïque
O_ref_x_Rmos = 1 - (xmin - 1);
O_ref_y_Rmos = 1 - (ymin - 1);

% Homographies de rétro-projection I_ref -> I_i
H_ref_i = cell(1, N);
for i = 1:N
    H_ref_i{i} = inv(H_i_ref{i});
    H_ref_i{i} = H_ref_i{i} ./ H_ref_i{i}(3,3);
end

% --- 4. INITIALISATION ET REMPLISSAGE ---

% Copie de l'image de référence (I_ref) dans la mosaïque.
for c = 1:n_chanaux
    ImosN(O_ref_y_Rmos:O_ref_y_Rmos+nbl_ref-1, O_ref_x_Rmos:O_ref_x_Rmos+nbc_ref-1, c) = double(Im_ref(:,:,c));
end

for x = 1:nbcImos 
    for y = 1:nblImos 
        
        % Coordonnées dans le repère de I_ref
        x_Rref = x - O_ref_x_Rmos;
        y_Rref = y - O_ref_y_Rmos;
        
        sum_weighted_values = zeros(1, 1, n_chanaux);
        sum_weights = 0; 
        
        for i = 1:N
            Ii_coul = I_list{i};
            [nbl, nbc, ~] = size(Ii_coul);

            % Rétro-projection I_ref -> I_i (H_ref_i)
            xy_Ri = appliquerHomographie(H_ref_i{i}, [x_Rref y_Rref]);
            x_Ri = round(xy_Ri(1)); 
            y_Ri = round(xy_Ri(2));
            
            is_in_Ii = (x_Ri >= 1 && x_Ri <= nbc && y_Ri >= 1 && y_Ri <= nbl);
            
            if is_in_Ii
                val = double(Ii_coul(y_Ri, x_Ri, :)); 
                
                % Poids basé sur la distance au bord gauche de I_i
                W_i = x_Ri; 
                
                sum_weighted_values = sum_weighted_values + val * W_i;
                sum_weights = sum_weights + W_i;
            end
        end
        if sum_weights > 0
            ImosN(y, x, :) = sum_weighted_values / sum_weights;
        end
    end
end
end