plugins {
    id("com.android.library")
    id("android-library-base")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.flamyoad.explorer_impl"

    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfigs.kotlinCompilerExtensionVersion
    }
}


dependencies {
    implementation(project(ProjectModules.explorer))
    implementation(project(ProjectModules.fileScanner))
    implementation(project(ProjectModules.common))
    implementation(project(ProjectModules.commonUi))

    implementation(Libs.AndroidX.coreKtx)

    implementation(Libs.KotlinX.serialization)

    implementation(Libs.Coroutines.core)
    implementation(Libs.Coroutines.android)

    implementation(Libs.Navigation.navigationCompose)

    implementation(Libs.Lifecycle.runtimeCompose)

    implementation(platform(Libs.Compose.bom))
    implementation(Libs.Compose.ui)
    implementation(Libs.Compose.uiGraphics)
    implementation(Libs.Compose.toolingPreview)
    implementation(Libs.Compose.material3)
    implementation(Libs.Compose.activityCompose)

    implementation(Libs.Hilt.hilt)
    implementation(Libs.Hilt.hiltNavigationCompose)
    kapt(Libs.Hilt.hiltCompiler)

    testImplementation(Libs.Testing.junit)
}