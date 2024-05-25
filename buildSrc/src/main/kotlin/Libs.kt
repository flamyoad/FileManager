object Libs {

    const val navigationVersion = "2.8.0-beta01" // https://medium.com/androiddevelopers/navigation-compose-meet-type-safety-e081fb3cf2f8
    const val lifecycleVersion = "2.6.0"
    const val hiltVersion = "2.50"
    const val androidxHiltVersion = "1.2.0"
    const val dataStoreVersion = "1.0.0"
    const val coroutineVersion = "1.6.0"

    object AndroidX {
        const val coreKtx = "androidx.core:core-ktx:1.12.0"
        const val appCompat = "androidx.appcompat:appcompat:1.6.1"
        const val material = "com.google.android.material:material:1.7.0"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"
        const val browser = "androidx.browser:browser:1.5.0"
    }

    object Navigation {
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:$navigationVersion"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:$navigationVersion"
        const val navigationCompose = "androidx.navigation:navigation-compose:$navigationVersion"
    }

    object Compose {
        const val bom = "androidx.compose:compose-bom:2023.08.00"
        const val activityCompose = "androidx.activity:activity-compose:1.8.2"
        const val ui = "androidx.compose.ui:ui"
        const val uiGraphics = "androidx.compose.ui:ui-graphics"
        const val toolingPreview = "androidx.compose.ui:ui-tooling-preview"
        const val material3 = "androidx.compose.material3:material3"
        const val materialIconsExtended = "androidx.compose.material:material-icons-extended:1.6.7"
    }

    object Lifecycle {
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$lifecycleVersion"
        const val commonJava = "androidx.lifecycle:lifecycle-common-java8:$lifecycleVersion"
        const val runtimeCompose = "androidx.lifecycle:lifecycle-runtime-compose:$lifecycleVersion"
        const val viewModelCompose = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"
    }

    object Hilt {
        const val hilt = "com.google.dagger:hilt-android:$hiltVersion"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:$hiltVersion"
        const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$androidxHiltVersion"
    }

    object Coroutines {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion"
    }

    object DataStore {
        const val dataStore = "androidx.datastore:datastore:$dataStoreVersion"
        const val dataStorePreferences = "androidx.datastore:datastore-preferences:$dataStoreVersion"
    }

    object KotlinX {
        const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3"
    }

    object Testing {
        private const val mockitoVersion = "5.10.0"
        private const val mockitoKotlinVersion = "5.2.1"

        const val junit = "junit:junit:4.13.2"
        const val mockito =  "org.mockito:mockito-core:$mockitoVersion"
        const val mockitoKotlin = "org.mockito.kotlin:mockito-kotlin:$mockitoKotlinVersion"
        const val junitExt = "androidx.test.ext:junit:1.1.5"
        const val espresso = "androidx.test.espresso:espresso-core:3.5.1"
        const val navigation = "androidx.navigation:navigation-testing:$navigationVersion"

        object Compose {
            const val bom = "androidx.compose:compose-bom:2023.08.00"
            const val junit = "androidx.compose.ui:ui-test-junit4"
            const val uiTooling = "androidx.compose.ui:ui-tooling"
            const val uiTestManifest = "androidx.compose.ui:ui-test-manifest"
        }

        object Hilt {
            const val androidTesting = "com.google.dagger:hilt-android-testing:$hiltVersion"
            const val compiler = "com.google.dagger:hilt-compiler:$hiltVersion"
        }
    }

    const val timber = "com.jakewharton.timber:timber:4.7.1"
    const val coil = "io.coil-kt:coil:2.5.0"
}