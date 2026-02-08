function RI = selection_RI(image,L,H)

[nb_lignes,nb_colonnes,nb_canaux] = size(image);
figure('Name','Selection de la region d''interet','Position',[0.2*L,0,0.6*L,0.5*H]);
imagesc(image);
axis equal;
axis off;

disp('Cliquez pour determiner la region d''interet');
[x_r,y_r] = ginput(2);
i_r = min(max(round(y_r),1),nb_lignes);
j_r = min(max(round(x_r),1),nb_colonnes);
j_min = min(j_r(:));
j_max = max(j_r(:));
i_min = min(i_r(:));
i_max = max(i_r(:));
line([j_min j_max],[i_min,i_min],'Color','r','LineWidth',2);
line([j_min j_max],[i_max,i_max],'Color','r','LineWidth',2);
line([j_min j_min],[i_min,i_max],'Color','r','LineWidth',2);
line([j_max j_max],[i_min,i_max],'Color','r','LineWidth',2);
drawnow;

RI = [j_min,i_min,j_max-j_min,i_max-i_min];
