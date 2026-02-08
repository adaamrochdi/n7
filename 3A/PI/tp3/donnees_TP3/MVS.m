function z = MVS(I_ref_vect, M_ref, R_ref, t_ref, I_tem_vect, M_tem, R_tem, t_tem, K, valeurs_z)

    [H, W]  = size(M_ref);
    ind_pix = find(M_ref(:) > 0);       
    Pn      = numel(ind_pix);          
    N       = numel(valeurs_z);         
    n       = size(I_tem_vect, 3);      

    Iref9 = I_ref_vect(ind_pix, :);     % [Pn x 9]


    [vi, uj] = ind2sub([H, W], ind_pix);                        
    p_ref    = [double(uj(:)).'; double(vi(:)).'; ones(1,Pn)];   % [3 x Pn]
    rays_ref = K \ p_ref;                                       

    costs = inf(Pn, N);

  
    for j = 1:N
        zc   = valeurs_z(j);

        % Points 3D en ref-cam puis monde
        Xref = zc * rays_ref;                        % [3 x Pn]
        Xw   = R_ref' * (Xref - t_ref);              % [3 x Pn]   pour passer au ref world

        acc_err = zeros(Pn,1);
        acc_cnt = zeros(Pn,1);

        for k = 1:n
            Rk = R_tem(:,:,k);  tk = t_tem(:,k);   %rotation et translation des temoins

            Xk = Rk * Xw + tk;                      % [3 x Pn]    pour passer au ref témoin
            pk = K * Xk;                            % [3 x Pn]
            u  = pk(1,:)./pk(3,:);
            v  = pk(2,:)./pk(3,:);
            in_front = pk(3,:) > 0;
            jj = round(u); ii = round(v);           

            % Dans l'image ?
            in_img = in_front & (ii>=1)&(ii<=H)&(jj>=1)&(jj<=W);

            if any(in_img)
                Mk  = M_tem(:,:,k);
                lin = sub2ind([H, W], ii(in_img), jj(in_img));   % indices linéaires HxW

                valid = false(1, Pn);
                valid(in_img) = Mk(lin);             % aussi dans le masque témoin ?

                if any(valid)
                    lin_valid     = sub2ind([H, W], ii(valid), jj(valid));
                    Item9_valid   = I_tem_vect(lin_valid, :, k); % [Pv x 9]
                    Iref9_valid   = Iref9(valid, :);             % [Pv x 9]
                    d             = abs(Item9_valid - Iref9_valid);
                    s             = sum(d, 2);                    % L1 sur 9

                    acc_err(valid) = acc_err(valid) + s;
                    acc_cnt(valid) = acc_cnt(valid) + 1;
                end
            end
        end

        test = acc_cnt > 0;
        costs(test, j) = acc_err(test);              
    end

    [~, jbest] = min(costs, [], 2);
    z = valeurs_z(jbest).';                          %[Pn x 1]
end
