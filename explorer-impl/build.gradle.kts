plugins {
    id("com.android.library")
    id("android-library-base")
    id("android-library-compose")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    kotlin("plugin.serialization")
}

android {
    namespace = "com.flamyoad.explorer_impl"
}

dependencies {
    implementation(project(ProjectModules.explorer))
    implementation(project(ProjectModules.fileScanner))
    implementation(project(ProjectModules.common))
    implementation(project(ProjectModules.commonUi))

    implementation(Libs.AndroidX.coreKtx)

    implementation(Libs.KotlinX.serialization)

    implementation(Libs.coil)

    implementation(Libs.Coroutines.core)
    implementation(Libs.Coroutines.android)

    implementation(Libs.Hilt.hilt)
    implementation(Libs.Hilt.hiltNavigationCompose)
    ksp(Libs.Hilt.hiltCompiler)

    testImplementation(Libs.Testing.junit)
}