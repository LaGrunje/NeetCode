plugins {
    kotlin("jvm") apply false
}

tasks.register("solveAll") {
    dependsOn(subprojects.mapNotNull { it.tasks.findByName("solveKotlin") })
}