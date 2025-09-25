function f = retroprojection(sinogramme,theta,nb_rayons,nb_lignes,nb_colonnes)
    c=0;
    for i=1:nb_lignes
        for j=1:nb_colonnes
            x=j;
            y=-i;
            for k=1:180
                angle = deg2rad(theta(k));
                t = x*cos(angle) + y*sin(angle);

                
            end


        end
    end