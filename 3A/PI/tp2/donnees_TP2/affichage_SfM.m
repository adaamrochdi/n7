function affichage_SfM(t_cameras,R_cameras,couleurs_cameras,P,couleurs_P)

% Affichage des cameras :
taille_camera = 0.5;
for i = 1:size(t_cameras,2)
	t_i = t_cameras(:,i);
	R_i = R_cameras(:,:,i);
	position = single(t_i'*R_i);		% Matlab a sa propre logique !
	orientation = single(R_i');
	absPose = rigid3d(orientation,position);
	if nargin==5
		plotCamera('AbsolutePose',absPose,'Size',taille_camera,...
			'Color',couleurs_cameras(:,i),'Label',num2str(i),'Opacity',0);
	else
		plotCamera('AbsolutePose',absPose,'Size',taille_camera,...
			'Color','b','Label',num2str(i),'Opacity',0);
	end		
	hold on;
end
grid on;
axis off;

% Creation du nuage de points 3D et affichage du resultat :
nuage_P = pointCloud(transpose(P),'Color',transpose(couleurs_P));
pcshow(nuage_P,'VerticalAxis','y','VerticalAxisDir','down','MarkerSize',45);
