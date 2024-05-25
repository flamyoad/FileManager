plugins {
    id("com.android.library")
    id("android-library-base")
}

android {
    namespace = "com.flamyoad.filemanager.common_ui"
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfigs.kotlinCompilerExtensionVersion
    }
}

dependencies {
    implementation(platform(Libs.Compose.bom))
    implementation(Libs.Compose.ui)
    implementation(Libs.Compose.uiGraphics)
    implementation(Libs.Compose.toolingPreview)
    implementation(Libs.Compose.material3)
    implementation(Libs.Compose.activityCompose)

    // https://developer.android.com/reference/kotlin/androidx/compose/material/icons/package-summary
    // TODO: Due to the very large size of this library, make sure to use R8/Proguard to strip unused icons if you are including this library as a direct dependency
    api(Libs.Compose.materialIconsExtended)
}