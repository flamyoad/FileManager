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
}