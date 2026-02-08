function affichage_resultat(t,R,P,couleurs_P,num_figure)

% Affichage des cameras :
taille_camera = 0.2;
if nargin == 5
	subplot(2,2,num_figure);
end
plotCamera('Size',taille_camera,'Color','r','Label','1','Opacity',0);
hold on;
grid on;
position = single(-R'*t);
orientation = single(R');
absPose = rigidtform3d(orientation,position);
plotCamera('AbsolutePose',absPose,'Size',taille_camera,...
	'Color','b','Label','2','Opacity',0);
axis off;

% Creation du nuage de points 3D et affichage du resultat :
nuage_P = pointCloud(transpose(P),'Color',couleurs_P);
pcshow(nuage_P,'VerticalAxis','y','VerticalAxisDir','down','MarkerSize',45);
