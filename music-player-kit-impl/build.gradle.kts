plugins {
    id("com.android.library")
    id("android-library-base")
    id("android-library-compose")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.flamyoad.filemanager.music_player_kit_impl"
}

dependencies {
    implementation(project(ProjectModules.musicPlayerKit))
    implementation(project(ProjectModules.commonUi))

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appCompat)

    implementation(Libs.Lifecycle.runtimeKtx)

    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltCompiler)

    testImplementation(Libs.Testing.junit)
    androidTestImplementation(Libs.Testing.junitExt)
    androidTestImplementation(Libs.Testing.espresso)
}