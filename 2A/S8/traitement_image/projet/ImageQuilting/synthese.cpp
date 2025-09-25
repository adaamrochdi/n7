#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>
#include <chrono>  
#include <opencv2/opencv.hpp>

double getPSNR(const cv::Mat& I1, const cv::Mat& I2)
{
    cv::Mat s1;
    cv::absdiff(I1, I2, s1);      
    s1.convertTo(s1, CV_32F); 
    s1 = s1.mul(s1);           
    cv::Scalar s = sum(s1);      
    double sse = s.val[0] + s.val[1] + s.val[2]; 
    if( sse <= 1e-10) 
        return 0;
    else
    {
        double mse  = sse / (double)(I1.channels() * I1.total());
        double psnr = 10.0 * log10((255 * 255) / mse);
        return psnr;
    }
}
cv::Scalar getMSSIM(const cv::Mat& i1, const cv::Mat& i2)
{
    const double C1 = 6.5025, C2 = 58.5225;
    int d = CV_32F;

    cv::Mat I1, I2;
    i1.convertTo(I1, d);
    i2.convertTo(I2, d);

    // Pré-calculs
    cv::Mat I1_2 = I1.mul(I1);       
    cv::Mat I2_2 = I2.mul(I2);   
    cv::Mat I1_I2 = I1.mul(I2);     

    cv::Mat mu1, mu2;
    cv::GaussianBlur(I1, mu1, cv::Size(11, 11), 1.5);
    cv::GaussianBlur(I2, mu2, cv::Size(11, 11), 1.5);

    // mu1^2, mu2^2, mu1*mu2
    cv::Mat mu1_2 = mu1.mul(mu1);
    cv::Mat mu2_2 = mu2.mul(mu2);
    cv::Mat mu1_mu2 = mu1.mul(mu2);

    // Calcul des variances et covariance
    cv::Mat sigma1_2, sigma2_2, sigma12;
    cv::GaussianBlur(I1_2, sigma1_2, cv::Size(11, 11), 1.5);
    sigma1_2 -= mu1_2;

    cv::GaussianBlur(I2_2, sigma2_2, cv::Size(11, 11), 1.5);
    sigma2_2 -= mu2_2;

    cv::GaussianBlur(I1_I2, sigma12, cv::Size(11, 11), 1.5);
    sigma12 -= mu1_mu2;

    // SSIM calculation
    cv::Mat t1, t2, t3, t1_mul_t2, t1_den, t2_den;

    // Numerator
    cv::Mat t1_n = (2.0 * mu1_mu2 + C1);
    cv::Mat t2_n = (2.0 * sigma12 + C2);
    t1_mul_t2 = t1_n.mul(t2_n);

    // Denominator
    t1_den = (mu1_2 + mu2_2 + C1);
    t2_den = (sigma1_2 + sigma2_2 + C2);
    cv::Mat t1t2_den = t1_den.mul(t2_den);

    // Final SSIM map
    cv::Mat ssim_map;
    cv::divide(t1_mul_t2, t1t2_den, ssim_map);

    return cv::mean(ssim_map);
}

std::pair<double, cv::Scalar> evaluateSynthesisQuality(const cv::Mat& refImage, const cv::Mat& synthImage, int stepSize = 5) {
    int patchH = refImage.rows;
    int patchW = refImage.cols;

    if (synthImage.rows < patchH || synthImage.cols < patchW) {
        std::cerr << "[Erreur] L'image synthétisée est plus petite que le patch de référence." << std::endl;
        return {-1.0, cv::Scalar(-1, -1, -1)};
    }

    int maxY = synthImage.rows - patchH;
    int maxX = synthImage.cols - patchW;

    double psnrSum = 0.0;
    cv::Scalar mssimSum(0, 0, 0, 0);
    int patchCount = 0;

    for (int y = 0; y <= maxY; y += stepSize) {
        for (int x = 0; x <= maxX; x += stepSize) {
            cv::Rect roi(x, y, patchW, patchH);
            
            if ((roi.x + roi.width <= synthImage.cols) && (roi.y + roi.height <= synthImage.rows)) {
                cv::Mat patch = synthImage(roi);

                psnrSum += getPSNR(refImage, patch);
                mssimSum += getMSSIM(refImage, patch);
                patchCount++;
            }
        }
    }

    if (patchCount == 0) {
        std::cerr << "[Erreur] Aucun patch valide trouvé." << std::endl;
        return {-1.0, cv::Scalar(-1, -1, -1)};
    }

    std::cout << "Nombre de patches évalués: " << patchCount << std::endl;
    
    return {psnrSum / patchCount, mssimSum / patchCount};
}


