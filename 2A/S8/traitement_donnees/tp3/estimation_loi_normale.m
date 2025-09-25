function [moyenne, variance] = estimation_loi_normale(echantillons)

    moyenne = mean(echantillons);
    variance = var(echantillons, 1); 
end 
