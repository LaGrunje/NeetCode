import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.api.tasks.Exec
import org.gradle.api.tasks.JavaExec
import org.gradle.api.tasks.testing.Test
import org.gradle.kotlin.dsl.*

class ProblemPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.repositories {
            mavenCentral()
        }

        project.plugins.apply("org.jetbrains.kotlin.jvm")

        project.extensions.getByType(JavaPluginExtension::class.java).apply {
            sourceCompatibility = org.gradle.api.JavaVersion.VERSION_21
            targetCompatibility = org.gradle.api.JavaVersion.VERSION_21
        }

        project.dependencies {
            add("testImplementation", "org.jetbrains.kotlin:kotlin-test-junit5:1.9.23")
            add("testImplementation", "org.junit.jupiter:junit-jupiter:5.10.2")
            add("testRuntimeOnly", "org.junit.platform:junit-platform-launcher:1.10.2")
        }

        val problemName = project.name

        val javaExtension = project.extensions.getByType(JavaPluginExtension::class.java)
        val mainSourceSet = javaExtension.sourceSets.getByName("main")
        mainSourceSet.java.srcDir("kotlin")
        val testSourceSet = javaExtension.sourceSets.getByName("test")
        testSourceSet.java.srcDir("test")

        project.tasks.named("test", Test::class.java) {
            useJUnitPlatform()
        }

        project.tasks.register("solveKotlin", JavaExec::class.java) {
            group = "problems"
            description = "Run Kotlin solution for $problemName"
            classpath = mainSourceSet.runtimeClasspath
            mainClass.set("SolutionKt")
        }

        project.tasks.register("solve") {
            group = "problems"
            description = "Run both solutions for $problemName"
            dependsOn("test", "testCpp")
        }

        val cppTestDir = project.projectDir.resolve("cpp_test")
        val cppTestOut = project.layout.buildDirectory.file("cpp/solution_test").get().asFile

        project.tasks.register("compileCppTest", Exec::class.java) {
            group = "problems"
            description = "Compile C++ tests for $problemName"
            commandLine(
                "g++", "-std=c++20",
                "-I/opt/homebrew/Cellar/googletest/1.17.0/include",
                "-L/opt/homebrew/Cellar/googletest/1.17.0/lib",
                cppTestDir.resolve("solution_test.cpp").absolutePath,
                "-o", cppTestOut.absolutePath,
                "-lgtest", "-lgtest_main", "-pthread"
            )
            doFirst { cppTestOut.parentFile.mkdirs() }
        }

        project.tasks.register("testCpp", Exec::class.java) {
            group = "problems"
            description = "Run C++ tests for $problemName"
            dependsOn("compileCppTest")
            commandLine(cppTestOut.absolutePath)
        }
    }
}