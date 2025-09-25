#include "ocv_utils.hpp"

#include <opencv2/core.hpp>
#include <opencv2/imgcodecs.hpp>
#include <opencv2/highgui.hpp>
#include <opencv2/imgproc.hpp>
#include <iostream>
#include <cfloat>
#include <cstdlib>
#include <ctime>

using namespace cv;
using namespace std;

void printHelp(const string& progName)
{
    cout << "Usage:\n\t" << progName << " <image_file> [<image_ground_truth>] <hs> <hc> <epsilon> <kmax>" << endl;
}

void evaluer_segmentation(float &P, float &S, float &DSC, const cv::Mat& labels, const cv::Mat& labelsvt) {
    int TP = 0;
    int FP = 0;
    int TN = 0;
    int FN = 0;

    for (int i = 0; i < labels.rows; i++) {
        for (int j = 0; j < labels.cols; j++) {
            if (labels.at<uchar>(i, j) == 0 && labelsvt.at<uchar>(i, j) == 0) {
                TN++;
            } else if (labels.at<uchar>(i, j) != 0 && labelsvt.at<uchar>(i, j) != 0) {
                TP++;
            } else if (labels.at<uchar>(i, j) == 0 && labelsvt.at<uchar>(i, j) != 0) {
                FP++;
            } else {
                FN++;
            }
        }
    }

    if ((TP + FP) == 0) {
        P = 0;
    } else {
        P = static_cast<float>(TP) / (TP + FP);
    }

    if ((TP + FN) == 0) {
        S = 0;
    } else {
        S = static_cast<float>(TP) / (TP + FN);
    }

    if ((2 * TP + FP + FN) == 0) {
        DSC = 0;
    } else {
        DSC = static_cast<float>(2 * TP) / (2 * TP + FP + FN);
    }
}

// Calcule la moyenne des couleurs dans une fenêtre centrée sur le pixel x.
// Seuls les pixels dont la distance couleur est inférieure à hc sont inclus.
Vec3f calculer_Moyenne(const Mat& image, Point x, int hs, float hc) {
    Vec3f somme(0, 0, 0);
    int nx = 0; // Nombre de pixels pris en compte dans la fenêtre

    Vec3b couleur_x = image.at<Vec3b>(x);

    // Parcours de la fenêtre autour du pixel (x)
    for (int y = max(0, x.y - hs); y <= min(image.rows - 1, x.y + hs); y++) {
        for (int x_col = max(0, x.x - hs); x_col <= min(image.cols - 1, x.x + hs); x_col++) {
            Vec3b couleur_xi = image.at<Vec3b>(y, x_col);
            float dist_color = sqrt(pow(couleur_xi[0] - couleur_x[0], 2) +
                                    pow(couleur_xi[1] - couleur_x[1], 2) +
                                    pow(couleur_xi[2] - couleur_x[2], 2));
            if (dist_color <= hc) {
                somme[0] += couleur_xi[0];
                somme[1] += couleur_xi[1];
                somme[2] += couleur_xi[2];
                nx++;
            }
        }
    }

    // Calcul de la moyenne si des pixels ont été pris en compte, sinon conserver la couleur d'origine
    if (nx > 0) {
        somme[0] /= nx;
        somme[1] /= nx;
        somme[2] /= nx;
    } else {
        somme[0] = couleur_x[0];
        somme[1] = couleur_x[1];
        somme[2] = couleur_x[2];
    }
    return somme;
}

// Vérifie la convergence entre deux images en comparant la couleur de chaque pixel.
// Si la différence pour un pixel dépasse epsilon, la convergence n'est pas atteinte.
bool Convergence(const Mat& image_precedente, const Mat& image_courante, float epsilon) {
    for (int y = 0; y < image_precedente.rows; y++) {
        for (int x = 0; x < image_precedente.cols; x++) {
            Vec3b couleur_precedente = image_precedente.at<Vec3b>(y, x);
            Vec3b nouvelle_couleur = image_courante.at<Vec3b>(y, x);
            float dist = sqrt(pow(nouvelle_couleur[0] - couleur_precedente[0], 2) +
                              pow(nouvelle_couleur[1] - couleur_precedente[1], 2) +
                              pow(nouvelle_couleur[2] - couleur_precedente[2], 2));
            if (dist > epsilon) {
                return false;
            }
        }
    }
    return true;
}

