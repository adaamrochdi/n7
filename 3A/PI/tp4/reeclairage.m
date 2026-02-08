function reeclairage(z)

% Fenetre d'affichage :
[nb_lignes,nb_colonnes] = size(z);
[x,y] = meshgrid(1:nb_colonnes,1:nb_lignes); 
surf(x,y,fliplr(z),ones(size(z)));
shading flat;
colormap gray;
axis equal;
axis off;
material([0 1 0]);
view(180,90);
h1 = camlight('headlight','infinite');
h2 = camlight('headlight','infinite');

% Modification du point de vue :
temps_pause = 0.05;
valeurs_az = -200:0.5:-180;
valeurs_el = 50:1:90;
for k = 1:length(valeurs_az)
	az = valeurs_az(k);
	el = valeurs_el(k);
	view(az,el);
	if k==1
		pause(10*temps_pause);
	else
		pause(2*temps_pause);
	end
end

% Modification de l'eclairage :
valeurs_el = 90:-1:54;
valeurs_az = 180:-5:0;
for k = 1:length(valeurs_az)
	az = valeurs_az(k);
	el = valeurs_el(k);
	lightangle(h1,az,el);
	lightangle(h2,az,el);
	pause(temps_pause);
end
valeurs_el = 54:2:90;
for k = 1:length(valeurs_el)
	az = 0;
	el = valeurs_el(k);
	lightangle(h1,az,el);
	lightangle(h2,az,el);
	pause(temps_pause);
end
rotate3d;
