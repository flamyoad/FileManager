// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version CoreDependencies.hiltVersion apply false
    id("com.android.library") version "8.2.1" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(BuildDependencies.buildGradle)
        classpath(BuildDependencies.kotlinGradle)
        classpath(BuildDependencies.gms)
        classpath(BuildDependencies.hiltGradle)
        classpath(BuildDependencies.googleSecret)
        classpath(BuildDependencies.navigationSafeArgs)
    }
}

task("clean") {
    delete(rootProject.buildDir)
}