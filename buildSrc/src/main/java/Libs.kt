sealed class Libs(internal val name: String) {

    sealed class androidX(name: String): Libs(name) {

        object coreKtx: androidX("androidx.core:core-ktx:1.7.0")
        object appCompat: androidX("androidx.appcompat:appcompat:1.4.1")
        object constraintLayout: androidX("androidx.constraintlayout:constraintlayout:2.1.3")

    }

    sealed class android(name: String): Libs(name) {

        object material: android("com.google.android.material:material:1.5.0")

    }

    sealed class kotlin(name: String): Libs(name) {

        object stdLib: kotlin("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.10")

    }

    sealed class navigation(name: String): Libs(name) {

        object fragmentKtx: navigation("androidx.navigation:navigation-fragment-ktx:2.3.5")
        object uiKtx: navigation("androidx.navigation:navigation-ui-ktx:2.3.5")

    }

    sealed class dagger2(name: String): Libs(name) {

        object dagger: dagger2("com.google.dagger:dagger:2.37")
        object daggerCompiler: dagger2("com.google.dagger:dagger-compiler:2.37")

    }

    sealed class retrofit2(name: String): Libs(name) {

        object retrofit: retrofit2("com.squareup.retrofit2:retrofit:2.9.0")
        object moshi: retrofit2("com.squareup.moshi:moshi-kotlin:1.9.0")
        object converterMoshi: retrofit2("com.squareup.retrofit2:converter-moshi:2.9.0")

    }

    sealed class coroutines(name: String): Libs(name) {

        object core: coroutines("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
        object android: coroutines("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.0")

    }

}