
% TP Codages JPEG et MPEG-2 - 3SN-M - 2022
                                               
%--------------------------------------------------------------------------
% Fonction de transformee (directe et inverse) en cosinus discrete par blocs
%--------------------------------------------------------------------------
% I_DCT = DCT2DParBlocs(sens,I,methode,taille_bloc)
%
% sortie  : I_DCT = image de la DCT ou IDCT par blocs
% 
% entrees : sens = sens pour la DCT : 'Direct' ou 'Inverse'
%           I = image avant DCT ou IDCT par blocs
%           methode = methode de calcul de la DCT : 'Matlab' ou 'Rapide'
%           taille_bloc = taille des blocs pour la DCT (ici 8x8)
%--------------------------------------------------------------------------

function I_DCT = DCT2DParBlocs(sens,I,methode,taille_bloc)
    [a,b] = size(I);
    for i = 1:taille_bloc:a
        for j = 1:taille_bloc:b
            row_end = min(i + taille_bloc - 1, a);
            col_end = min(j + taille_bloc-1, b);
            block = I(i:row_end, j:col_end);
            I_DCT(i:row_end, j:col_end) = dct2(block, taille_bloc, taille_bloc);     
        end
    end

end
  
%--------------------------------------------------------------------------
% Fonction de calcul de transformee en cosinus discrete rapide 
% pour un bloc de taille 8x8
%--------------------------------------------------------------------------
% Bloc_DCT2 = DCT2Rapide(Bloc_Origine, taille_bloc)
%
% sortie  : Bloc_DCT2 = DCT du bloc
% 
% entrees : Bloc_Origine = Bloc d'origine
%           taille_bloc = taille des blocs pour la DCT (ici 8x8)
%--------------------------------------------------------------------------
function Bloc_DCT2 = DCT2Rapide(Bloc_Origine,taille_bloc)
    


end

%--------------------------------------------------------------------------
% Fonction de calcul de transformee en cosinus discrete inverse rapide
% pour un bloc de taille 8x8
%--------------------------------------------------------------------------
% Bloc_IDCT2 = IDCT2Rapide(Bloc_DCT2,taille_bloc)
%
% sortie  : Bloc_IDCT2 = Bloc reconstruit par DCT inverse
% 
% entrees : Bloc_DCT2 = DCT du bloc 
%           taille_bloc = taille des blocs pour la DCT (ici 8x8)
%--------------------------------------------------------------------------

function Bloc_IDCT2 = IDCT2Rapide(Bloc_DCT2,taille_bloc)
    


end