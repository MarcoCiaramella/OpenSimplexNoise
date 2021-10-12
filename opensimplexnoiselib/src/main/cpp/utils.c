//
// Created by Marco on 08/10/2021.
//

#include <stdlib.h>
#include <jni.h>
#include "log.h"

void check_points_size_2(jint size, jint num_points){
    if ((size / 2) != num_points) {
        LOGF("Input array must be in the form of [x0,y0,x1,y1,....xn,yn]");
        exit(0);
    }
}

void check_points_size_3(jint size, jint num_points){
    if ((size / 3) != num_points) {
        LOGF("Input array must be in the form of [x0,y0,z0,x1,y1,z1,....xn,yn,zn]");
        exit(0);
    }
}

void check_points_size_4(jint size, jint num_points){
    if ((size / 4) != num_points) {
        LOGF("Input array must be in the form of [x0,y0,z0,w0,x1,y1,z1,w1,....xn,yn,zn,wn]");
        exit(0);
    }
}