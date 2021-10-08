//
// Created by Marco on 08/10/2021.
//

#include <stdlib.h>
#include <jni.h>
#include "log.h"

void check_points_size(jint size, jint num_points, int dim_point){
    if ((size / dim_point) != num_points) {
        LOGE("Wrong points size");
        exit(0);
    }
}