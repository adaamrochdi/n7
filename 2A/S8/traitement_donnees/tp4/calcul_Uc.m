function U_i = u_ci(gama,S ,I_moyen)
U_i = 1 - (2./(1  + exp(-gama * ((I_moyen / S) -1))));
end

