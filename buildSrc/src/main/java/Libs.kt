sealed class Libs(val name: String) {

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

}