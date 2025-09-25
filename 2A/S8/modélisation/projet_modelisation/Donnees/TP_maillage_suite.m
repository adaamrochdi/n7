

load donnees;
% Calcul des faces du maillage à garder
FACES = [];


F1 = tri(:, [1 2 3]);
F2 = tri(:, [1 2 4]);
F3 = tri(:, [1 3 4]);
F4 = tri(:, [2 3 4]);

FACES = [F1 ; F2 ; F3 ; F4];
FACES = sort(FACES,2);
FACES = sortrows(FACES,'ascend');
n = size(FACES, 1);

doublons = true(n,1);

for i=1:n-1
    if FACES(i,:) == FACES (i+1,:)
        doublons(i) = false;
        doublons(i+1) = false;
    end
end

FACES=FACES(doublons,:);

fprintf('Calcul du maillage final termine : %d faces. \n',size(FACES,1));

% Affichage du maillage final
figure;
hold on
for i = 1:size(FACES,1)
   plot3([X(1,FACES(i,1)) X(1,FACES(i,2))],[X(2,FACES(i,1)) X(2,FACES(i,2))],[X(3,FACES(i,1)) X(3,FACES(i,2))],'r');
   plot3([X(1,FACES(i,1)) X(1,FACES(i,3))],[X(2,FACES(i,1)) X(2,FACES(i,3))],[X(3,FACES(i,1)) X(3,FACES(i,3))],'r');
   plot3([X(1,FACES(i,3)) X(1,FACES(i,2))],[X(2,FACES(i,3)) X(2,FACES(i,2))],[X(3,FACES(i,3)) X(3,FACES(i,2))],'r');
end
hold off
view(3);