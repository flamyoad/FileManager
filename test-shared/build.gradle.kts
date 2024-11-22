plugins {
    id("com.android.library")
    id("android-library-base")
}

android {
    namespace = "com.flamyoad.filemanager.test_shared"
}

dependencies {
    api(Libs.Testing.junit)
    api(Libs.Testing.mockito)
    api(Libs.Testing.mockitoKotlin)
    api(Libs.Testing.turbine)
    api(Libs.Coroutines.test)
}