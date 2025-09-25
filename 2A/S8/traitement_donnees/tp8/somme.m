% 1) Chargez
S = im2double(imread('Images/structure.png'));   % peut être M×N×3 ou M×N×1
T = im2double(imread('Images/texture.png'));

% 2) Affichez leurs tailles pour comprendre la différence
disp(size(S));
disp(size(T));

% 3) Si la résolution diffère, redimensionnez la texture pour qu'elle corresponde
if any(size(T,1:2) ~= size(S,1:2))
    T = imresize(T, [size(S,1) size(S,2)]);
end

% 4) Si le nombre de canaux (3 couleurs vs. 1 niveau de gris) diffère, adaptez-le
if size(T,3) ~= size(S,3)
    if size(T,3)==1 && size(S,3)==3
        T = repmat(T,1,1,3);      % transformer gris→RGB
    elseif size(T,3)==3 && size(S,3)==1
        S = rgb2gray(S);          % ou S = mean(S,3); pour passer RGB→gris
    end
end

% 5) On peut maintenant mélanger sans assert
alpha = 0.5;
Styl = alpha*S + (1-alpha)*T;
Styl = max(0,min(1,Styl));
figure, imshow(Styl), title('Stylized');
imwrite(Styl,'stylized.png');
