function donnees = ASK4demap(y)

    donnees = zeros(1, 2*length(y));
    for k = 1:length(y)
        if y(k) < -2
            donnees(2*k-1) = 0;
            donnees(2*k) = 0;
        elseif y(k) >= -2 && y(k) < 0
            donnees(2*k-1) = 0;
            donnees(2*k) = 1;
        elseif y(k) >= 0 && y(k) < 2
            donnees(2*k-1) = 1;
            donnees(2*k) = 1;
        else
            donnees(2*k-1) = 1;
            donnees(2*k) = 0;
        end
    end
    
end

