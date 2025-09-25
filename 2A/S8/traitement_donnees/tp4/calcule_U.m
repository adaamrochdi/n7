function U = calcule_U(Beta,U_i,c,theta,a,b,P_test)
    N = size(c,1);
    som = 0;
    for i = 1:(N-1)
        for j = i+1:N
            r = recouvrement_ellipses(c(i,:), theta(i), c(j,:), theta(j), a, b, P_test);
            if r > 0.2
                som = som + 1;
            end
        end
    end
    U = sum(U_i) + Beta * som;
end
