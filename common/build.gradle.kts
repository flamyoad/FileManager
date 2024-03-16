plugins {
    id("com.android.library")
    id("android-library-base")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.flamyoad.filemanager.common"
}

dependencies {
    implementation(Libs.Coroutines.core)
    implementation(Libs.Coroutines.android)

    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltCompiler)

    testImplementation(Libs.Testing.junit)
    testImplementation(Libs.Testing.mockito)
    testImplementation(Libs.Testing.mockitoKotlin)
}