// Implémentation de l'algorithme Mean-Shift .
void meanshift(const Mat& image, int hs, float hc, float epsilon, int kmax, Mat& resultat) {
    int k = 1;
    Mat image_courante = image.clone();
    Mat image_precedente;
    bool convergence;
    
    do {
        image_precedente = image_courante.clone();
        cout << "Itération : " << k << endl;
        for (int y = 0; y < image.rows; y++) {
            for (int x = 0; x < image.cols; x++) {
                Point position(x, y);
                // Met à jour la couleur du pixel avec la moyenne locale filtrée par hs et hc
                Vec3f Mh_x = calculer_Moyenne(image_precedente, position, hs, hc);
                image_courante.at<Vec3b>(y, x) = Vec3b(static_cast<uchar>(Mh_x[0]),
                                                       static_cast<uchar>(Mh_x[1]),
                                                       static_cast<uchar>(Mh_x[2]));
            }
        }
        
        convergence = Convergence(image_precedente, image_courante, epsilon);
        k++;
        
    } while (!convergence && k <= kmax);
    
    cout << "Nombre total d'itérations : " << k - 1 << endl;
    resultat = image_courante.clone();
}



int main(int argc, char** argv)
{
    if (argc != 5 && argc != 7) {
        cout << "Nombre d'arguments incorrect." << endl;
        printHelp(string(argv[0]));
        return EXIT_FAILURE;
    }
    
    srand(static_cast<unsigned int>(time(0)));
    
    string imageFilename;
    string groundTruthFilename;
    int hs;
    float hc;
    float epsilon = 0.00001; // Valeur par défaut
    int kmax = 30;           // Valeur par défaut
    
    if (argc == 7) {
        imageFilename = argv[1];
        groundTruthFilename = argv[2];
        hs = stoi(argv[3]);
        hc = stof(argv[4]);
        epsilon = stof(argv[5]);
        kmax = stoi(argv[6]);
    } else if (argc == 5) {
        imageFilename = argv[1];
        groundTruthFilename = "";
        hs = stoi(argv[2]);
        hc = stof(argv[3]);
        epsilon = stof(argv[4]);
    }
    
    cout << "Program called with the following arguments :" << endl;
    cout << "\tImage : " << imageFilename << endl;
    if (!groundTruthFilename.empty())
        cout << "\tGround truth segmentation : " << groundTruthFilename << endl;
    cout << "\ths : " << hs << endl;
    cout << "\thc : " << hc << endl;
    cout << "\tepsilon : " << epsilon << endl;
    cout << "\tkmax : " << kmax << endl;
    
    Mat vt= imread(groundTruthFilename, IMREAD_GRAYSCALE);
   
    Mat image = imread(imageFilename, IMREAD_COLOR);
    
    if (image.empty()) {
        cout << "Erreur : impossible de lire l'image " << imageFilename << endl;
        return EXIT_FAILURE;
    }
    
    PRINT_MAT_INFO(image);
    

    Mat resultat;
    meanshift(image, hs, hc, epsilon, kmax, resultat);
    
    // Afficher le résultat
    imshow("Mean Shift", resultat);
    
    
    
    
    Mat new_m;
    resultat.convertTo(new_m, CV_32F);

    // 2) kmeans asks for a mono-dimensional list of "points". Our "points" are the pixels of the image that can be seen as 3D points
    // where each coordinate is one of the color channel (e.g. R, G, B). But they are organized as a 2D table, we need
    // to re-arrange them into a single vector.
    // see the method Mat.reshape(), it is similar to matlab's reshape
    Mat new_m_reshaped = new_m.reshape(3, resultat.rows * resultat.cols);

    int k = 2;
    Mat labels, centers;
    TermCriteria criteria(TermCriteria::EPS + TermCriteria::MAX_ITER, 10, 1.0);
    
    // now we can call kmeans(...)
    kmeans(new_m_reshaped,
           k,
           labels,
           criteria,
           3,
           KMEANS_RANDOM_CENTERS,
           centers
    );
    labels = labels.reshape(1, resultat.rows);
    Mat display;
    labels.convertTo(display, CV_8U, 255.0 / (k-1));
    display=255-display;
    imshow("Clusters", display);
    
   
   
    
    // Évaluer la segmentation
    float P, S, DSC;
    evaluer_segmentation(P, S, DSC, display, vt);
    
    std::cout << "La valeur de P  est : " << P << std::endl;
    std::cout << "La valeur de S   est : " << S << std::endl;
    std::cout << "La valeur de  est : " << DSC << std::endl;
  
    
    waitKey(0);
    return EXIT_SUCCESS;
}