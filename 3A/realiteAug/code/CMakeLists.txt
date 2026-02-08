cmake_minimum_required(VERSION 3.10)
include(ExternalProject)

project( TP_AR VERSION 2025.1.0 LANGUAGES CXX C)

option(BUILD_TUTORIALS "Build OpenCV tutorials" ON)
option(BUILD_SHARED_LIBS "Build shared libs" ON)
option(ENABLE_WARNINGS_AS_ERRORS "Treat warnings as errors" OFF)

# guard against in-source builds
if(${CMAKE_SOURCE_DIR} STREQUAL ${CMAKE_BINARY_DIR})
    message(FATAL_ERROR "In-source builds not allowed. Please make a separate build directory.")
endif()

# if no build type is set, default to Release
if(NOT CMAKE_BUILD_TYPE)
    set(CMAKE_BUILD_TYPE "Release" CACHE STRING "Build type" FORCE)
    set_property(CACHE CMAKE_BUILD_TYPE PROPERTY STRINGS "Debug;Release;RelWithDebInfo;MinSizeRel")
endif()
message(STATUS "CMAKE_BUILD_TYPE: ${CMAKE_BUILD_TYPE}")

set(CMAKE_DEBUG_POSTFIX d)

# compile options for all targets depending on the compiler and the system
if(CMAKE_CXX_COMPILER_ID MATCHES "Clang|GNU")
    set(MY_COMPILE_OPTIONS "-Wall;-Wextra;-pedantic;-Wno-comment;-Wshadow;-Wnon-virtual-dtor;-Wpedantic;-Wconversion;-Wmisleading-indentation;-Wsign-conversion;-Wfloat-equal")
    if(ENABLE_WARNINGS_AS_ERRORS)
        list(APPEND MY_COMPILE_OPTIONS "-Werror")
    endif()
elseif(MSVC)
    set(MY_COMPILE_OPTIONS "/W4;/permissive-")
    if(ENABLE_WARNINGS_AS_ERRORS)
        list(APPEND MY_COMPILE_OPTIONS "/WX")
    endif()
endif()
if(APPLE)
    list(APPEND MY_COMPILE_OPTIONS "-Wno-deprecated-declarations")
endif()

# compile definitions for all targets depending on the compiler and the system
set(MY_COMPILE_DEFINITIONS "")
if(MSVC)
    list(APPEND MY_COMPILE_DEFINITIONS "-DNOMINMAX;-D_USE_MATH_DEFINES")
endif()

# set the path where we can find the findXXX.cmake
set(CMAKE_MODULE_PATH ${PROJECT_SOURCE_DIR}/.cmake)

# add a search path for the glm libraries
# it will work if they are already compiled in /3rdparty
if(NOT DEFINED GLM_DIR)
    set(GLM_DIR ${PROJECT_SOURCE_DIR}/3rdparty/glm/build)
endif() 
list(APPEND CMAKE_LIBRARY_PATH "${GLM_DIR}/lib")
list(APPEND CMAKE_INCLUDE_PATH "${GLM_DIR}/include")


# set the output path for the generated files
set(CMAKE_RUNTIME_OUTPUT_DIRECTORY ${PROJECT_BINARY_DIR}/bin)
set(CMAKE_ARCHIVE_OUTPUT_DIRECTORY ${PROJECT_BINARY_DIR}/lib)
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${PROJECT_BINARY_DIR}/lib )

#########################################################
# SET COMPILATION FLAGS FOR C++17
#########################################################

set(CMAKE_CXX_STANDARD 17)
set(CMAKE_CXX_STANDARD_REQUIRED ON)

#########################################################
#
# EXTERNAL LIBRARIES
#
#########################################################

#########################################################
# LIB GLM
#########################################################

#try to find the library
find_package(glm QUIET)

if(NOT glm_FOUND)
    message(STATUS "glm not found, fetching it")
    include(FetchContent)
    FetchContent_Declare(
      glm
      GIT_REPOSITORY https://github.com/simogasp/glm.git
#            GIT_TAG v0.3.4)
            GIT_TAG develop)
    FetchContent_MakeAvailable(glm)
endif()
set(LIBGLM_LIBRARIES glm::glm)


#########################################################
# FIND OPENCV
#########################################################
if(MSVC)
    set(OpenCV_STATIC ON)
endif()
find_package(OpenCV 4.0 REQUIRED)

if(NOT OpenCV_FOUND)
    message(ERROR " OpenCV not found!")
else()
    message( "-- Found OpenCV version: ${OpenCV_VERSION}" )
endif(NOT OpenCV_FOUND)

#########################################################
# FIND OPENGL
#########################################################
set(OpenGL_GL_PREFERENCE "GLVND")
find_package(OpenGL REQUIRED)
message(STATUS "OPENGL_gl_LIBRARY: ${OPENGL_gl_LIBRARY}")
if(NOT OPENGL_FOUND)
    message(ERROR " OPENGL not found!")
endif(NOT OPENGL_FOUND)

#########################################################
# FIND GLUT
#########################################################
if(MSVC)
    message(STATUS "GLUT_ROOT_PATH: ${GLUT_ROOT_PATH}")
endif()
find_package(GLUT REQUIRED)
message(STATUS "GLUT_FOUND: ${GLUT_FOUND}")
message(STATUS "GLUT_INCLUDE_DIR: ${GLUT_INCLUDE_DIR}")
message(STATUS "GLUT_LIBRARIES: ${GLUT_LIBRARIES}")
if(NOT GLUT_FOUND)
    message(ERROR " GLUT not found!")
else()
    message( "-- Found GLUT" )
endif(NOT GLUT_FOUND)


## FreeGLUT ?
# find_package(FreeGLUT REQUIRED)
# include_directories(${FreeGLUT_INCLUDE_DIRS})
# link_directories(${FreeGLUT_LIBRARY_DIRS})
# add_definitions(${FreeGLUT_DEFINITIONS})
# MESSAGE( "${FREEGLUT_INCLUDE_PATH}" )
# MESSAGE( "${FREEGLUT_LIBRARY}" )
# MESSAGE( "${FreeGLUT_DEFINITIONS}" )
# if(NOT FREEGLUT_FOUND)
#     message(ERROR " FreeGLUT not found!")
# endif(NOT FREEGLUT_FOUND)

#########################################################
# Doxygen
#########################################################

# add a target to generate API documentation with Doxygen
find_package(Doxygen QUIET)
# message( "${DOXYGEN_EXECUTABLE}" )
if(DOXYGEN_FOUND)
    set(CMAKE_DOC_OUTPUT_DIRECTORY ${CMAKE_CURRENT_BINARY_DIR}/doc)
    configure_file(${CMAKE_CURRENT_SOURCE_DIR}/doc/Doxyfile.in ${CMAKE_DOC_OUTPUT_DIRECTORY}/Doxyfile @ONLY)
    add_custom_target(doc
            ${DOXYGEN_EXECUTABLE} ${CMAKE_DOC_OUTPUT_DIRECTORY}/Doxyfile
            WORKING_DIRECTORY ${CMAKE_DOC_OUTPUT_DIRECTORY}
            COMMENT "Generating API documentation with Doxygen" VERBATIM)
endif(DOXYGEN_FOUND)



#########################################################
#
# PROJECT LIBRARIES
#
#########################################################

#########################################################
# TRACKER LIBRARY
#########################################################

include(.cmake/RegisterTarget.cmake)
add_subdirectory(src)


include_directories(${CMAKE_CURRENT_SOURCE_DIR}/src/tracker)

