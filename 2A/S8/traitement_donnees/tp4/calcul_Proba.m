function probas = probabilite(c,U_i,T,lambda,R)
N = size(c,1);
probas = zeros(N,1);
for i =1:(N-1)
    dist_matrix = sqrt(sum((c(i+1:end,:) -c(i,:)).^2,2));
    dist_matrix = dist_matrix<=(sqrt(2)*R);

    probas(i) = lambda/(lambda+ exp((-U_i(i) - sum(dist_matrix))/T));
end
dist_matrix = sqrt(sum((c(1:(N-1),:) -c(N,:)).^2,2));
dist_matrix = dist_matrix<=(sqrt(2)*R);
probas(N) = lambda/(lambda+ exp((-U_i(N) - sum(dist_matrix))/T));

end

