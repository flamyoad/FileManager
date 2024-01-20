import org.gradle.api.JavaVersion

object AppConfigs {
    const val namespace = "com.flamyoad.filemanager"
    const val applicationId = "com.flamyoad.filemanager"
    const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val compileSdk = 34
    const val minSdk = 24
    const val targetSdk = 34
    const val versionCode = 1
    const val versionName = "1.0"

    const val jvmTarget = "1.8"
    val javaVersion = JavaVersion.VERSION_1_8

    const val kotlinCompilerExtensionVersion = "1.5.1"
}