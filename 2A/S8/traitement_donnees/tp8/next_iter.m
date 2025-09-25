function u_kp1 = next_iter(b,u_k,lambda,Dx,Dy,epsilon)
    
    N = length(u_k);

    grad_u_2 = (Dx * u_k) .^ 2 + (Dy * u_k) .^ 2;

    W_k = spdiags(1 ./ sqrt(grad_u_2 + epsilon), 0, N, N);

    A = speye(N) - lambda * ( - Dx' * W_k * Dx - Dy' * W_k * Dy);

    u_kp1 = A \ b;

end
