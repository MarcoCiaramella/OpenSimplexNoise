//
// Created by Marco on 08/10/2021.
//

#ifndef OPENSIMPLEXNOISE_LOG_H
#define OPENSIMPLEXNOISE_LOG_H

#include <android/log.h>

#define  LOG_TAG    "JNI LOG"

#define  LOGI(...)  __android_log_print(ANDROID_LOG_INFO, LOG_TAG, __VA_ARGS__)
#define  LOGD(...)  __android_log_print(ANDROID_LOG_DEBUG, LOG_TAG, __VA_ARGS__)
#define  LOGE(...)  __android_log_print(ANDROID_LOG_ERROR, LOG_TAG, __VA_ARGS__)

#endif //OPENSIMPLEXNOISE_LOG_H
