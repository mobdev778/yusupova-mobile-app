import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.`implementation`(vararg elements: String) {
    elements.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.`androidTestImplementation`(vararg elements: String) {
    elements.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.`testImplementation`(vararg elements: String) {
    elements.forEach { dependency ->
        add("testImplementation", dependency)
    }
}

