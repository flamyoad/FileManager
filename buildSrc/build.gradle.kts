repositories {
    google()
    mavenCentral()
}

gradlePlugin {
    plugins {
        register("android-library-base") {
            id = "android-library-base"
            implementationClass = "LibraryGradlePlugin"
        }
        register("android-application-compose") {
            id = "android-application-compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("android-library-compose") {
            id = "android-library-compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
    }
}

plugins {
    `java-gradle-plugin`
    `kotlin-dsl`
}


dependencies {
    implementation("com.android.tools.build:gradle:8.2.1")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.10")

    /*
     * https://github.com/google/dagger/issues/3068
     * AGP brings in older version of javapoet which is incompatible with Hilt
     */
    implementation("com.squareup:javapoet:1.13.0")
}