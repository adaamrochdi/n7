function I_segmentee = segmenter(I, centres, etiquettes)
    [n_lignes, n_colonnes, k] = size(I);
    I_segmentee = zeros(n_lignes, n_colonnes, 3);
    nb_superpixels = size(centres, 1);
    
    for i = 1:nb_superpixels
        mask = etiquettes == i;
        
        for c = 1:k  
            I_segmentee(:,:,c) = I_segmentee(:,:,c) + mask * centres(i, c);
        end
    end
    
    figure;
    imshow(lab2rgb(I_segmentee));
    title('Image segmentée à partir des superpixels');
    drawnow;
end



