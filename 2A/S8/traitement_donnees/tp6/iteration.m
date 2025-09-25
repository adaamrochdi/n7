function [x,y] = iteration(x,y,Fx,Fy,gamma,A)
    
    x_round = round(x);
    y_round = round(y);

    Bx= -gamma * Fx(sub2ind(size(Fx),y_round,x_round));
    By= -gamma * Fy(sub2ind(size(Fy),y_round,x_round));
    
    x = A*x + Bx;
    y = A*y + By;

