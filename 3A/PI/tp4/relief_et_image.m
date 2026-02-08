function relief_et_image(z,k)

[y,x] = meshgrid(1:size(z,2),1:size(z,1));
x_min = min(x(:));
x_max = max(x(:));
y_min = min(y(:));
y_max = max(y(:));

subplot(2,2,3);
surf(x,y,z,ones(size(z)));
shading flat;
colormap gray;
view(90,90);
camlight('headlight','infinite');
camlight('headlight','infinite');
view(25,10);
axis([x_min x_max y_min y_max 0 65]);
xlabel('$i$','Interpreter','Latex','Fontsize',30);
ylabel('$j$','Interpreter','Latex','Fontsize',30);
zlabel('$z_{i,j}$','Interpreter','Latex','Fontsize',30);
title(sprintf('Profondeur (iteration %d)',k),'Interpreter','Latex','Fontsize',30);

subplot(2,2,4);
surf(x,y,z,ones(size(z)));
shading flat;
colormap gray;
axis equal;
axis off;
material([0 1 0]);
view(90,90);
camlight('headlight','infinite');
camlight('headlight','infinite');
title(sprintf('Reeclairage (iteration %d)',k),'Interpreter','Latex','Fontsize',30);
