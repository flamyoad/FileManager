plugins {
    id("com.android.library")
    id("android-library-base")
    id("android-library-compose")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.flamyoad.filemanager.gallery_kit_impl"
}

dependencies {
    implementation(project(ProjectModules.galleryKit))
    implementation(project(ProjectModules.common))
    implementation(project(ProjectModules.commonUi))
    implementation(project(ProjectModules.fileScanner))

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.material)
    implementation(Libs.AndroidX.constraintLayout)

    implementation(Libs.KotlinX.serialization)

    implementation(Libs.Lifecycle.runtimeKtx)

    implementation(Libs.Hilt.hilt)
    implementation(Libs.Hilt.hiltNavigationCompose)
    ksp(Libs.Hilt.hiltCompiler)

    testImplementation(Libs.Testing.junit)
    androidTestImplementation(Libs.Testing.junitExt)
    androidTestImplementation(Libs.Testing.espresso)
}