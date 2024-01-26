// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version Libs.hiltVersion apply false
    id("com.android.library") version "8.2.1" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Plugins.kotlinGradle)
        classpath(Plugins.gms)
        classpath(Plugins.hiltGradle)
        classpath(Plugins.googleSecret)
        classpath(Plugins.navigationSafeArgs)
    }
}

task("clean") {
    delete(rootProject.buildDir)
}