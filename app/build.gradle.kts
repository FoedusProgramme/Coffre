plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.objectbox)
}

android {
    namespace = "dev.n3shemmy3.coffre"
    compileSdk = 35

    buildFeatures {
        buildConfig = true
    }
    defaultConfig {
        applicationId = "dev.n3shemmy3.coffre"
        minSdk = 27
        targetSdk = 35
        versionCode = 4
        versionName = "1.0.3 Amanatsu"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    signingConfigs {
        create("release") {
            val storePath = project.findProperty("SHEMMY_RELEASE_STORE_FILE")?.toString()
            if (storePath == null) {
                println("Warning: SHEMMY_RELEASE_STORE_FILE is not defined.")
            }

            storeFile = storePath?.let { file(it) }
            storePassword = project.findProperty("SHEMMY_RELEASE_STORE_PASSWORD") as String?
            keyAlias = project.findProperty("SHEMMY_RELEASE_KEY_ALIAS") as String?
            keyPassword = project.findProperty("SHEMMY_RELEASE_KEY_PASSWORD") as String?
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildToolsVersion = "35.0.0"
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(libs.coordinatorlayout)
    implementation(libs.fragment)
    implementation(libs.glide)
    implementation (libs.gson)
    implementation(libs.viewpager2)
    implementation(libs.viewmodel)
    implementation(libs.viewmodel.savedstate)
    implementation(libs.livedata)
    implementation(libs.splashscreen)
    implementation(libs.recyclerview)
    implementation(libs.recyclerview.selection)
    implementation(libs.preference)
    implementation(libs.paging)
    implementation (libs.swiperefreshlayout)
    implementation (libs.ticker)
    implementation (libs.objectbox.android)
    implementation(libs.work.runtime)
    implementation(libs.vico.views)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}