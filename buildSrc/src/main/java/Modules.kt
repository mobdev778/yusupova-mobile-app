sealed class Modules(internal val name: String) {
    object core: Modules(":core")
    sealed class repository(name: String): Modules(name) {
        object localGallery: repository(":repository:local:gallery")
        object localVerses: repository(":repository:local:verses")

        object remoteRetrofit: repository(":repository:remote:retrofit")
        object remoteGallery: repository(":repository:remote:gallery")
        object remoteVerses: repository(":repository:remote:verses")
    }
    object splash: Modules(":splash")
    object app: Modules(":app")
}