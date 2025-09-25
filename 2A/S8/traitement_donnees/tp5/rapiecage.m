function [u_k2,D2] = rapiecage(bornes_V_p,bornes_V_q_chapeau,u_k,D)

u_k2 = u_k;
D2 = D;
[n, m, ~] = size(u_k);

i_p = bornes_V_p(1);
j_p = bornes_V_p(2);
t = bornes_V_p(3);
i_q = bornes_V_q_chapeau(1);
j_q = bornes_V_q_chapeau(2);


for i=-t:t
    for j=-t:t
        if i_p + i <= n && j_p + j <= m && i_q + i <= n && j_q + j <= m
            if D(i_p + i, j_p + j)
                D2(i_p + i, j_p + j) = 0;
                u_k2(i_p + i, j_p + j,:) = u_k(i_q + i, j_q + j,:);
            end
        end
    end

end