function rayons = calculer_rayons(pts, contour)
    n_pts = size(pts, 1);
    rayons = zeros(n_pts, 1);
    for i = 1:n_pts
        distances = sqrt((pts(i,1) - contour(:,2)).^2 + (pts(i,2) - contour(:,1)).^2);
        rayons(i) = min(distances);
    end
end
