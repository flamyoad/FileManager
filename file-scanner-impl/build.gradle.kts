plugins {
    id("com.android.library")
    id("android-library-base")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.flamyoad.file_scanner_impl"
}

dependencies {
    implementation(project(ProjectModules.fileScanner))
    implementation(project(ProjectModules.common))

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.Coroutines.core)
    implementation(Libs.Coroutines.android)

    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltCompiler)

    testImplementation(Libs.Testing.junit)
}