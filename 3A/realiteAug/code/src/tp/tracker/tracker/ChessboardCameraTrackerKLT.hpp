#pragma once

#include "ICameraTracker.hpp"
#include <opencv2/core/core.hpp>
#include <vector>

class ChessboardCameraTrackerKLT final : public ICameraTracker
{
  public:
    ChessboardCameraTrackerKLT() = default;

    /**
     * It detects and tracks a chessboard inside an image
     *
     * @param[in,out] view the original image
     * @param[out] pose the pose of the camera
     * @param[in] cam the camera
     * @param[in] boardSize the size of the chessboard to detect
     * @param[in] pattern the type of pattern to detect
     * @return true if the chessboard has been found
     */
    bool process(
      cv::Mat& view, cv::Mat& pose, const Camera& cam, const cv::Size& boardSize, const Pattern& pattern) override;

    ~ChessboardCameraTrackerKLT() override = default;

  private:
    /// contains the 2D corners detected in the last frame that needs to be tracked
    std::vector<cv::Point2f> _corners;
    /// contains the 3D points of the chessboard
    std::vector<cv::Point3f> _objectPoints;
    /// the previous frame
    cv::Mat _prevGrey{};
};
