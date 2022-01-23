sealed class Modules(internal val name: String) {
    object core: Modules(":core")
    sealed class repository(name: String): Modules(name) {
        object localGallery: repository(":repository:local:gallery")
        object remoteGallery: repository(":repository:remote:gallery")
        object localVerses: repository(":repository:local:verses")
        object remoteVerses: repository(":repository:remote:gallery")
    }
    object splash: Modules(":splash")
    object app: Modules(":app")
}