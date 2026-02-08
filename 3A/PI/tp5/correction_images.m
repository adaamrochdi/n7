function I_corrige = correction_images(I)
    
    [U ,W ,V] = svds(I,3);

    I_corrige = U * W * V' ;
end
    