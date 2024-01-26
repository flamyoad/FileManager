plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = AppConfigs.namespace
    compileSdk = AppConfigs.compileSdk

    defaultConfig {
        minSdk = AppConfigs.minSdk

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
    implementation(project(ProjectModules.musicPlayerKit))
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