std::vector<cv::Mat> extraireBlocs(const cv::Mat &imageEntree, int taille) {
    std::vector<cv::Mat> blocs;
    int lignes = imageEntree.rows;
    int colonnes = imageEntree.cols;

    for (int i = 0; i <= lignes - taille; i++) {
        for (int j = 0; j <= colonnes - taille; j++) {
            cv::Rect zone(j, i, taille, taille);
            cv::Mat bloc = imageEntree(zone).clone();
            blocs.push_back(bloc);
        }
    }
    return blocs;
}

double erreurChevauchementHorizontal(const cv::Mat& place, const cv::Mat& candidat, int chevauchement) {
    cv::Mat chevauchementPlace = place(cv::Rect(place.cols - chevauchement, 0, chevauchement, place.rows)).clone();
    cv::Mat chevauchementCandidat = candidat(cv::Rect(0, 0, chevauchement, candidat.rows)).clone();
    cv::Mat diff = chevauchementPlace - chevauchementCandidat;
    cv::Mat diffCarre;
    cv::pow(diff, 2, diffCarre);
    double erreur = cv::sum(diffCarre)[0];
    return erreur;
}

double erreurChevauchementVertical(const cv::Mat& place, const cv::Mat& candidat, int chevauchement) {
    cv::Mat chevauchementPlace = place(cv::Rect(0, place.rows - chevauchement, place.cols, chevauchement)).clone();
    cv::Mat chevauchementCandidat = candidat(cv::Rect(0, 0, candidat.cols, chevauchement)).clone();
    cv::Mat diff = chevauchementPlace - chevauchementCandidat;
    cv::Mat diffCarre;
    cv::pow(diff, 2, diffCarre);
    double erreur = cv::sum(diffCarre)[0];
    return erreur;
}

cv::Mat choisirBloc(const std::vector<cv::Mat> &candidats, const cv::Mat &blocGauche, const cv::Mat &blocHaut, int overlap,double tolerance) {
    double erreurMin = std::numeric_limits<double>::max();
    std::vector<double> erreurs(candidats.size());
    
    // Calculer l'erreur pour chaque candidat
    for (size_t i = 0; i < candidats.size(); i++) {
        double erreur = 0.0;

        if (!blocGauche.empty()) {
            erreur += erreurChevauchementVertical(blocGauche, candidats[i], overlap);
        }
        if (!blocHaut.empty()) {
            erreur += erreurChevauchementHorizontal(blocHaut, candidats[i], overlap);
        }
        
        erreurs[i] = erreur;
        if (erreur < erreurMin) {
            erreurMin = erreur;
        }
    }
    
    double seuilTolerance = erreurMin * (1.0 + tolerance);
    
    std::vector<int> candidatsValides;
    for (size_t i = 0; i < candidats.size(); i++) {
        if (erreurs[i] <= seuilTolerance) {
            candidatsValides.push_back(i);
        }
    }
    
    int indexChoisi;
    if (!candidatsValides.empty()) {
        int randomIdx = rand() % candidatsValides.size();
        indexChoisi = candidatsValides[randomIdx];
    } else {
        indexChoisi = 0;
        for (size_t i = 1; i < candidats.size(); i++) {
            if (erreurs[i] < erreurs[indexChoisi]) {
                indexChoisi = i;
            }
        }
    }
    
    return candidats[indexChoisi].clone();
}

