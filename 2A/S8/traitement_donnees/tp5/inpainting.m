function u_kp1 = inpainting(b,u_k,lambda,Dx,Dy,epsilon,Wd)
    
    N = length(u_k);

    grad_u_2 = (Dx * u_k) .^ 2 + (Dy * u_k) .^ 2;

    W_k = spdiags(1 ./ sqrt(grad_u_2 + epsilon), 0, N, N);

    A = Wd - lambda * ( - Dx' * W_k * Dx - Dy' * W_k * Dy);

    u_kp1 = A \ (Wd * b);

end
