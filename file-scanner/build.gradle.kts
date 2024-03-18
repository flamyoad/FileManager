plugins {
    id("com.android.library")
    id("android-library-base")
}

android {
    namespace = "com.flamyoad.filemanager.file_scanner"
}

dependencies {
    implementation(Libs.Coroutines.core)
    implementation(Libs.Coroutines.android)

    testImplementation(Libs.Testing.junit)
}