std::vector<int> cheminCoupeVertical(const cv::Mat& e){
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

std::vector<int> cheminCoupeHorizontale(const cv::Mat& e){
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

cv::Mat fusionHorizontale(const cv::Mat& blocGauche, const cv::Mat& blocCandidat, int overlap){
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
  
    std::vector<int> chemin = cheminCoupeVertical(e);
    

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

cv::Mat fusionVerticale(const cv::Mat& blocHaut, const cv::Mat& blocCandidat, int overlap) {
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


    std::vector<int> chemin = cheminCoupeHorizontale(e);

  
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

cv::Mat fusionMixte(const cv::Mat& blocGauche, const cv::Mat& blocHaut, const cv::Mat& blocCandidat, int overlap) {
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
    std::vector<int> cheminV = cheminCoupeVertical(e_vert);
    
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
    std::vector<int> cheminH = cheminCoupeHorizontale(e_horiz);
    
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

cv::Mat quiltingImage(const cv::Mat& textureEntree, int largeurSortie, int hauteurSortie, int tailleBloc, double tauxChevauchement,double tolerance) {
   
    std::vector<cv::Mat> blocs = extraireBlocs(textureEntree, tailleBloc);
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
            
            if (y == 0 && x == 0) {
                
                int randomIndex = rand() % blocs.size();
                blocs[randomIndex].clone().copyTo(imageTemp(cv::Rect(posX, posY, tailleBloc, tailleBloc)));
            }
            else if (y == 0) {
                
                cv::Mat blocGauche = imageTemp(cv::Rect(posX - pas, posY, tailleBloc, tailleBloc)).clone();
                cv::Mat meilleurBloc = choisirBloc(blocs, blocGauche, cv::Mat(), overlap,tolerance);
                cv::Mat fusion = fusionHorizontale(blocGauche, meilleurBloc, overlap);
                fusion.copyTo(imageTemp(cv::Rect(posX, posY, tailleBloc, tailleBloc)));
            }
            else if (x == 0) {
                
                cv::Mat blocHaut = imageTemp(cv::Rect(posX, posY - pas, tailleBloc, tailleBloc)).clone();
                cv::Mat meilleurBloc = choisirBloc(blocs, cv::Mat(), blocHaut, overlap,tolerance);
                cv::Mat fusion = fusionVerticale(blocHaut, meilleurBloc, overlap);
                fusion.copyTo(imageTemp(cv::Rect(posX, posY, tailleBloc, tailleBloc)));
            }
            else {
                
                cv::Mat blocGauche = imageTemp(cv::Rect(posX - pas, posY, tailleBloc, tailleBloc)).clone();
                cv::Mat blocHaut = imageTemp(cv::Rect(posX, posY - pas, tailleBloc, tailleBloc)).clone();
                cv::Mat meilleurBloc = choisirBloc(blocs, blocGauche, blocHaut, overlap,tolerance);
                cv::Mat fusion = fusionMixte(blocGauche, blocHaut, meilleurBloc, overlap);
                fusion.copyTo(imageTemp(cv::Rect(posX, posY, tailleBloc, tailleBloc)));
            }
        }
    }

    return imageTemp(cv::Rect(0, 0, std::min(largeurSortie, largeurTemp),
                             std::min(hauteurSortie, hauteurTemp))).clone();
}

int main(int argc, const char * argv[]) {
    
    std::srand(std::time(nullptr));
    
    cv::Mat imageSource = cv::imread("fabric.jpg", cv::IMREAD_COLOR);
    if (imageSource.empty()) {
        std::cerr << "Image introuvable!" << std::endl;
        return -1;
    }
    double tolerance =0.01;
    int largeurSortie = 500;
    int hauteurSortie = 500;
    int tailleBloc = 100;
    double tauxChevauchement = 0.15;
    auto debut = std::chrono::high_resolution_clock::now();
    
    cv::Mat imageSortie = quiltingImage(imageSource, largeurSortie, hauteurSortie, tailleBloc, tauxChevauchement,tolerance);
    auto [averagePSNR, averageMSSIM] = evaluateSynthesisQuality(imageSource, imageSortie, 5);

    std::cout << "\n=== RÉSULTATS ===" << std::endl;
    std::cout << "Qualité moyenne avec sliding window :" << std::endl;
    std::cout << "PSNR moyen : " << averagePSNR << " dB" << std::endl;
    std::cout << "MSSIM moyen : "
              << " R = " << averageMSSIM[2] * 100 << "%"
              << ", G = " << averageMSSIM[1] * 100 << "%"
              << ", B = " << averageMSSIM[0] * 100 << "%" << std::endl;

    
    
    
    auto fin = std::chrono::high_resolution_clock::now();
    auto duree = std::chrono::duration_cast<std::chrono::milliseconds>(fin - debut);
    std::cout << "Temps de calcul: " << duree.count() << " ms" << std::endl;
    std::cout << "Temps de calcul: " << duree.count() / 1000.0 << " secondes" << std::endl;
   
    cv::imshow("TEXTURE", imageSource);
    cv::imshow("TEXTURE SYNTHETISEE", imageSortie);
    
    cv::waitKey(0);
    
    return 0;
}
