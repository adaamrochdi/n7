#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <opencv2/opencv.hpp>
#include <random>
#include <algorithm>

cv::Mat extraireLuminance(const cv::Mat& image) {
    CV_Assert(image.type() == CV_8UC3);

    std::vector<cv::Mat> canaux;
    cv::split(image, canaux);
    cv::Mat B, G, R;
    canaux[0].convertTo(B, CV_32F);
    canaux[1].convertTo(G, CV_32F);
    canaux[2].convertTo(R, CV_32F);

    cv::Mat luminance = 0.2126 * R + 0.7152 * G + 0.0722 * B;
    luminance.convertTo(luminance, CV_8U);
    return luminance;
}
std::vector<cv::Mat> extraireBlocsEtLuminance(const cv::Mat &imageEntree, int taille, std::vector<cv::Mat> &blocsLuminance) {
    std::vector<cv::Mat> blocs;
    int lignes = imageEntree.rows;
    int colonnes = imageEntree.cols;
    

    cv::Mat luminanceSource = extraireLuminance(imageEntree);

    for (int i = 0; i <= lignes - taille; i++) {
        for (int j = 0; j <= colonnes - taille; j++) {
            cv::Rect zone(j, i, taille, taille);
            cv::Mat bloc = imageEntree(zone).clone();
            blocs.push_back(bloc);
            
            cv::Mat blocLuminance = luminanceSource(zone).clone();
            blocsLuminance.push_back(blocLuminance);
        }
    }
    return blocs;
}



double erreurChevauchementHorizontal2(const cv::Mat& place, const cv::Mat& candidat, int chevauchement) {
    cv::Mat chevauchementPlace = place(cv::Rect(place.cols - chevauchement, 0, chevauchement, place.rows)).clone();
    cv::Mat chevauchementCandidat = candidat(cv::Rect(0, 0, chevauchement, candidat.rows)).clone();
    cv::Mat diff = chevauchementPlace - chevauchementCandidat;
    cv::Mat diffCarre;
    cv::pow(diff, 2, diffCarre);
    double erreur = cv::sum(diffCarre)[0];
    return erreur;
}

double erreurChevauchementVertical2(const cv::Mat& place, const cv::Mat& candidat, int chevauchement) {
    cv::Mat chevauchementPlace = place(cv::Rect(0, place.rows - chevauchement, place.cols, chevauchement)).clone();
    cv::Mat chevauchementCandidat = candidat(cv::Rect(0, 0, candidat.cols, chevauchement)).clone();
    cv::Mat diff = chevauchementPlace - chevauchementCandidat;
    cv::Mat diffCarre;
    cv::pow(diff, 2, diffCarre);
    double erreur = cv::sum(diffCarre)[0];
    return erreur;
}

double erreurCorrespondance(const cv::Mat& candidat, const cv::Mat& blocCorrespondanceSource) {
    if (candidat.empty() || blocCorrespondanceSource.empty()) {
        return 0.0;
    }

    if (candidat.size() != blocCorrespondanceSource.size()) {

        cv::Mat blocRedimensionne;
        cv::resize(blocCorrespondanceSource, blocRedimensionne, candidat.size(), 0, 0, cv::INTER_LINEAR);
        
      
        cv::Mat diff = candidat - blocRedimensionne;
        
        cv::Mat diffCarre;
        cv::pow(diff, 2, diffCarre);
        double erreur = cv::sum(diffCarre)[0];
        return erreur;
    } else {
        
        cv::Mat diff = candidat - blocCorrespondanceSource;
        cv::Mat diffCarre;
        cv::pow(diff, 2, diffCarre);
        double erreur = cv::sum(diffCarre)[0];
        return erreur;
    }
}


