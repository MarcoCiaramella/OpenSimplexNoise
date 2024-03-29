# Sets the minimum version of CMake required to build your native library.
# This ensures that a certain set of CMake features is available to
# your build.

cmake_minimum_required(VERSION 3.4.1)

# Specifies a library name, specifies whether the library is STATIC or
# SHARED, and provides relative paths to the source code. You can
# define multiple libraries by adding multiple add_library() commands,
# and CMake builds them for you. When you build your app, Gradle
# automatically packages shared libraries with your APK.

add_library(
        OpenSimplex2F
        SHARED
        src/main/cpp/utils.c
        src/main/cpp/OpenSimplex2F.c
)

target_link_libraries(
        OpenSimplex2F
        android
        log
)

add_library(
        OpenSimplex2S
        SHARED
        src/main/cpp/utils.c
        src/main/cpp/OpenSimplex2S.c
)

target_link_libraries(
        OpenSimplex2S
        android
        log
)

# Specifies a path to native header files.
include_directories(src/main/cpp/include/)