function u = collage_ex3(r,s,interieur)

r_d = double(r);
s_d = double(s);
[rows, cols,~] = size(r_d);
N = rows * cols;

% Opérateur gradient
e = ones(N,1);
Dx = spdiags([-e e],[0 rows],N,N);
Dx(end-rows+1:end,:) = 0;
Dy = spdiags([-e e],[0 1],N,N);
Dy(rows:rows:end,:) = 0;


% Calcul du bord
bord_r = ones(rows, cols);
bord_r(2:rows-1, 2:cols-1) = 0;
n_bord_r = sum(bord_r, 'all');
indices_bord_r = find(bord_r);
n_r = N;

% Laplacien (matrice A)
A = -Dx' * Dx - Dy' * Dy;
A(indices_bord_r,:) = sparse(1:n_bord_r,indices_bord_r,ones(n_bord_r,1),n_bord_r,n_r);


% Calcul de l'imagette resultat u, canal par canal :
u = r_d;
for k = 1:size(r_d,3)
    % div g (vecteur b)
    c_k = r_d(:,:,k);
    s_k = s_d(:,:,k);
    gx = Dx * c_k(:);
    gy = Dy * c_k(:);
    gs_x = Dx * s_k(:);
    gs_y = Dy * s_k(:);
    to_replace = intersect(find((gx.^2 + gy.^2) < (gs_x.^2 + gs_y.^2)), interieur);
    gx(to_replace) = gs_x(to_replace);
    gy(to_replace) = gs_y(to_replace);
    b = -Dx' * gx - Dy' * gy;
    b(indices_bord_r) = c_k(indices_bord_r);
    
    u_k = A\b;
	u(:,:,k) = reshape(u_k, rows, cols);
end

end
