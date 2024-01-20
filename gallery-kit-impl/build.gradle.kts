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
    implementation(project(ProjectModules.galleryKit))
    implementation(project(ProjectModules.commonUi))

    implementation(CoreDependencies.AndroidX.coreKtx)
    implementation(CoreDependencies.AndroidX.appCompat)
    implementation(CoreDependencies.AndroidX.material)
    implementation(CoreDependencies.AndroidX.constraintLayout)

    implementation(platform(CoreDependencies.Compose.bom))
    implementation(CoreDependencies.Compose.ui)
    implementation(CoreDependencies.Compose.uiGraphics)
    implementation(CoreDependencies.Compose.toolingPreview)
    implementation(CoreDependencies.Compose.material3)
    implementation(CoreDependencies.Compose.activityCompose)

    implementation(CoreDependencies.Lifecycle.runtimeKtx)

    implementation(CoreDependencies.Hilt.hilt)
    kapt(CoreDependencies.Hilt.hiltCompiler)

    testImplementation(CoreDependencies.Testing.junit)
    androidTestImplementation(CoreDependencies.Testing.junitExt)
    androidTestImplementation(CoreDependencies.Testing.espresso)
    androidTestImplementation(platform(CoreDependencies.Testing.Compose.bom))
    androidTestImplementation(CoreDependencies.Testing.Compose.junit)
    debugImplementation(CoreDependencies.Testing.Compose.uiTooling)
    debugImplementation(CoreDependencies.Testing.Compose.uiTestManifest)
}