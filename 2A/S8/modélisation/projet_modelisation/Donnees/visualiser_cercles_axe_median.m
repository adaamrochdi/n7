function visualiser_cercles_axe_median(masque, pts, rayons)
    
    figure;
    imshow(masque);
    hold on;
    theta = linspace(0, 2*pi, 100);
    for i = 1:size(pts, 1)
        x = pts(i, 1) + rayons(i) * cos(theta);
        y = pts(i, 2) + rayons(i) * sin(theta);
        plot(x, y, 'r-', 'LineWidth', 0.5);
    end
    
    title('Axe médian avec cercles inscrits');
    hold off;
end