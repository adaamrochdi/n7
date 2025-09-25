function y = QPSK(donnees)

    taille = length(donnees) / 2;
    y = zeros(1, taille);
    for k = 1:taille
        if donnees(2*k-1) == 0 && donnees(2*k) == 0
            y(k) = -1-1j;
        elseif donnees(2*k-1) == 0 && donnees(2*k) == 1
            y(k) = -1+1j;
        elseif donnees(2*k-1) == 1 && donnees(2*k) == 1
            y(k) = 1+1j;
        elseif donnees(2*k-1) == 1 && donnees(2*k) == 0
            y(k) = 1-1j;
        end
    end
    y = y / sqrt(2);
    
end
