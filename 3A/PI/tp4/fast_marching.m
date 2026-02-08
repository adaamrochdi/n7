function z = fast_marching(calcules, proches, front, M_voisins, M_delta_z, z)

    z = z(:);
    N = numel(z);

    it = 0;

    while any(proches)

        %étape 1 : p de la classe P de plus faible profondeur
        ind = find(proches);
        disp(size(ind));
        [~,kmin] = min(z(ind));
        ind_p = ind(kmin);


        %étape 2 : enlever de proche et ajouter dans calculs
        proches(ind_p)  = 0;
        calcules(ind_p) = 1;
        

        voisins_p = find(M_voisins(:,ind_p));          
        voisins_deja_dans_P = voisins_p(proches(voisins_p));

 
      
    end