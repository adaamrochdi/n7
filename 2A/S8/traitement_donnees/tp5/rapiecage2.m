function [u_k2,D2,C2] = rapiecage2(bornes_V_p,bornes_V_q,u_k,D,C)

u_k2 = u_k;     D2 = D;     C2 = C;
[n,m,~] = size(u_k);

ip = bornes_V_p(1);   jp = bornes_V_p(2);   t = bornes_V_p(3);
iq = bornes_V_q(1);   jq = bornes_V_q(2);

for i = -t:t
    for j = -t:t
        ipi = ip+i;  jpj = jp+j;
        iqi = iq+i;  jqj = jq+j;

        if 1<=ipi && ipi<=n && 1<=jpj && jpj<=m && ...
           1<=iqi && iqi<=n && 1<=jqj && jqj<=m

            if D(ipi,jpj)          % seulement si pixel encore inconnu
                D2(ipi,jpj) = 0;   % on le marque comme rempli
                C2(ipi,jpj) = C(ip,jp);  % même confiance que le centre p*
                u_k2(ipi,jpj,:) = u_k(iqi,jqj,:);
            end
        end
    end
end
end
