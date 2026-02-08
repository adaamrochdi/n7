clear;
close all;

load exercice_2;

% SfM :
P = [];
couleurs_P = [];
for i = 1:n-1

	% Changement de pose (echelle de t_i arbitraire) :
	t_i = t(:,i);
	R_i = R(:,:,i);

	% Coordonnees homogenes des pixels apparies :
	p1_tilde_i = p1_tilde{i};
	p2_tilde_i = p2_tilde{i};

	% Points 3D q :
	q1_i = inverse_K*p1_tilde_i;
	q2_i = inverse_K*p2_tilde_i;

	% Estimation de l'echelle :
	if i>1
		% Paires de points d'interet de la paire d'images {I_{i-1},I_i}} :
		p2_tilde_i_moins_1 = p2_tilde{i-1};
		[~,ind_i_moins_1,ind_i] = intersect(round(p2_tilde_i_moins_1'),round(p1_tilde_i'),'rows');

		% Estimation du facteur d'echelle :
		alpha_i = estimation_echelle(t_i,R_i,P_i_moins_1(:,ind_i_moins_1),q2_i(:,ind_i));
		t_i = alpha_i*t_i;
	end

	% Mise a jour de l'echelle de t_i :
	t(:,i) = t_i;

	% Reconstruction 3D (methode "du point milieu", cf. TP1) :
	P_i = reconstruction_3D(q1_i,q2_i,t_i,R_i);

	% Points 3D reconstruits, exprimes dans le repere de la camera i+1 :
	if i==1
		P = P_i;
	else
		P = [ R_i*P+repmat(t_i,1,size(P,2)) P_i ];
	end
	P_i_moins_1 = P_i;

	% La couleur d'un point 3D est sa couleur dans l'image gauche :
	I1_i = images{i};
	for k = 1:size(p1_tilde_i,2)
		currentColor = I1_i(round(p1_tilde_i(2,k)),round(p1_tilde_i(1,k)),:);
		couleurs_P = [ couleurs_P reshape(currentColor,3,1) ];
	end
end

% Affichage du resultat :
figure('Name','Reconstruction 3D par SfM','Position',[0.1*L,0,0.8*L,H]);
t_cameras = zeros(3,1);
R_cameras = eye(3);
for i = 2:n
	R_cameras(:,:,i) = R(:,:,n-i+1)'*R_cameras(:,:,i-1);
	t_cameras(:,i) = -R_cameras(:,:,i)*t(:,n-i+1)+t_cameras(:,i-1);
end
affichage_SfM(t_cameras,R_cameras,couleurs_cameras,P,couleurs_P);
