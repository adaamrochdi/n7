function [pics_t, pics_f] = pics_spectraux(S, eta_t, eta_f, epsilon)

    voisinnage = ones(eta_f,eta_t);

    M= imdilate(S,voisinnage);

    masque = (S==M) & (S>epsilon);

    [pics_f, pics_t] = find(masque);

end