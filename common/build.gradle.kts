plugins {
    id("com.android.library")
    id("android-library-base")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.flamyoad.filemanager.common"
}

dependencies {
    implementation(Libs.Coroutines.core)
    implementation(Libs.Coroutines.android)
    implementation(Libs.Coroutines.test)

    implementation(Libs.Hilt.hilt)
    ksp(Libs.Hilt.hiltCompiler)

    testImplementation(project(ProjectModules.testShared))
}