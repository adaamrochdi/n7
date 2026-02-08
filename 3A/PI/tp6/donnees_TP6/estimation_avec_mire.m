function [theta,rho,psi] = estimation_avec_mire(images,normales) 
   
    lights = pinv(normales) * images;
    psi = sqrt(sum(lights.^2,1));
    lighs_norm = lights ./ repmat(psi,3,1);
    [theta, rho ] = cart2pol(lighs_norm(1,:),lighs_norm(2,:));


end