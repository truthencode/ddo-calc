/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package io.truthencode.plugins.example

import java.io.File
import org.gradle.testkit.runner.GradleRunner
import kotlin.test.Test
import kotlin.test.assertTrue

/**
 * A simple functional test for the 'io.truthencode.plugins.example.greeting' plugin.
 */
class PocGradlePluginPluginFunctionalTest {
    @Test
    fun `can run task`() {
        // Setup the test build
        val projectDir = File("build/functionalTest")
        projectDir.mkdirs()
        projectDir.resolve("settings.gradle").writeText("")
        projectDir.resolve("build.gradle").writeText("""
            plugins {
                id('io.truthencode.plugins.example.greeting')
            }
        """)

        // Run the build
        val runner = GradleRunner.create()
            .forwardOutput()
            .withPluginClasspath()
            .withProjectDir(projectDir)
        val result = runner.build();

        // Verify the result
        assertTrue(result.output.contains("Hello from plugin 'io.truthencode.plugins.example.greeting'"))
    }
}