cv::Mat choisirBloc2(const std::vector<cv::Mat> &candidats,
                     const std::vector<cv::Mat> &luminancecandidats,
                     const cv::Mat &blocGauche,
                     const cv::Mat &blocHaut,
                     int overlap,
                     double alpha,
                     const cv::Mat &blocluminance,
                     double tolerance) {
    
    size_t N = candidats.size();
    std::vector<double> erreurs(N);

    for (size_t i = 0; i < N; ++i) {
        double eLum = erreurCorrespondance(luminancecandidats[i], blocluminance);
        double eChev = 0.0;
        if (!blocGauche.empty())
            eChev += erreurChevauchementHorizontal2(blocGauche, candidats[i], overlap);
        if (!blocHaut.empty())
            eChev += erreurChevauchementVertical2(blocHaut, candidats[i], overlap);
        erreurs[i] = (1.0 - alpha) * eLum + alpha * eChev;
    }

    double minErr = *std::min_element(erreurs.begin(), erreurs.end());

    std::vector<int> pool;
    for (int i = 0; i < static_cast<int>(N); ++i) {
        if (erreurs[i] <= (1.0 + tolerance) * minErr)
            pool.push_back(i);
    }
    static std::mt19937 gen{ std::random_device{}() };
    std::uniform_int_distribution<> dist(0, pool.size() - 1);
    int choix = pool[dist(gen)];

    return candidats[choix].clone();
}


std::vector<int> cheminCoupeVertical2(const cv::Mat& e){
    int lignes = e.rows;
    int colonnes = e.cols;
    cv::Mat E = cv::Mat::zeros(lignes, colonnes, CV_64F);
    
   
    for (int i = 0; i < colonnes; i++) {
        E.at<double>(0, i) = e.at<double>(0, i);
    }
    

    for (int i = 1; i < lignes; i++) {
        for (int j = 0; j < colonnes; j++) {
            double minPrev = E.at<double>(i - 1, j);
            if (j > 0) minPrev = std::min(minPrev, E.at<double>(i - 1, j - 1));
            if (j < colonnes - 1) minPrev = std::min(minPrev, E.at<double>(i - 1, j + 1));
            E.at<double>(i, j) = e.at<double>(i, j) + minPrev;
        }
    }
    
    std::vector<int> chemin(lignes);
    double min = E.at<double>(lignes-1, 0);
    int idxmin = 0;
    
    for (int j = 0; j < colonnes; j++) {
        if (E.at<double>(lignes-1, j) < min) {
            min = E.at<double>(lignes-1, j);
            idxmin = j;
        }
    }
    
    chemin[lignes-1] = idxmin;
    
    for (int i = lignes-2; i >= 0; i--) {
        int prec = chemin[i+1];
        int meilleur = prec;
        double meilleureVal = E.at<double>(i, prec);
        
        if (prec > 0 && E.at<double>(i, prec - 1) < meilleureVal) {
            meilleur = prec - 1;
            meilleureVal = E.at<double>(i, prec - 1);
        }
        
        if (prec < colonnes - 1 && E.at<double>(i, prec + 1) < meilleureVal) {
            meilleur = prec + 1;
        }
        
        chemin[i] = meilleur;
    }
    
    return chemin;
}

std::vector<int> cheminCoupeHorizontale2(const cv::Mat& e){
    int lignes = e.rows;
    int colonnes = e.cols;
    cv::Mat E = cv::Mat::zeros(lignes, colonnes, CV_64F);
    
    for (int i = 0; i < lignes; i++) {
        E.at<double>(i, 0) = e.at<double>(i, 0);
    }
    

    for (int j = 1; j < colonnes; j++) {
        for (int i = 0; i < lignes; i++) {
            double minPrev = E.at<double>(i, j-1);
            if (i > 0) minPrev = std::min(minPrev, E.at<double>(i - 1, j - 1));
            if (i < lignes - 1) minPrev = std::min(minPrev, E.at<double>(i + 1, j - 1));
            E.at<double>(i, j) = e.at<double>(i, j) + minPrev;
        }
    }
    
   
    std::vector<int> chemin(colonnes);
    double min = E.at<double>(0, colonnes-1);
    int idxmin = 0;
    
    for (int j = 0; j < lignes; j++) {
        if (E.at<double>(j, colonnes-1) < min) {
            min = E.at<double>(j, colonnes-1);
            idxmin = j;
        }
    }
    
    chemin[colonnes-1] = idxmin;
    
    
    for (int j = colonnes-2; j >= 0; j--) {
        int prec = chemin[j+1];
        int meilleur = prec;
        double meilleureVal = E.at<double>(prec, j);
        
        if (prec > 0 && E.at<double>(prec - 1, j) < meilleureVal) {
            meilleur = prec - 1;
            meilleureVal = E.at<double>(prec - 1, j);
        }
        
        if (prec < lignes - 1 && E.at<double>(prec + 1, j) < meilleureVal) {
            meilleur = prec + 1;
            
            meilleureVal = E.at<double>(prec + 1, j);
        }
        
        chemin[j] = meilleur;
    }
    
    return chemin;
}

