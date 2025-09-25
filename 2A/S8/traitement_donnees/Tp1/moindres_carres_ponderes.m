function X = moindres_carres_ponderes(D_app, probas)
    x = D_app(1, :);
    y = D_app(2, :);
    A = [x.^2; x.*y; y.^2; x; y; ones(size(x))]';

    W = diag(probas);

    X = (A' * W * A) \ (A' * W * zeros(size(x))');

    X = X / (X(1) + X(3));
end
