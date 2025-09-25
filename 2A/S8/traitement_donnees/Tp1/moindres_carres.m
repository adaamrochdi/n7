function X = moindres_carres(D_app)

x = D_app(:,1);
y = D_app(:,2);
nb_app = size(D_app,1); 
A = zeros(nb_app + 1, 6);

for i = 1:nb_app
    A(i,:) = [x(i)^2, x(i)*y(i), y(i)^2, x(i), y(i), 1];
end

A(nb_app + 1, :) = [1, 0, 1, 0, 0, 0]; 
zero = zeros(nb_app + 1, 1);
zero(nb_app + 1) = 1;

X = A\zero;
end