cv::Mat fusionHorizontale2(const cv::Mat& blocGauche, const cv::Mat& blocCandidat, int overlap){
    int taille = blocGauche.rows;
    
    
    cv::Mat overlapGauche = blocGauche(cv::Rect(taille-overlap, 0, overlap, taille)).clone();
    cv::Mat overlapCandidat = blocCandidat(cv::Rect(0, 0, overlap, taille)).clone();
    cv::Mat blocCandidatCopie = blocCandidat.clone();
    
    cv::Mat diff;
    cv::absdiff(overlapGauche, overlapCandidat, diff);
    cv::Mat diffSquared;
    cv::pow(diff, 2, diffSquared);
    cv::Mat e;
    cv::cvtColor(diffSquared, e, cv::COLOR_BGR2GRAY);
    e.convertTo(e, CV_64F);
    

    std::vector<int> chemin = cheminCoupeVertical2(e);
    

    cv::Mat masque = cv::Mat::zeros(taille, overlap, CV_8UC1);
    for (int y = 0; y < taille; ++y) {
        int xCoupe = chemin[y];
        for (int x = 0; x < xCoupe; ++x) {
            masque.at<uchar>(y, x) = 255;
        }
    }
   
    cv::Mat fusion = blocCandidatCopie.clone();
    overlapGauche.copyTo(fusion(cv::Rect(0, 0, overlap, taille)), masque);
    
    return fusion;
}

cv::Mat fusionVerticale2(const cv::Mat& blocHaut, const cv::Mat& blocCandidat, int overlap) {
    int taille = blocHaut.rows;

    cv::Mat overlapHaut = blocHaut(cv::Rect(0, taille - overlap, taille, overlap)).clone();
    cv::Mat overlapCandidat = blocCandidat(cv::Rect(0, 0, taille, overlap)).clone();
    cv::Mat blocCandidatCopie = blocCandidat.clone();

    cv::Mat diff;
    cv::absdiff(overlapHaut, overlapCandidat, diff);
    cv::Mat diffSquared;
    cv::pow(diff, 2, diffSquared);
    cv::Mat e;
    cv::cvtColor(diffSquared, e, cv::COLOR_BGR2GRAY);
    e.convertTo(e, CV_64F);

    std::vector<int> chemin = cheminCoupeHorizontale2(e);

    cv::Mat masque = cv::Mat::zeros(overlap, taille, CV_8UC1);
    for (int x = 0; x < taille; ++x) {
        int yCoupe = chemin[x];
        for (int y = 0; y < yCoupe; ++y) {
            masque.at<uchar>(y, x) = 255;
        }
    }


    cv::Mat fusion = blocCandidatCopie.clone();
    overlapHaut.copyTo(fusion(cv::Rect(0, 0, taille, overlap)), masque);
    
    return fusion;
}

