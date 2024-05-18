// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") /*version "8.2.1"*/ apply false
    id("org.jetbrains.kotlin.android") /*version "1.9.0"*/ apply false
    id("com.google.dagger.hilt.android") version "2.50" apply false
    id("com.grab.grazel")
}

grazel {
    rules {
        mavenInstall {
            httpArchiveRepository {
                sha256 = "f36441aa876c4f6427bfb2d1f2d723b48e9d930b62662bf723ddfb8fc80f0140"
                stripPrefix = "rules_jvm_external-5.2"
                url = "https://github.com/bazelbuild/rules_jvm_external/archive/5.2.zip"
            }
        }
        bazelCommon {
            gitRepository {
                // ERROR: Error computing the main repository mapping: cannot load '@@grab_bazel_common//android:repositories.bzl': no such file
                // so use back old ones, MR #113 still has the .bzl file

                // old 1
//                commit = "cbae5e9ddd921f914656f7de8ee6cac1181f5015"

                // old2  - MR #113
                commit = "78a0a8aa2eb877d6d6686eea56159ada49eb6821"

                //new
//                commit = "b3ced63a493c8990e1ab410e645111aa25fb7df7"
                remote = "https://github.com/grab/grab-bazel-common.git"
            }
        }
        kotlin {
            // WORKSPACE
            gitRepository {
                commit = "cb82644daed72d783ab410a635316638596a00b8"
//                commit = "58fde1a5d0ab6fa812ba3fb93331b2d7652fd3b6"
                remote = "https://github.com/bazelbuild/rules_kotlin.git"
            }
            // WORKSPACE
            compiler {
//                version = "1.4.20"
                version = "1.9.0"
                sha = "46720991a716e90bfc0cf3f2c81b2bd735c14f4ea6a5064c488e04fd76e6b6c7"
            }
            // https://bazelbuild.github.io/rules_kotlin/kotlin#kt_kotlinc_options
            kotlinC {
                useIr = false
            }
            // https://bazelbuild.github.io/rules_kotlin/kotlin#define_kt_toolchain
            toolchain {
                enabled = true
                apiVersion = "1.4"
                reportUnusedDeps = "off"
                strictKotlinDeps = "off"
                abiJars = true
                multiplexWorkers = true
                languageVersion = "1.4"
                jvmTarget = "1.8"
            }
        }
    }
}

task("clean") {
    delete(rootProject.buildDir)
}