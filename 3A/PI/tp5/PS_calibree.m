function [rho_estime,N_estime] = PS_calibree(I,S) 
    A = S' *  S;
    B = S' * I ;

    m= A\ B ;
    
    rho_estime = sqrt(sum(m.^2,1));

    N_estime = m./rho_estime ;
end 