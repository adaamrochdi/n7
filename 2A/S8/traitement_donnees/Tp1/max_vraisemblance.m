function parametres_MV = max_vraisemblance(D_app, parametres_test)

% On va chercher les parametres qui minimisent le r (calcul_rd) 

nb_tirages = size(parametres_test, 1);
table = zeros(nb_tirages,1);
for i = 1:nb_tirages
        parametres = parametres_test(i, :);
        r = calcul_r(D_app, parametres);
        table(i) = sum(r.^2);
end
[ r_min , indice_min]= min(table);


disp(r_min);
parametres_MV = parametres_test(indice_min,:);