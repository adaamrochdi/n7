function paires = appariement(pics_t, pics_f, n_v, delta_t, delta_f)
    
   paires =[];

   for i= 1:length(pics_t)
        ti=pics_t(i);
        fi=pics_f(i);

        cond_1 = (pics_t > ti) &  ( (pics_t - ti) <= delta_t ) ;
        cond_2 = abs(pics_f - fi) <= delta_f ;

        voisins = find (cond_1 & cond_2 , n_v);

        for j = 1:length(voisins)
            idx = voisins(j); 
            tj = pics_t(idx);
            fj = pics_f(idx);

            paire = [fi, fj, ti, tj];
            paires = [paires; paire];
        end
   end