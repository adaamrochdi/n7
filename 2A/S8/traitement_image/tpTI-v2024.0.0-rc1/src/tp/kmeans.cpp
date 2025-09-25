#include "ocv_utils.hpp"
#include <opencv2/core.hpp>
#include <opencv2/imgcodecs.hpp>
#include <opencv2/highgui.hpp>
#include <opencv2/imgproc.hpp>
#include <iostream>

using namespace cv;
using namespace std;

void printHelp(const string& progName)
{
    cout << "Usage:\n\t " << progName << " <image_file> <K_num_of_clusters> [<image_ground_truth>]" << endl;
}

// Trouve le centre (index du cluster) le plus proche pour le pixel (x, y)
vector<int> trouver_le_centre_le_pproche(int x, int y, int dmax, int k, const Mat& image, Point3f centers[]) {
    vector<int> resultat;
    float min_dist = dmax;     // Initialisation à une distance maximale arbitraire
    int best_cluster = 0;
    int compactness;           

    // Pour chaque centre, calculer la distance  au pixel (x,y)
    for (int j = 0; j < k; j++) {
        float dist = norm(image.at<Point3f>(y, x) - centers[j]);
        if (dist < min_dist) {
            min_dist = dist;
            best_cluster = j;
        }
    }
    compactness += min_dist * min_dist; // Calcul de la compacité pour ce pixel
    resultat.push_back(best_cluster);
    resultat.push_back(compactness);
    return resultat;
}

// Implémente l'algorithme des k-moyennes sur une image en utilisant la couleur 
void kmeans_2(const Mat& image, int k, Mat& bestLabels, int max_iter, int max_attempts)
{
    const float d_max = 1000;  // Distance maximale initiale pour la comparaison
    double best_compactness = std::numeric_limits<double>::max();

    bestLabels.create(image.rows, image.cols, CV_32FC1);
    bestLabels = 0;
    
    double compactness;
    Mat labels(image.rows, image.cols, CV_32FC1, Scalar(0));

    // Plusieurs tentatives pour trouver la meilleure segmentation (minimisation de la compacité)
    for (int attempt = 0; attempt < max_attempts; attempt++) {
        compactness = 0.0;
        Point3f centers[k];
        
        // Initialisation aléatoire des centres de clusters dans l'espace RGB
        RNG rng;
        for (int i = 0; i < k; i++) {
            centers[i] = Point3f(rng.uniform(0.f, 255.f), 
                                 rng.uniform(0.f, 255.f), 
                                 rng.uniform(0.f, 255.f));
        }

        // Itération principale de k-moyennes jusqu'à convergence ou nombre maximal d'itérations
        for (int q = 0; q < max_iter; q++) {
            compactness = 0.0;
            
            // Pour chaque pixel, on détermine le cluster le plus proche (selon la couleur)
            for (int y = 0; y < image.rows; y++) {
                for (int x = 0; x < image.cols; x++) {
                    vector<int> resulat = trouver_le_centre_le_pproche(x, y, d_max, k, image, centers);
                    int best_cluster = resulat[0];
                    int compactness = resulat[1]; // compactness pour ce pixel
                    labels.at<float>(y, x) = static_cast<float>(best_cluster);
                }
            }

            // Calcul des nouveaux centres comme moyenne des pixels assignés à chaque cluster
            vector<Point3f> new_centers(k, Point3f(0, 0, 0));
            vector<int> count(k, 0);

            for (int y = 0; y < image.rows; y++) {
                for (int x = 0; x < image.cols; x++) {
                    int cluster = static_cast<int>(labels.at<float>(y, x));
                    new_centers[cluster] += image.at<Point3f>(y, x);
                    count[cluster]++;
                }
            }

            // Mise à jour des centres et vérification de leur changement
            bool centers_changed = false;
            for (int i = 0; i < k; i++) {
                if (count[i] > 0) {
                    Point3f new_center = new_centers[i] / static_cast<float>(count[i]);
                    if (norm(centers[i] - new_center) > FLT_EPSILON) {
                        centers[i] = new_center;
                        centers_changed = true;
                    }
                }
            }
            
            if (!centers_changed)
                break; // Arrêt si les centres ne changent plus
        }
        
        // Conservation de la configuration
        if (compactness < best_compactness) {
            best_compactness = compactness;
            labels.copyTo(bestLabels);
        }
    }
    // Inversion des labels pour correspondre à la convention (pas dans tous les cas)
    //bestLabels = 1.0f - bestLabels;
}


