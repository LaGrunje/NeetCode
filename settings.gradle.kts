pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "NeetCode"

rootDir.resolve("problems")
    .listFiles()
    ?.filter { it.isDirectory }
    ?.forEach { category ->
        category.listFiles()
            ?.filter { it.isDirectory }
            ?.forEach { problem ->
                include(":problems:${category.name}:${problem.name}")
            }
    }