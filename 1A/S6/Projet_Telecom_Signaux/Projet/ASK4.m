function y = ASK4(donnees)

    taille = length(donnees) / 2;
    y = zeros(1, taille);
    for k = 1:taille
        if donnees(2*k-1) == 0 && donnees(2*k) == 0
            y(k) = -3;
        elseif donnees(2*k-1) == 0 && donnees(2*k) == 1
            y(k) = -1;
        elseif donnees(2*k-1) == 1 && donnees(2*k) == 1
            y(k) = 1;
        elseif donnees(2*k-1) == 1 && donnees(2*k) == 0
            y(k) = 3;
        end
    end
    
end

