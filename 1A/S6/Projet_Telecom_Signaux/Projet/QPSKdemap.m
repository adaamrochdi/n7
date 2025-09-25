function donnees = QPSKdemap(y)

    donnees = zeros(1, 2*length(y));
    for k = 1:length(y)
        if real(y(k)) > 0
            donnees(2*k-1) = 1;
            if imag(y(k)) > 0
                donnees( 2*k ) = 1;
            else
                donnees( 2*k ) = 0;
            end
        else
            donnees(2*k-1) = 0;
            if imag(y(k)) > 0
                donnees( 2*k ) = 1;
            else
                donnees( 2*k ) = 0;
            end
        end
    end
    
end
