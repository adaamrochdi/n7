function affichage_modele_3D(rho_estime,z_estime)

h = surf(fliplr(z_estime));
title('Modele 3D','FontSize',20);
set(h,'CData',fliplr(rho_estime),'FaceColor','texturemap','EdgeColor','none');
zdir = [1 0 0];
rotate(h,zdir,90);
zdir = [0 1 0];
rotate(h,zdir,180);
zdir = [1 0 0];
rotate(h,zdir,-90);
shading flat;
colormap gray;
axis equal;
axis off;
view(-44,42);				% Direction d'observation
rotate3d;
