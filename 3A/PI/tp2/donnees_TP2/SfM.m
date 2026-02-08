clear;
close all;
taille_ecran = get(0,'ScreenSize');
L = taille_ecran(3);
H = taille_ecran(4);

load Fontaine/matrice_K;

% Lecture des images :
n = 4;
for i = 1:n
	nom_fichier = strcat('Fontaine/im',int2str(i),'.png');
	images{i} = imread(nom_fichier);
end

% Couleurs des n cameras (et des n-1 nuages de points 3D) :
couleurs_cameras = uint8([ 255 0 0 ; 0 255 0 ; 0 0 255 ; 255 255 255 ]);
couleurs_cameras = transpose(couleurs_cameras);

% SfM :
t = [];
R = [];
P = [];
couleurs_P = [];
for i = 1:n-1

	% Paire d'images courante :
	I1_i = images{i};
	I2_i = images{i+1};

	% Detection des points d'interet dans l'image gauche :
	RI1_i = selection_RI(I1_i,L,H);
	p1_interet_i = detectMinEigenFeatures(rgb2gray(I1_i),'ROI',RI1_i,'MinQuality',0.0001);

	% Mise en correspondance des points d'interet :
	traqueur = vision.PointTracker('MaxBidirectionalError',1,'NumPyramidLevels',5);
	p1_interet_i = p1_interet_i.Location;
	initialize(traqueur,p1_interet_i,I1_i);
	[p2_interet_i,indices_droite] = step(traqueur,I2_i);
	p1_i = transpose(p1_interet_i(indices_droite,:));
	p2_i = transpose(p2_interet_i(indices_droite,:));
	nb_paires_i = size(p1_i,2);

	% Coordonnees homogenes des pixels apparies :
	p1_tilde_i = [p1_i ; ones(1,nb_paires_i)];
	p2_tilde_i = [p2_i ; ones(1,nb_paires_i)];

	% Variables utiles pour l'exercice 3 :
	p1_tilde{i} = p1_tilde_i;
	p2_tilde{i} = p2_tilde_i;

	% Points 3D q :
	inverse_K = inv(K);
	q1_i = inverse_K*p1_tilde_i;
	q2_i = inverse_K*p2_tilde_i;

	% S'il y a trop de paires, on n'en conserve que 10000 :
	nb_paires_i_majore = min(nb_paires_i,10000);
	indices = randperm(nb_paires_i);
	indices_selection = indices(1:nb_paires_i_majore);
	q1_i_selection = q1_i(:,indices_selection);
	q2_i_selection = q2_i(:,indices_selection);

	% Estimation robuste de E :
	[~,E_i] = estimation_E_robuste(q1_i_selection,q2_i_selection,K);

	% Estimation du changement de pose (4 solutions) :
	[t_4_i,R_4_i] = estimation_4_poses(E_i);

	% Reconstruction 3D correspondant aux 4 solutions :
	P_4_i = zeros(3,nb_paires_i_majore,4);
	for j = 1:4
		t_j = t_4_i(:,j);
		R_j = R_4_i(:,:,j);
		P_j = reconstruction_3D(q1_i_selection,q2_i_selection,t_j,R_j);
		P_4_i(:,:,j) = P_j;
	end

	% Estimation de la "bonne" pose :
	[t_i,R_i,P_i] = estimation_bonne_pose(t_4_i,R_4_i,P_4_i);
	t = [t,t_i];
	R = cat(3,R,R_i);

	% Points 3D reconstruits, exprimes dans le repere de la camera i+1 :
	if i==1
		P = P_i;
	else	
		P = [ R_i*P+repmat(t_i,1,size(P,2)) P_i ];
	end

	% Couleur affectee au i-eme nuage de points 3D :
	couleurs_P = [ couleurs_P repmat(couleurs_cameras(:,i),1,size(P_i,2)) ];
end

% Affichage du resultat :
close all;
figure('Name','Reconstruction 3D par SfM','Position',[0.1*L,0,0.8*L,H]);
t_cameras = zeros(3,1);
R_cameras = eye(3);
for i = 2:n
	R_cameras(:,:,i) = R(:,:,n-i+1)'*R_cameras(:,:,i-1);
	t_cameras(:,i) = -R_cameras(:,:,i)*t(:,n-i+1)+t_cameras(:,i-1);
end
affichage_SfM(t_cameras,R_cameras,couleurs_cameras,P,couleurs_P);

save exercice_2;
