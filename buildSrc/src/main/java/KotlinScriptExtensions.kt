import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler

fun DependencyHandler.`implementation`(vararg libs: Libs) {
    libs.forEach { dependency ->
        add("implementation", dependency.name)
    }
}

fun DependencyHandler.`implementation`(vararg modules: Modules) {
    modules.forEach { module ->
        val map = mapOf("path" to module.name)
        val projectDependency = project(map) as ProjectDependency
        add("implementation", projectDependency)
    }
}

fun DependencyHandler.`androidTestImplementation`(vararg elements: AndroidTestLibs) {
    elements.forEach { androidTestLib ->
        add("androidTestImplementation", androidTestLib.name)
    }
}

fun DependencyHandler.`testImplementation`(vararg elements: TestLibs) {
    elements.forEach { testLib ->
        add("testImplementation", testLib.name)
    }
}

