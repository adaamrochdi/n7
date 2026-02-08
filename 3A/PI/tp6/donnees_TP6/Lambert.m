function rendus = Lambert(normales,albedos,eclairages)

[nb_pixels,nb_canaux] = size(albedos);
nb_eclairages = size(eclairages,1);
ombrage = max(0,normales*eclairages');
rendus = reshape(ombrage,nb_pixels,1,nb_eclairages).*reshape(albedos,nb_pixels,nb_canaux,1);
