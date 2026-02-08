function z = lax_friedrichs(z_k_moins_1, I, masque)

    a = 0.5;


    f = sqrt( (1./I).^2 - 1 );  
    z = z_k_moins_1;


    z_up    = [z(1,:);     z(1:end-1,:)];
    z_down  = [z(2:end,:); z(end,:)];

    z_left  = [z(:,1),     z(:,1:end-1)];
    z_right = [z(:,2:end), z(:,end)];


    z_total = (z_up + z_down + z_left + z_right) / 4;

    dzdj = (z_right - z_left) / 2;
    dzdi = (z_down  - z_up)   / 2;
    grad_norm = sqrt(dzdj.^2 + dzdi.^2);

    z2 = z_total + a * (f - grad_norm);

    z(~masque) = z_k_moins_1(~masque);
    z(masque)  = z2(masque);
end
