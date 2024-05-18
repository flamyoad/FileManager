workspace(name = "FileManager")

load("@bazel_tools//tools/build_defs/repo:git.bzl",  "git_repository")

git_repository(
  name = "io_bazel_rules_kotlin",
  commit = "58fde1a5d0ab6fa812ba3fb93331b2d7652fd3b6",
  remote = "https://github.com/bazelbuild/rules_kotlin.git"
)

load("@io_bazel_rules_kotlin//kotlin:dependencies.bzl",  "kt_download_local_dev_dependencies")

kt_download_local_dev_dependencies()
KOTLIN_VERSION = "1.4.20"
KOTLINC_RELEASE_SHA = "46720991a716e90bfc0cf3f2c81b2bd735c14f4ea6a5064c488e04fd76e6b6c7"

load("@io_bazel_rules_kotlin//kotlin:repositories.bzl",  "kotlin_repositories",  "kotlinc_version")

KOTLINC_RELEASE = kotlinc_version(
        release = KOTLIN_VERSION,
        sha256 = KOTLINC_RELEASE_SHA
    )
kotlin_repositories(compiler_release = KOTLINC_RELEASE)
register_toolchains("//:kotlin_toolchain")

load("@bazel_tools//tools/build_defs/repo:git.bzl",  "git_repository")

git_repository(
  name = "grab_bazel_common",
  commit = "78a0a8aa2eb877d6d6686eea56159ada49eb6821",
  remote = "https://github.com/grab/grab-bazel-common.git"
)

load("@grab_bazel_common//android:repositories.bzl",  "bazel_common_dependencies")

bazel_common_dependencies()

load("@grab_bazel_common//android:initialize.bzl",  "bazel_common_initialize")

bazel_common_initialize(patched_android_tools = True,  buildifier_version = "5.1.0")

DAGGER_TAG = "2.28.1"
DAGGER_SHA = "9e69ab2f9a47e0f74e71fe49098bea908c528aa02fa0c5995334447b310d0cdd"
load("@bazel_tools//tools/build_defs/repo:http.bzl",  "http_archive")

http_archive(
  name = "dagger",
  strip_prefix = "dagger-dagger-%s" % DAGGER_TAG,
  sha256 = DAGGER_SHA,
  url = "https://github.com/google/dagger/archive/dagger-%s.zip" % DAGGER_TAG
)

load("@dagger//:workspace_defs.bzl",  "DAGGER_ARTIFACTS",  "DAGGER_REPOSITORIES")

load("@bazel_tools//tools/build_defs/repo:http.bzl",  "http_archive")

http_archive(
  name = "rules_jvm_external",
  strip_prefix = "rules_jvm_external-5.2",
  sha256 = "f36441aa876c4f6427bfb2d1f2d723b48e9d930b62662bf723ddfb8fc80f0140",
  url = "https://github.com/bazelbuild/rules_jvm_external/archive/5.2.zip"
)


load("@rules_jvm_external//:defs.bzl",  "maven_install")

load("@rules_jvm_external//:specs.bzl",  "maven")

maven_install(
  artifacts = DAGGER_ARTIFACTS + [
    "androidx.activity:activity-compose:1.8.2"
,
    "androidx.appcompat:appcompat:1.6.1"
,
    "androidx.compose.compiler:compiler:1.5.1"
,
    "androidx.compose.material3:material3:1.1.1"
,
    "androidx.compose.ui:ui-graphics:1.5.0"
,
    "androidx.compose.ui:ui-tooling-preview:1.5.0"
,
    "androidx.compose.ui:ui:1.5.0"
,
    "androidx.compose:compose-bom:2023.08.00"
,
    "androidx.constraintlayout:constraintlayout:2.1.4"
,
    "androidx.core:core-ktx:1.12.0"
,
    "androidx.databinding:viewbinding:8.2.1"
,
    "androidx.hilt:hilt-navigation-compose:1.2.0"
,
    "androidx.lifecycle:lifecycle-runtime-compose:2.6.1"
,
    "androidx.lifecycle:lifecycle-runtime-ktx:2.6.1"
,
    "androidx.navigation:navigation-compose:2.5.1"
,
    "com.google.android.material:material:1.7.0"
,
    "com.jakewharton.timber:timber:4.7.1"
,
    "org.jetbrains.kotlin:kotlin-annotation-processing-gradle:1.9.0"
,
    "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.0"
,
    "org.jetbrains.kotlin:kotlin-stdlib:1.9.20"
,
    "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4"
,
    "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1"
,
  ],
  repositories = DAGGER_REPOSITORIES + [
    "https://maven.google.com",
    "https://repo1.maven.org/maven2",
  ],
  jetify_include_list = [
    "androidx.activity:activity-compose",
    "androidx.appcompat:appcompat",
    "androidx.compose.compiler:compiler",
    "androidx.compose.material3:material3",
    "androidx.compose.ui:ui",
    "androidx.compose.ui:ui-graphics",
    "androidx.compose.ui:ui-tooling-preview",
    "androidx.compose:compose-bom",
    "androidx.constraintlayout:constraintlayout",
    "androidx.core:core-ktx",
    "androidx.databinding:viewbinding",
    "androidx.hilt:hilt-navigation-compose",
    "androidx.lifecycle:lifecycle-runtime-compose",
    "androidx.lifecycle:lifecycle-runtime-ktx",
    "androidx.navigation:navigation-compose",
    "com.google.android.material:material",
    "com.jakewharton.timber:timber",
    "org.jetbrains.kotlin:kotlin-annotation-processing-gradle",
    "org.jetbrains.kotlin:kotlin-stdlib",
    "org.jetbrains.kotlin:kotlin-stdlib-jdk8",
    "org.jetbrains.kotlinx:kotlinx-coroutines-android",
    "org.jetbrains.kotlinx:kotlinx-coroutines-core",
  ],
  fail_on_missing_checksum = False,
  resolve_timeout = 600
)

load("@maven//:defs.bzl",  "pinned_maven_install")

pinned_maven_install()
android_sdk_repository(
  name = "androidsdk",
  api_level = 34,
  build_tools_version = "34.0.0"
)

android_ndk_repository(
  name = "androidndk"
)