cv::Mat fusionMixte2(const cv::Mat& blocGauche, const cv::Mat& blocHaut, const cv::Mat& blocCandidat, int overlap) {
    int taille = blocCandidat.rows;
    
    cv::Mat blocCandidatCopie = blocCandidat.clone();
    
    cv::Mat overlapGauche = blocGauche(cv::Rect(taille - overlap, 0, overlap, taille)).clone();
    cv::Mat overlapCandV = blocCandidatCopie(cv::Rect(0, 0, overlap, taille)).clone();
    cv::Mat diffV;
    cv::absdiff(overlapGauche, overlapCandV, diffV);
    cv::pow(diffV, 2, diffV);
    cv::Mat e_vert;
    cv::cvtColor(diffV, e_vert, cv::COLOR_BGR2GRAY);
    e_vert.convertTo(e_vert, CV_64F);
    std::vector<int> cheminV = cheminCoupeVertical2(e_vert);
    
    cv::Mat masqueV = cv::Mat::zeros(taille, overlap, CV_8UC1);
    for (int y = 0; y < taille; ++y) {
        int xCoupe = cheminV[y];
        for (int x = 0; x < xCoupe; ++x) {
            masqueV.at<uchar>(y, x) = 255;
        }
    }
    
    cv::Mat overlapHaut = blocHaut(cv::Rect(0, taille - overlap, taille, overlap)).clone();
    cv::Mat overlapCandH = blocCandidatCopie(cv::Rect(0, 0, taille, overlap)).clone();
    cv::Mat diffH;
    cv::absdiff(overlapHaut, overlapCandH, diffH);
    cv::pow(diffH, 2, diffH);
    cv::Mat e_horiz;
    cv::cvtColor(diffH, e_horiz, cv::COLOR_BGR2GRAY);
    e_horiz.convertTo(e_horiz, CV_64F);
    std::vector<int> cheminH = cheminCoupeHorizontale2(e_horiz);
    
    cv::Mat masqueH = cv::Mat::zeros(overlap, taille, CV_8UC1);
    for (int x = 0; x < taille; ++x) {
        int yCoupe = cheminH[x];
        for (int y = 0; y < yCoupe; ++y) {
            masqueH.at<uchar>(y, x) = 255;
        }
    }
    
    cv::Mat fusion = blocCandidatCopie.clone();
    
    overlapGauche.copyTo(fusion(cv::Rect(0, 0, overlap, taille)), masqueV);
    overlapHaut.copyTo(fusion(cv::Rect(0, 0, taille, overlap)), masqueH);
    
    return fusion;
}

