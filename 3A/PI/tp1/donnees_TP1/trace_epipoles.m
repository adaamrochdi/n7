function trace_epipoles(L,H,p1_tilde_estim,p2_tilde_estim,F_estim,I1,I2)

[nb_lignes,nb_colonnes,nb_canaux] = size(I1);
decalage_bord = 500;
I_bord = 240*ones(nb_lignes,decalage_bord,3);
decalage_milieu = 1200;
I_milieu = 240*ones(nb_lignes,decalage_milieu,3);

figure('Name','Trace des epipoles','Position',[0.1*L,0.4*H,0.8*L,0.5*H]);
imagesc(cat(2,I_bord,I1,I_milieu,I2,I_bord));
axis equal;
axis image off;
hold on;

for k = 1:8

	% Trace d'un point de l'image gauche :
	p1_tilde_k = p1_tilde_estim(:,k);
	scatter(p1_tilde_k(1)+decalage_bord,p1_tilde_k(2),'r','filled');
	hold on;

	% Trace de la droite epipolaire correspondante :
	D2 = F_estim*p1_tilde_k;
	x_trace = -decalage_bord:nb_colonnes+decalage_bord;
	y_trace = -D2(1)/D2(2)*x_trace-D2(3)/D2(2);
	indices = find(y_trace>0 & y_trace<nb_lignes);
	x_trace = x_trace(indices);
	y_trace = y_trace(indices);
	plot(x_trace+decalage_bord+nb_colonnes+decalage_milieu,y_trace,'LineWidth',1,'Color','g');

	% Trace d'un point de l'image droite :
	p2_tilde_k = p2_tilde_estim(:,k);
	scatter(p2_tilde_k(1)+decalage_bord+nb_colonnes+decalage_milieu,p2_tilde_k(2),'g','filled');

	% Trace de la droite epipolaire correspondante :
	D1 = F_estim'*p2_tilde_k;
	x_trace = -decalage_bord:nb_colonnes+decalage_bord;
	y_trace = -D1(1)/D1(2)*x_trace-D1(3)/D1(2);
	indices = find(y_trace>0 & y_trace<nb_lignes);
	x_trace = x_trace(indices);
	y_trace = y_trace(indices);
	plot(x_trace+decalage_bord,y_trace,'LineWidth',1,'Color','r');
end
