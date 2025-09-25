Auteurs : ELMOSSLIH Amal & ROCHDI Adam

-------------------------------------------------------------------------------------------------

Pour kmeans : 

./bin/kmeans imageFilename k groundTruthFilename

Exemple d'éxecution : 
./bin/kmeans ../data/images/texture11.png 2 ../data/images/texture11_VT.png
./bin/kmeans ../data/images/texture3.png 2 ../data/images/texture3_VT.png
./bin/kmeans ../data/images/texture8.png 2 ../data/images/texture8_VT.png

Pour texture11.png et texture8.png, decommentez la ligne 111 pour inverser le positif et le négatif

---------------------------------------------------------------------------------------------------

Pour meanshift : 

./bin/meanshift imageFilename groundTruthFilename hs hc epsilon kmax

./bin/meanshift ../data/images/texture3.png ../data/images/texture3_VT.png 3 20 0.1 20
./bin/meanshift ../data/images/texture11.png ../data/images/texture11_VT.png 5 20 0.1 20
./bin/meanshift ../data/images/texture8.png ../data/images/texture8_VT.png 3 20 0.1 20


Pour hc grande, l'algorithme prend plus de temps car la probabilité pour que la condition lié à hc 