void evaluer_segmentation(float &P, float &S, float &DSC, const cv::Mat& labels, const cv::Mat& labelsvt) {
    int TP = 0, FP = 0, TN = 0, FN = 0;

    // Parcours pixel par pixel pour compter les vrais positifs, faux positifs, vrais négatifs et faux négatifs
    for (int i = 0; i < labels.rows; i++) {
        for (int j = 0; j < labels.cols; j++) {
            if (labels.at<uchar>(i, j) == 0 && labelsvt.at<uchar>(i, j) == 0)
                TN++;
            else if (labels.at<uchar>(i, j) != 0 && labelsvt.at<uchar>(i, j) != 0)
                TP++;
            else if (labels.at<uchar>(i, j) == 0 && labelsvt.at<uchar>(i, j) != 0)
                FP++;
            else
                FN++;
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

int main(int argc, char** argv)
{
    if (argc != 3 && argc != 4)
    {
        cout << " Incorrect number of arguments. lol" << endl;
        printHelp(string(argv[0]));
        return EXIT_FAILURE;
    }

    const auto imageFilename = string(argv[1]);
    const string groundTruthFilename = (argc == 4) ? string(argv[3]) : string();
    const int k = stoi(argv[2]);

    // just for debugging
    cout << " Program called with the following arguments:" << endl;
    cout << " \timage file: " << imageFilename << endl;
    cout << " \tk: " << k << endl;
    if(!groundTruthFilename.empty())
        cout << " \tground truth segmentation: " << groundTruthFilename << endl;

    // load the color image to process from file
    Mat m = imread(imageFilename, IMREAD_COLOR);
    // for debugging use the macro PRINT_MAT_INFO to print the info about the matrix, like size and type
    PRINT_MAT_INFO(m);
    Mat vt = imread(groundTruthFilename, IMREAD_GRAYSCALE);
    // 1) in order to call kmeans we need to first convert the image into floats (CV_32F)
    // see the method Mat.convertTo()
    Mat new_m;
    m.convertTo(new_m, CV_32F);

    // 2) kmeans asks for a mono-dimensional list of "points". Our "points" are the pixels of the image that can be seen as 3D points
    // where each coordinate is one of the color channel (e.g. R, G, B). But they are organized as a 2D table, we need
    // to re-arrange them into a single vector.
    // see the method Mat.reshape(), it is similar to matlab's reshape
    Mat new_m_reshaped = new_m.reshape(3, m.rows * m.cols);

   
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

   
    labels = labels.reshape(1, m.rows);
    
    Mat labels_2;
    kmeans_2(new_m, k, labels_2, 4, 5);
    
    Mat display,display2;
    labels.convertTo(display, CV_8U, 255.0 / (k-1));
    labels_2.convertTo(display2, CV_8U, 255.0 / (k-1));
    
    
    
    float P1,S1,DSC1;
    evaluer_segmentation(P1, S1, DSC1,display,vt);
   

  
    float P2,S2,DSC2;
    evaluer_segmentation(P2, S2, DSC2,display2,vt);
    
    //Affichage des résultats d'images
    imshow("Clusters", display);
    imshow(" kmeans2", display2);
     
    //Affichage des évaluations 
    std::cout << "La valeur de P pour kmeans est : " << P1 << std::endl;
    std::cout << "La valeur de S  pour kmeans est : " << S1 << std::endl;
    std::cout << "La valeur de DSC kmeans est : " << DSC1 << std::endl;
    
    std::cout << "La valeur de P pour kmeans2 est : " << P2 << std::endl;
    std::cout << "La valeur de S  pour kmeans2 est : " << S2 << std::endl;
    std::cout << "La valeur de DSC kmeans2 est : " << DSC2 << std::endl;
    waitKey(0);

    return EXIT_SUCCESS;
}
