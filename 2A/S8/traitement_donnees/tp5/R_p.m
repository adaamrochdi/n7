function [R_p_i, R_p_j] = R_p(i_p, j_p, t, D)

[m,n] = size(D);

V_p_in_D = D(max(1,(i_p - t)):min((i_p + t),m), max(1,(j_p - t)):min(n,(j_p + t)));
V_p_out_of_D = ~V_p_in_D;
[R_p_i, R_p_j] = ind2sub(size(V_p_in_D), find(V_p_out_of_D));
R_p_i = R_p_i - (t+1);
R_p_j = R_p_j - (t+1);

end