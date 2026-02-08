clear all;
close all;

Im1 = imread('1.pgm');
Im2 = imread('2.pgm');
Im3 = imread('3.pgm');
Im4 = imread('4.pgm'); 
Im1_coul = imread('1.jpg');
Im2_coul = imread('2.jpg');
Im3_coul = imread('3.jpg');
Im4_coul = imread('4.jpg'); 
% --- PARAMÈTRES ---
TailleFenetre = 15 ;
NbPoints = 450 ; 
k = 0.05;
seuil = 0.95;

[XY_1,Res_1] = harris(Im1,TailleFenetre,NbPoints,k);
[XY_2,Res_2] = harris(Im2,TailleFenetre,NbPoints,k);
[XY_3,Res_3] = harris(Im3,TailleFenetre,NbPoints,k);
[XY_4,Res_4] = harris(Im4,TailleFenetre,NbPoints,k); 

figure;
affichage_POI(Im1,XY_1,'POI Image 1',2,2,1);
affichage_POI(Im2,XY_2,'POI Image 2',2,2,2);
affichage_POI(Im3,XY_3,'POI Image 3',2,2,3);
affichage_POI(Im4,XY_4,'POI Image 4',2,2,4); 


% Paire 1: I1 <-> I2
[XY_C1_2,XY_C2_2] = apparier_POI(Im1,XY_1,Im2,XY_2,TailleFenetre,seuil);
H_1_2 = homographie(XY_C1_2, XY_C2_2);

% Paire 2: I2 <-> I3
[XY_C2_3,XY_C3_3] = apparier_POI(Im2,XY_2,Im3,XY_3,TailleFenetre,seuil);
H_2_3 = homographie(XY_C2_3, XY_C3_3);

% Paire 3: I3 <-> I4
[XY_C3_4,XY_C4_4] = apparier_POI(Im3,XY_3,Im4,XY_4,TailleFenetre,seuil);
H_3_4 = homographie(XY_C3_4, XY_C4_4); % Nouvelle homographie


% Images (Cell array)
I_list = {Im1_coul, Im2_coul, Im3_coul, Im4_coul};

% Homographies séquentielles (Cell array)
H_list = {H_1_2, H_2_3, H_3_4};



ImosN_coul = mosaiqueN(I_list, H_list); 

figure;
affichage_image(uint8(ImosN_coul),'Mosaique N=4 obtenue a partir des 4 images couleur',1,1,1);
