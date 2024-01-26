plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = AppConfigs.namespace
    compileSdk = AppConfigs.compileSdk

    defaultConfig {
        applicationId = AppConfigs.applicationId
        minSdk = AppConfigs.minSdk
        targetSdk = AppConfigs.targetSdk
        versionCode = AppConfigs.versionCode
        versionName = AppConfigs.versionName

        testInstrumentationRunner = AppConfigs.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppConfigs.javaVersion
        targetCompatibility = AppConfigs.javaVersion
    }
    kotlinOptions {
        jvmTarget = AppConfigs.jvmTarget
    }
    buildFeatures {
        compose = true
        viewBinding = true

        // https://medium.com/androiddevelopers/5-ways-to-prepare-your-app-build-for-android-studio-flamingo-release-da34616bb946
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfigs.kotlinCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(project(ProjectModules.galleryKit))
    implementation(project(ProjectModules.galleryKitImpl))
    implementation(project(ProjectModules.musicPlayerKit))
    implementation(project(ProjectModules.musicPlayerKitImpl))
    implementation(project(ProjectModules.commonUi))
    implementation(project(ProjectModules.fileScanner))
    implementation(project(ProjectModules.fileScannerImpl))

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

    implementation(Libs.timber)

    testImplementation(Libs.Testing.junit)
    androidTestImplementation(Libs.Testing.junitExt)
    androidTestImplementation(Libs.Testing.espresso)
    androidTestImplementation(platform(Libs.Testing.Compose.bom))
    androidTestImplementation(Libs.Testing.Compose.junit)
    debugImplementation(Libs.Testing.Compose.uiTooling)
    debugImplementation(Libs.Testing.Compose.uiTestManifest)
}