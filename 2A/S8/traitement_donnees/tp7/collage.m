function u = collage(r,s,interieur)
    r=double(r);
    s=double(s);
    [nb_lignes,nb_colonnes,nb_canaux] = size(r);
    bord_r=zeros(nb_lignes,nb_colonnes);
    nb_pixels = nb_lignes*nb_colonnes;
    e = ones(nb_pixels,1);

    Dx = spdiags([-e e],[0 nb_lignes],nb_pixels,nb_pixels);
    Dx(end-nb_lignes+1:end,:) = 0;
    Dy = spdiags([-e e],[0 1],nb_pixels,nb_pixels);
    Dy(nb_lignes:nb_lignes:end,:) = 0;
    A = -Dx'*Dx - Dy'*Dy;

    bord_r(1, :) = 1;                    
    bord_r(end, :) = 1;                 
    bord_r(:, 1) = 1;                    
    bord_r(:, end) = 1;           
    
    indices_bord_r = find(bord_r);
    n_bord_r = length(indices_bord_r);
    A(indices_bord_r,:) = sparse(1:n_bord_r,indices_bord_r,ones(n_bord_r,1),n_bord_r,nb_pixels);

    u = zeros(nb_lignes, nb_colonnes, nb_canaux); 

    for q=1:nb_canaux
        
        r1=r(:,:,q);
        s1=s(:,:,q);

        %Récuperation du gradient de r et s 
        grad_rx = Dx * r1(:);
        grad_ry = Dy * r1(:);
        grad_sx = Dx * s1(:);
        grad_sy = Dy * s1(:);

        %la fonction g 
        gx = grad_rx;
        gy = grad_ry;

        %Remplacement de g à l'intérieur
        gx(interieur) = grad_sx(interieur);
        gy(interieur) = grad_sy(interieur);

        %divergence de g
        div_g = -Dx' * gx + -Dy' * gy;
        b = div_g;

        %  modifier également les lignes du vecteur bk correspondant aux pixels du bord de r.
        b(indices_bord_r) = r1(indices_bord_r);

        u_1 = A \ b;
        u(:,:,q) = reshape(u_1, nb_lignes, nb_colonnes);
    end


