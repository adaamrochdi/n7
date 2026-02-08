#include <iostream>

#include <opencv2/core/core.hpp>
#include <opencv2/highgui/highgui.hpp>
#include <opencv2/imgproc/imgproc.hpp>

using namespace cv;
using namespace std;

int main(int argc, char** argv)
{
    if(argc != 2)
    {
        cout << " Usage: " << argv[0] << " <image>" << endl;
        return EXIT_FAILURE;
    }
    // Read the file
    const char* imageName = argv[1];

    const Mat image = imread(imageName, 1);

    if(image.empty())
    {
        cerr << "No image data!\n";
        return EXIT_FAILURE;
    }

    Mat gray_image;

    cvtColor(image, gray_image, cv::IMREAD_COLOR);

    imwrite("../../data/images/Gray_Image.jpg", gray_image);

    namedWindow(imageName, cv::WINDOW_AUTOSIZE);
    namedWindow("Gray image", cv::WINDOW_AUTOSIZE);

    imshow(imageName, image);
    imshow("Gray image", gray_image);

    // Wait for a keystroke in the window
    waitKey(0);

    return EXIT_SUCCESS;
}
