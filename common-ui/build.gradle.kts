plugins {
    id("com.android.library")
    id("android-library-base")
    id("android-library-compose")
}

android {
    namespace = "com.flamyoad.filemanager.common_ui"
}

dependencies {
    // https://developer.android.com/reference/kotlin/androidx/compose/material/icons/package-summary
    // TODO: Due to the very large size of this library, make sure to use R8/Proguard to strip unused icons if you are including this library as a direct dependency
    api(Libs.Compose.materialIconsExtended)

    implementation(project(ProjectModules.common))
    implementation(Libs.coil)
}