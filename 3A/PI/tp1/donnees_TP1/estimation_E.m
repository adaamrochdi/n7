function E = estimation_E(q1_estim,q2_estim)
    m=size(q1_estim,2);
    A = zeros(m,9);
    for i = 1:m
        A(i,:) = kron(q1_estim(:,i).', q2_estim(:,i).');
    end

   M = A' * A ;
   [V,D] = eig(M);
   [~,idx] = min(diag(D));
   e = V(:,idx);  
   
   e= e/norm(e);
   E = reshape(e,3,3);

   [U,S,Vt] = svd(E);
   S(1,1) = 1;  S(2,2) = 1;  S(3,3) = 0;
   E = U * S * Vt';