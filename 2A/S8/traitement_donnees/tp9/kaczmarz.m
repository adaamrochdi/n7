function f = kaczmarz(p,W,n_boucles)

    [n_mesures, n_pixels] = size(W);       
    f = zeros(n_pixels,1);
    w_norm= sum(W.^2, 2);        

    W_t= W.';                      
    k_max= n_boucles * n_mesures;

    for k = 0 : k_max-1

        i = mod(k, n_mesures) + 1;            
        
        if w_norm(i) == 0                  
            continue;                        
        end
        
        wi= W_t(:, i);                
        res = p(i) - wi' * f;            
        f = f + (res / w_norm(i)) * wi;
    end