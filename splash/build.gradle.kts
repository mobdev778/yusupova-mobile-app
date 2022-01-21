plugins {
    id("com.android.library")
    id("kotlin-android")
}

apply {
    plugin("kotlin-android")
}

android {
    compileSdk = ProjectVersions.compileSdk

    defaultConfig {
        minSdk = ProjectVersions.minSdk
        targetSdk = ProjectVersions.targetSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        Libs.androidX.coreKtx,
        Libs.androidX.appCompat,
        Libs.androidX.constraintLayout,

        Libs.android.material,

        Libs.kotlin.stdLib
    )

    testImplementation(
        TestLibs.jUnit
    )

    androidTestImplementation(
        AndroidTestLibs.extJUnit,
        AndroidTestLibs.espressoCore
    )

}