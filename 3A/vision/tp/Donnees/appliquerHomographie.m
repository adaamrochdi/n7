% Calcul des coordonnees (xy2) des points (xy1)
% apres application d'une homographique H

function [xy2] = appliquerHomographie(H,xy1)

% Entrees :
%
% H   : matrice (3x3) de l'homographie
% xy1 :  matrice (nbPoints x 2) representant les coordonnees 
%       (colonne 1 : les x, colonne 2 : les y) 
%       des nbPoints points auxquels H est appliquee
%
% Sortie :
% xy2 : coordonnees des points apres application de l'homographie
% Nombre de points
% ... A completer ...
[NbPoints, ~] = size(xy1);

% Construction des coordonnees homogenes pour appliquer l'homographie
% ... A completer ...

P1_hom = [xy1, ones(NbPoints, 1)]';
% Application de l'homographie
% ... A completer ...
P2_hom = H * P1_hom;


% On retourne les coordonnees homogenes (x,y,1)
% Pour cela, il faut diviser par z
% Attention il ne faut garder que les deux premieres coordonnees
% ... A completer ...
Z = P2_hom(3, :);
X_norm = P2_hom(1, :) ./ Z; 
Y_norm = P2_hom(2, :) ./ Z;

xy2 = [X_norm', Y_norm'];