plugins {
    id("com.android.library")
    id("android-library-base")
    id("android-library-compose")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.flamyoad.filemanager.gallery_kit_impl"
}

dependencies {
    implementation(project(ProjectModules.galleryKit))
    implementation(project(ProjectModules.commonUi))

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.material)
    implementation(Libs.AndroidX.constraintLayout)

    implementation(Libs.Lifecycle.runtimeKtx)

    implementation(Libs.Hilt.hilt)
    ksp(Libs.Hilt.hiltCompiler)

    testImplementation(Libs.Testing.junit)
    androidTestImplementation(Libs.Testing.junitExt)
    androidTestImplementation(Libs.Testing.espresso)
}