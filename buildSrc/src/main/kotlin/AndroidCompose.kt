import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import com.android.build.api.dsl.CommonExtension

internal fun Project.configureAndroidCompose(commonExtension: CommonExtension<*, *, *, *, *>) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        composeOptions {
            kotlinCompilerExtensionVersion = AppConfigs.kotlinCompilerExtensionVersion
        }
    }

    dependencies {
        add("implementation", platform(Libs.Compose.bom))
        add("implementation", Libs.Compose.ui)
        add("implementation", Libs.Compose.uiGraphics)
        add("implementation", Libs.Compose.toolingPreview)
        add("implementation", Libs.Compose.material3)
        add("implementation", Libs.Compose.activityCompose)
        add("implementation", Libs.Lifecycle.runtimeCompose)
        add("implementation", Libs.Navigation.navigationCompose)

        add("androidTestImplementation", platform(Libs.Testing.Compose.bom))
        add("androidTestImplementation", Libs.Testing.Compose.junit)

        add("debugImplementation", Libs.Testing.Compose.uiTooling)
        add("debugImplementation", Libs.Testing.Compose.uiTestManifest)
    }

}