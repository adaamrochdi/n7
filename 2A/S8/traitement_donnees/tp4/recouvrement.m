function recv = recouvrement(c,theta,c_i,theta_i,a,b)

N_points = 1000;

x0 = c_i(1);
y0 = c_i(2);

random_pts_x = x0 - a/2 + a * rand(N_points, 1);
random_pts_y = y0 - a/2 + a * rand(N_points, 1);
pts = [random_pts_x random_pts_y];

inside_i = ((pts(:,1)-x0)*cos(theta_i) + (pts(:,2)-y0)*sin(theta_i)).^2/(a^2) + ...
((pts(:,1)-x0)*sin(theta_i) - (pts(:,2)-y0)*cos(theta_i)).^2/(b^2) <= 1;
N_pts_inside_i = sum(inside_i);

inside = sum(((pts(:,1)-c(:,1)').*cos(theta)' + (pts(:,2)-c(:,2)').*sin(theta)').^2/(a^2) + ...
((pts(:,1)-c(:,1)').*sin(theta)' - (pts(:,2)-c(:,2)').*cos(theta)').^2/(b^2) <=1, 1);

inside_both = inside .* inside_i;
N_pts_inside_both = sum(inside_both, 1);

recv = sum((N_pts_inside_both / N_pts_inside_i) > 0.2, 2) - 1;


end