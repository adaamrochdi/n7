function [tirage_estim,E] = estimation_E_robuste(q1,q2,nb_paires)



    seuil = 2e-7;  
    iter = 0;
    maxIter = 50000;
    med = inf;
   
    while med >= seuil && iter <= maxIter
        iter = iter + 1 ;
        tirage_estim = randperm(nb_paires,8);

        q1_estim = q1(:,tirage_estim);
        q2_estim = q2(:,tirage_estim);
        
        E_candidat = estimation_E(q1_estim,q2_estim);

        l2 = E_candidat * q1;   
        l1 = E_candidat' * q2;

        num2 = abs(sum(l2 .* q2, 1));                 
        den2 = sqrt(l2(1,:).^2 + l2(2,:).^2) + eps;   
        d2   = (num2 ./ den2).^2;

        num1 = abs(sum(l1 .* q1, 1));
        den1 = sqrt(l1(1,:).^2 + l1(2,:).^2) + eps;
        d1   = (num1 ./ den1).^2;

        med = median([d1, d2]);
    end

    E=E_candidat;
    
end