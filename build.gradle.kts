// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Plugin do Android.
    // A versão é definida no libs.versions.toml.
    alias(libs.plugins.android.application) apply false

    // Plugin Kotlin para Android.
    // Necessário porque estamos usando AGP 8.10.1.
    alias(libs.plugins.kotlin.android) apply false

    // Plugin do compilador do Jetpack Compose.
    alias(libs.plugins.kotlin.compose) apply false
}