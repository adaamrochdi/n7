function affichage_MVS(M_ref,K,z,I_ref)

% Erosion du masque (pour tenir compte des fenetres 3 x 3) :
M_ref_9 = pretraitement(M_ref);
M_ref = sum(M_ref_9,3);
M_ref = M_ref>=9;

% Dimensions du masque :
[nb_lignes,nb_colonnes] = size(M_ref);
nb_pixels = nb_lignes*nb_colonnes;

% Indices des pixels du masque :
ind_M_ref = transpose(find(M_ref>0));
[i_M_ref,j_M_ref] = ind2sub(size(M_ref),ind_M_ref);

% Passage du repere pixels au repere image :
u_M_ref = j_M_ref;
v_M_ref = i_M_ref;
p_tilde = [ u_M_ref ; v_M_ref ; ones(1,length(ind_M_ref)) ];
q = inv(K)*p_tilde;

% Lissage median de la fontaine :
if nargin == 4
	z_image = zeros(nb_pixels,1);
	z_image(ind_M_ref) = z;
	z_image = reshape(z_image,nb_lignes,nb_colonnes);
	z_image_lissee = medfilt2(z_image,[3 3]);
	z_lissee = z_image_lissee(ind_M_ref);
	z = z_lissee(:);
end

% Calcul et affichage des points 3D :
P = NaN*ones(nb_pixels,3);
P(ind_M_ref,:) = q'.*repmat(z,1,3);
P = reshape(P,[nb_lignes nb_colonnes 3]);
if nargin == 3
	surfl(P(:,:,1),P(:,:,2),-P(:,:,3),[0 90]);
	shading flat;
	colormap gray;
	axis ij;
	axis tight;
	rotate3d;

else
	couleurs_P = reshape(uint8(255*I_ref),[nb_pixels,3]);
	nuage_P = pointCloud(reshape(P,[nb_pixels,3]),'Color',couleurs_P);
	pcshow(nuage_P,'VerticalAxis','y','VerticalAxisDir','down','MarkerSize',45);
end
axis equal;
axis off;
