function u_k = debruitage(b,u_k,lambda,Dx,Dy,epsilon)

[nb_lignes,nb_colonnes,~] = size(b);
nb_pixels = nb_lignes*nb_colonnes;


grad_u = [Dx * u_k, Dy * u_k];
var_total = 1 ./ sqrt(sum(grad_u.^2, 2) + epsilon);

w_k = spdiags(var_total, 0, nb_pixels, nb_pixels);

% Matrice A du systeme :
Lap = -Dx'*w_k*Dx -Dy'* w_k*Dy;
A = speye(nb_pixels) -lambda*Lap;
u_k = A\b;

