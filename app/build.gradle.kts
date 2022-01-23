plugins {
    id("com.android.application")
    id("kotlin-android")
    id("androidx.navigation.safeargs.kotlin")
    id("kotlin-kapt")
}

android {
    compileSdk = ProjectVersions.compileSdk

    defaultConfig {
        applicationId = "com.github.mobdev778.yusupova.app"
        minSdk = ProjectVersions.minSdk
        targetSdk = ProjectVersions.targetSdk
        versionCode = ProjectVersions.versionCode
        versionName = ProjectVersions.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        val options = this
        options.jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(
        Modules.core,

        Modules.repository.localGallery,
        Modules.repository.remoteGallery,

        Modules.repository.localVerses,
        Modules.repository.remoteVerses,

        Modules.splash
    )

    implementation(
        Libs.androidX.coreKtx,
        Libs.androidX.appCompat,
        Libs.androidX.constraintLayout,

        Libs.android.material,

        Libs.kotlin.stdLib,

        Libs.navigation.fragmentKtx,
        Libs.navigation.uiKtx,

        Libs.dagger2.dagger
    )

    kapt(
        Libs.dagger2.daggerCompiler
    )

    testImplementation(
        TestLibs.jUnit
    )

    androidTestImplementation(
        AndroidTestLibs.extJUnit,
        AndroidTestLibs.espressoCore
    )

}