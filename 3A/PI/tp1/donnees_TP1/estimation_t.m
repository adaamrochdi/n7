function t_estim = estimation_t(E_estim,R_solution)

    t = R_solution' * E_estim;

    t_estim = [t(3,2) t(1,3) t(2,1)]';