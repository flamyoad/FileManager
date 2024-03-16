import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import com.android.build.gradle.LibraryExtension
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

enum class ModuleType {
    Application,
    AndroidLibrary,
    JavaLibrary
}

class ApplicationGradlePlugin: Plugin<Project> {
    override fun apply(project: Project) {
        applyCommonPlugins(project)
        applyKotlin(project)
        project.configure(ModuleType.Application)
    }
}

class LibraryGradlePlugin: Plugin<Project> {
    override fun apply(project: Project) {
        applyCommonPlugins(project)
        applyKotlin(project)
        project.configure(ModuleType.AndroidLibrary)
    }
}

internal fun applyCommonPlugins(project: Project) {
    project.apply {
        plugin("org.jetbrains.kotlin.android")
    }
}

internal fun Project.configure(moduleType: ModuleType) {
    when (moduleType) {
        ModuleType.Application -> configureWithAppPlugin(this)
        ModuleType.AndroidLibrary -> configureWithLibraryPlugin(this)
        ModuleType.JavaLibrary -> {}
    }
}

private fun configureWithAppPlugin(project: Project) {
    project.extensions.getByType(ApplicationExtension::class.java).apply {
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
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
    }
}

private fun configureWithLibraryPlugin(project: Project) {
    project.extensions.getByType<LibraryExtension>().apply {
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
        packaging {
            resources {
                excludes += "/META-INF/{AL2.0,LGPL2.1}"
            }
        }
    }
}

private fun applyKotlin(project: Project) {
    project.tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = AppConfigs.jvmTarget
            // Treat all Kotlin warnings as errors (disabled by default)
            // Override by setting warningsAsErrors=true in your ~/.gradle/gradle.properties
            val warningsAsErrors: String? by project
            allWarningsAsErrors = warningsAsErrors.toBoolean()
            freeCompilerArgs = freeCompilerArgs + listOf(
                "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            )
        }
    }
}