cv::Mat quiltingImage2(const cv::Mat& textureEntree,const cv::Mat& imagetarget, int tailleBloc, double tauxChevauchement, double alpha,double tolerance) {
    std::cout << "Dimensions de la texture d'entrée: " << textureEntree.cols << "x" << textureEntree.rows << std::endl;
    std::cout << "Dimensions de l'image cible: " << imagetarget.cols << "x" << imagetarget.rows << std::endl;
        
    int largeurSortie = imagetarget.cols;
    int hauteurSortie = imagetarget.rows;
    std::vector<cv::Mat> blocsLuminance;
    std::vector<cv::Mat> blocs = extraireBlocsEtLuminance(textureEntree, tailleBloc, blocsLuminance);
    cv::Mat luminancetarget = extraireLuminance(imagetarget);
    
    int overlap = std::round(tauxChevauchement * tailleBloc);
    int pas = tailleBloc - overlap;

    int nBlocsX = std::ceil((largeurSortie - overlap) / float(pas));
    int nBlocsY = std::ceil((hauteurSortie - overlap) / float(pas));
    int largeurTemp = overlap + nBlocsX * pas;
    int hauteurTemp = overlap + nBlocsY * pas;

    
    cv::Mat imageTemp = cv::Mat::zeros(hauteurTemp, largeurTemp, CV_8UC3);

    for (int y = 0; y < nBlocsY; y++) {
        for (int x = 0; x < nBlocsX; x++) {
            int posX = x * pas;
            int posY = y * pas;
            cv::Rect zoneCible(posX, posY, tailleBloc, tailleBloc);
            zoneCible.width = std::min(zoneCible.width, luminancetarget.cols - zoneCible.x);
            zoneCible.height = std::min(zoneCible.height, luminancetarget.rows - zoneCible.y);
                    
            cv::Mat blocLuminanceCible;
            if (zoneCible.width > 0 && zoneCible.height > 0) {
                blocLuminanceCible = luminancetarget(zoneCible).clone();
            } else {
                blocLuminanceCible = cv::Mat::zeros(tailleBloc, tailleBloc, luminancetarget.type());
            }
            if (y == 0 && x == 0) {
                cv::Mat meilleurBloc = choisirBloc2(blocs,blocsLuminance,cv::Mat(), cv::Mat(), overlap, alpha,blocLuminanceCible, tolerance);
                
                meilleurBloc.clone().copyTo(imageTemp(cv::Rect(posX, posY, tailleBloc, tailleBloc)));
            }
            else if (y == 0) {
                cv::Mat blocGauche = imageTemp(cv::Rect(posX - pas, posY, tailleBloc, tailleBloc)).clone();
                cv::Mat meilleurBloc = choisirBloc2(blocs,blocsLuminance, blocGauche, cv::Mat(), overlap, alpha,blocLuminanceCible, tolerance);
                cv::Mat fusion = fusionHorizontale2(blocGauche, meilleurBloc, overlap);
                fusion.copyTo(imageTemp(cv::Rect(posX, posY, tailleBloc, tailleBloc)));
            }
            else if (x == 0) {
                cv::Mat blocHaut = imageTemp(cv::Rect(posX, posY - pas, tailleBloc, tailleBloc)).clone();
                cv::Mat meilleurBloc = choisirBloc2(blocs, blocsLuminance,cv::Mat(), blocHaut, overlap,alpha,blocLuminanceCible,tolerance);
                cv::Mat fusion = fusionVerticale2(blocHaut, meilleurBloc, overlap);
                fusion.copyTo(imageTemp(cv::Rect(posX, posY, tailleBloc, tailleBloc)));
            }
            else {
                cv::Mat blocGauche = imageTemp(cv::Rect(posX - pas, posY, tailleBloc, tailleBloc)).clone();
                cv::Mat blocHaut = imageTemp(cv::Rect(posX, posY - pas, tailleBloc, tailleBloc)).clone();
                cv::Mat meilleurBloc = choisirBloc2(blocs,blocsLuminance, blocGauche, blocHaut, overlap,alpha,blocLuminanceCible,tolerance);
                cv::Mat fusion = fusionMixte2(blocGauche, blocHaut, meilleurBloc, overlap);
                fusion.copyTo(imageTemp(cv::Rect(posX, posY, tailleBloc, tailleBloc)));
            }
        }
    }

    return imageTemp(cv::Rect(0, 0, std::min(largeurSortie, largeurTemp),
                             std::min(hauteurSortie, hauteurTemp))).clone();
}
cv::Mat quiltingIteratif(const cv::Mat& texture, const cv::Mat& cible, int tailleInitiale, int N, double tauxChevauchement,double tolerance) {
    cv::Mat resultat = cible.clone();

    for (int i = 0; i < N; ++i) {
        int tailleBloc = std::round(tailleInitiale * std::pow(2.0 / 3.0, i));  // taille décroissante
        double alpha = 0.8 * (double(i) / (N - 1)) + 0.1;

        std::cout << "Itération " << i+1 << "/" << N
                  << " | Taille bloc = " << tailleBloc
                  << " | Alpha = " << alpha << std::endl;

        resultat = quiltingImage2(texture, resultat, tailleBloc, tauxChevauchement, alpha,tolerance);
    }

    return resultat;
}

int main(int argc, const char * argv[]) {
    std::srand(std::time(nullptr));
    
    cv::Mat imageSource = cv::imread("fabric.jpg", cv::IMREAD_COLOR);
    cv::Mat imageSource2;
    cv::resize(imageSource, imageSource2,{196,130});
    cv::Mat imageforme = cv::imread("girl.jpg", cv::IMREAD_COLOR);
    if (imageSource.empty()||imageforme.empty()) {
        std::cerr << "Image introuvable!" << std::endl;
        return -1;
    }

    
    double tolerance = 0.1;
    int tailleInitiale = 40;
    int nombreIterations = 2;
    double tauxChevauchement = 0.15;
    cv::Mat imageitere = quiltingIteratif(imageSource2, imageforme, tailleInitiale, nombreIterations, tauxChevauchement,tolerance);
    
    int tailleBloc = 40;
    double alpha = 0.1;

    cv::Mat imageSortie = quiltingImage2(imageSource2, imageforme, tailleBloc, tauxChevauchement,alpha,tolerance);
   
    cv::imshow("TEXTURE2", imageSource);
    cv::imshow("TEXTURE SYNTHETISEE2", imageSortie);
    cv::imshow("TEXTURE SYNTHETISEE3", imageitere);
    
    
    cv::waitKey(0);
    
    return 0;
}
