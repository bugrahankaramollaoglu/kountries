import org.gradle.kotlin.dsl.androidTestImplementation
import org.gradle.kotlin.dsl.implementation
import org.gradle.kotlin.dsl.testImplementation

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("plugin.serialization") version "2.0.21"
    id("androidx.navigation.safeargs")
    kotlin("kapt")
}

android {
    namespace = "com.bugrahankaramollaoglu.countries"
    compileSdk = 35

    buildFeatures {
        viewBinding = true
    }

    defaultConfig {
        applicationId = "com.bugrahankaramollaoglu.countries"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    dataBinding{
        enable = true
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    dependencies {
        val retrofitVersion = "2.9.0" // Updated to latest stable version

        // AndroidX Core
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.appcompat)
        implementation(libs.androidx.activity)
        implementation(libs.androidx.constraintlayout)
        implementation(libs.material)

        // Lifecycle
        implementation(libs.androidx.lifecycle.extensions)
        implementation(libs.androidx.lifecycle.livedata.ktx)
        implementation(libs.androidx.lifecycle.viewmodel.ktx)

        // Room
        implementation(libs.androidx.room.runtime)
        implementation(libs.androidx.room.ktx)
        kapt(libs.androidx.room.compiler)

        // Coroutines
        implementation(libs.kotlinx.coroutines.core)

        // Navigation
        implementation(libs.androidx.navigation.fragment.ktx)
        implementation(libs.androidx.navigation.ui.ktx)
        // Remove duplicate navigation dependencies
        // implementation(libs.androidx.navigation.compose)
        // implementation(libs.androidx.navigation.fragment)
        // implementation(libs.androidx.navigation.ui)
        // implementation(libs.androidx.navigation.dynamic.features.fragment)
        androidTestImplementation(libs.androidx.navigation.testing)

        // JSON Serialization
        implementation(libs.kotlinx.serialization.json)

        // Retrofit - updated to 2.9.0
        implementation(libs.retrofit) {
            exclude(group = "com.squareup.okhttp3", module = "okhttp")
        }
        implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion") {
            exclude(group = "com.google.code.gson", module = "gson")
        }
        implementation(libs.adapter.rxjava2) {
            exclude(group = "io.reactivex.rxjava2", module = "rxjava")
        }

        // RxJava
        implementation(libs.rxjava)
        implementation(libs.rxandroid)

        // Glide
        implementation(libs.glide)

        // Preferences
        implementation(libs.androidx.preference.ktx)

        // Testing
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)

        // Add this to help with dependency conflicts
        configurations.all {
            resolutionStrategy {
                force("androidx.core:core-ktx:1.16.0")
                // Exclude support-compat if it's being pulled in by another dependency
                exclude(group = "com.android.support", module = "support-compat")
            }
        }
    }
}