
plugins {
    id("com.android.application")
    id("kotlin-android")
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
}

dependencies {

    implementation(
        libs.AndroidX.coreKtx,
        libs.AndroidX.appCompat,

        libs.Android.material,

        libs.AndroidX.constraintLayout
    )

    testImplementation(
        test.JUnit.jUnit
    )

    androidTestImplementation(
        test.AndroidX.extJunit,
        test.AndroidX.espressoCore
    )

}