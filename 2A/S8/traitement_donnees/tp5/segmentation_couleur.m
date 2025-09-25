function D = segmentation_couleur(u_0)
    red = u_0(:,:,1) > 245;
    green = u_0(:,:,2) > 245;
    blue = u_0(:,:,3) < 10;

    D = red .* green .* blue;
end
