plugins {
    id("com.android.library")
    id("android-library-base")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.flamyoad.filemanager.gallery_kit_impl"
    buildFeatures {
        compose = true
        viewBinding = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfigs.kotlinCompilerExtensionVersion
    }
}

dependencies {
    implementation(project(ProjectModules.galleryKit))
    implementation(project(ProjectModules.commonUi))

    implementation(Libs.AndroidX.coreKtx)
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.material)
    implementation(Libs.AndroidX.constraintLayout)

    implementation(platform(Libs.Compose.bom))
    implementation(Libs.Compose.ui)
    implementation(Libs.Compose.uiGraphics)
    implementation(Libs.Compose.toolingPreview)
    implementation(Libs.Compose.material3)
    implementation(Libs.Compose.activityCompose)

    implementation(Libs.Lifecycle.runtimeKtx)

    implementation(Libs.Hilt.hilt)
    kapt(Libs.Hilt.hiltCompiler)

    testImplementation(Libs.Testing.junit)
    androidTestImplementation(Libs.Testing.junitExt)
    androidTestImplementation(Libs.Testing.espresso)
    androidTestImplementation(platform(Libs.Testing.Compose.bom))
    androidTestImplementation(Libs.Testing.Compose.junit)
    debugImplementation(Libs.Testing.Compose.uiTooling)
    debugImplementation(Libs.Testing.Compose.uiTestManifest)
}