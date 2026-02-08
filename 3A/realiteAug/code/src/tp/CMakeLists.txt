add_subdirectory(tracker)

# Make sure the compiler can find include files from our tracker library. 
#include_directories (${TP_Interface_AR_SOURCE_DIR}/src/tp/tracker) 
include_directories (./tracker)

# Make sure the linker can find the tracker library once it is built. 
link_directories (${TP_Interface_AR_BINARY_DIR}/lib) 


add_executable( checkerboard checkerboard.cpp )
target_link_libraries( checkerboard ${OpenCV_LIBS} tracker )
configure_target( checkerboard )

add_executable( checkerboardvideo checkerboardvideo.cpp )
target_link_libraries( checkerboardvideo ${OpenCV_LIBS} tracker )
configure_target( checkerboardvideo )

add_executable( checkerboardvideoRectified checkerboardvideoRectified.cpp )
target_link_libraries( checkerboardvideoRectified ${OpenCV_LIBS} tracker )
configure_target( checkerboardvideoRectified )

add_executable( checkerboardvideoUndistort checkerboardvideoUndistort.cpp )
target_link_libraries( checkerboardvideoUndistort ${OpenCV_LIBS} )
configure_target( checkerboardvideoUndistort )

add_executable( tracking tracking.cpp )
target_link_libraries( tracking ${OpenCV_LIBS} tracker )
configure_target( tracking )

add_executable( trackingKLT trackingKLT.cpp )
target_link_libraries( trackingKLT ${OpenCV_LIBS} tracker )
configure_target( trackingKLT )

add_executable( calibration calibration.cpp )
target_link_libraries( calibration ${OpenCV_LIBS} )
configure_target( calibration )

add_executable( videoOGL videoOGL.cpp )
target_link_libraries( videoOGL ${OpenCV_LIBS} OpenGL::GL OpenGL::GLU GLUT::GLUT tracker)
configure_target( videoOGL )

#add_executable( videoOGLOBJ videoOGLOBJ.cpp )
#target_link_libraries( videoOGLOBJ ${LIBGLM_LIBRARIES} ${OpenCV_LIBS} OpenGL::GL OpenGL::GLU GLUT::GLUT tracker)
#configure_target( videoOGLOBJ )

add_executable( videoOGLTeapot videoOGLTeapot.cpp )
target_link_libraries( videoOGLTeapot ${LIBGLM_LIBRARIES} ${OpenCV_LIBS} OpenGL::GL OpenGL::GLU GLUT::GLUT tracker)
configure_target( videoOGLTeapot )

add_executable( videoOGLTracking videoOGLTracking.cpp )
target_link_libraries( videoOGLTracking ${LIBGLM_LIBRARIES} ${OpenCV_LIBS} OpenGL::GL OpenGL::GLU GLUT::GLUT tracker)
configure_target( videoOGLTracking )
