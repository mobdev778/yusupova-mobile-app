plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
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
}

dependencies {

    implementation(
        Modules.core,
        Modules.repository.remoteRetrofit
    )

    implementation(
        Libs.kotlin.stdLib,

        Libs.dagger2.dagger,

        Libs.retrofit2.retrofit,
        Libs.retrofit2.moshi,

        Libs.coroutines.core
    )

    kapt(
        Libs.dagger2.daggerCompiler
    )

    testImplementation(
        TestLibs.jUnit
    )

    androidTestImplementation(
        AndroidTestLibs.extJUnit,
        AndroidTestLibs.espressoCore,
        AndroidTestLibs.coroutineCore
    )

    kaptAndroidTest(
        Libs.dagger2.daggerCompiler
    )

}