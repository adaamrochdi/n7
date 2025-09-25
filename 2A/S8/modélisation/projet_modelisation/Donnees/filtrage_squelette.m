function [fx, fy] = filtrage_squelette(contour, masque)
    x = contour(:,2);  
    y = contour(:,1); 

    % diagramme de Voronoi
    [vx, vy] = voronoi(x, y);
    [h, w] = size(masque);
    vx1 = vx(1,:); vx2 = vx(2,:);
    vy1 = vy(1,:); vy2 = vy(2,:);
    fx = [];
    fy = [];
  
    for i = 1:length(vx1)
        x1 = round(vx1(i)); y1 = round(vy1(i));
        x2 = round(vx2(i)); y2 = round(vy2(i));
        % Vérification que les extrémités sont dans les dimensions de l'image
        if x1 < 1 || x1 > w || y1 < 1 || y1 > h || ...
           x2 < 1 || x2 > w || y2 < 1 || y2 > h
            continue;  
        end
        % (pixel = 1)
        if masque(y1, x1) == 1 && masque(y2, x2) == 1
            fx = [fx, [vx1(i); vx2(i)]];
            fy = [fy, [vy1(i); vy2(i)]];
        end
    end
end
