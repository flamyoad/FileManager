pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FileManager"
include(":app")
include(":gallery-kit")
include(":gallery-kit-impl")
include(":music-player-kit")
include(":music-player-kit-impl")
include(":common-ui")
