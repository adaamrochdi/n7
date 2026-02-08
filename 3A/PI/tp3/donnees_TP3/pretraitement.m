function image_sortie = pretraitement(image_entree)

image_sortie = cat(3,...
	image_entree([1 1:end-1],[1 1:end-1]),...	% Nord-Ouest
	image_entree([1 1:end-1],:),...			% Nord
	image_entree([1 1:end-1],[2:end end]),...	% Nord-Est
	image_entree(:,[1 1:end-1]),...			% Ouest
	image_entree,...				% Centre
	image_entree(:,[2:end end]),...			% Est
	image_entree([2:end end],[1 1:end-1]),...	% Sud-Ouest
	image_entree([2:end end],:),...			% Sud
	image_entree([2:end end],[2:end end]));		% Sud-Est
