sealed class AndroidTestLibs(val name: String) {

    object extJUnit: AndroidTestLibs("androidx.test.ext:junit:1.1.3")
    object espressoCore: AndroidTestLibs("androidx.test.espresso:espresso-core:3.4.0")
    object coroutineCore: AndroidTestLibs("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

}