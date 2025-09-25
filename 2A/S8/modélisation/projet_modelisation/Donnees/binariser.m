function ImageBinaire = binariser(etiquettes,centres,seuil)
%BINARISER Summary of this function goes here
%Detailed explanation goes here
    nb_superpixels = size(centres,1);
    [n,m] = size(etiquettes);
    ImageBinaire = zeros(n,m);
    
    for i=1:nb_superpixels 
        mask = ( etiquettes == i);
        lab_color = reshape(centres(i, 1:3), [1 1 3]);
        rgb_color = lab2rgb(lab_color);
        red = round(rgb_color(1) * 255); 
        
        if red > seuil
            ImageBinaire(mask) = 255;
        end
    
    end
end