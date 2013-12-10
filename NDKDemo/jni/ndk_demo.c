#include "com_marakana_NativeLib.h"

JNIEXPORT jstring JNICALL Java_com_marakana_NativeLib_hello
  (JNIEnv * env, jobject obj) {
		return (*env)->NewStringUTF(env, "Hello World!");
}

JNIEXPORT jint JNICALL Java_com_marakana_NativeLib_add
  (JNIEnv * env, jobject obj, jint value1, jint value2) {
		return (value1 + value2);
}
