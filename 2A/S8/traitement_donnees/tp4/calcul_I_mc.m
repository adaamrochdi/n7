% function resultat = calcul_I_mc(I,centre,R,P_test)
%     P = centre + P_test;   
%     x = round(P(:,1));   y = round(P(:,2));
%     [H,W] = size(I);
%     inside = (x>=1 & x<=W & y>=1 & y<=H); 
%     in    = sub2ind([H W], y(inside), x(inside));
%     resultat = mean( I(in) );   
% end

function resultat = calcul_I_mc(I, centre, theta, a, b, P_test)
    R_theta = [cos(theta) -sin(theta); sin(theta) cos(theta)];
    P = centre + P_test * diag([a b]) * R_theta;
    x = round(P(:,1));
    y = round(P(:,2));
    [H,W] = size(I);
    inside = (x >= 1 & x <= W & y >= 1 & y <= H);
    in = sub2ind([H W], y(inside), x(inside));
    resultat = mean(I(in));
end