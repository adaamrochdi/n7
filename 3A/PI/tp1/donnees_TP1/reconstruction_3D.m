function P = reconstruction_3D(q1, q2, t_estim, R_solution)

    N = size(q1,2);
    P = zeros(3, N);

    for i = 1:N
        r1 = q1(:, i);
        r2 = q2(:, i);

        B = [-R_solution * r1,  r2];   
        z = B \ t_estim;               
        Z1 = z(1);  Z2 = z(2);
        
        P2 = 0.5 * ( Z2 * r2 + Z1 * (R_solution * r1) + t_estim );
        
        P(:,i) = P2;
    end
end
