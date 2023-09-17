plugins {
//    kotlin("jvm") version "1.9.10"
    id("io.truthencode.poc.kantlr.kotlin-library-conventions")
    antlr
//    id("java-library-conventions")
//    id("be.vbgn.ci-detect")
    id("code-quality")
    // id("djaxonomy.test-conventions")
    idea
    id("djaxonomy.kotlin-test-conventions")
}

dependencies {
    implementation(enforcedPlatform(project(":ddo-platform")))
    antlr(libs.antlr4) // use ANTLR version 4
    implementation(libs.logback.classic)
// // implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.5.31"))
//     // testImplementation(enforcedPlatform("org.junit:junit-bom:5.8.2"))

//     antlr("org.antlr:antlr4") // use ANTLR version 4
//     implementation("ch.qos.logback:logback-core")
//     implementation("ch.qos.logback:logback-classic")
//     implementation("org.slf4j:slf4j-api")
//     // JUnit 5
// //     testImplementation(group = "org.junit.jupiter", name = "junit-jupiter-api")
// //     testImplementation(group = "org.junit.platform", name = "junit-platform-runner")
// //     testRuntimeOnly(group = "org.junit.platform", name = "junit-platform-engine")
// //     testRuntimeOnly(group = "org.junit.platform", name = "junit-platform-launcher")
// // //    testRuntimeOnly(group = "co.helmethair", name = "scalatest-junit-runner")
// //     testRuntimeOnly(group = "org.junit.vintage", name = "junit-vintage-engine")
// //     testRuntimeOnly(group = "org.junit.jupiter", name = "junit-jupiter-engine")
// }
}

repositories {
    mavenCentral()
}

val antlrJavaPath =
    PackagePath(project.layout.buildDirectory.dir("generated-src/java").get().asFile.path, "io.truthencode.ddo.grammar.antlr")

data class PackagePath(val source: String, val packageName: String) {
    /**
     * Property stores the base output folder.
     * This should generally be similar to 'src/generated/java'
     */
    val baseOutputFolder: File = File(source)

    fun packageToPath(packageId: String): File {
        val ps = System.getProperty("file.separator")
        val np = packageId.replace(".", ps)
        logger.warn("baseOutputFolder: $baseOutputFolder")
        return File(baseOutputFolder, np)
    }

    val packageFolder: File
        get() = packageToPath(packageName)
}
// src/generated/java/EnchantmentsParserVisitor.java
// sourceSets {
//    named("main") {
//        java.sourceDirectories.files.plus(antlrJavaPath.baseOutputFolder)
//    }
// }

// Intellij
// idea {
//    module {
//        sourceDirs.add(antlrJavaPath.baseOutputFolder)
//        generatedSourceDirs.add(antlrJavaPath.baseOutputFolder)
//        // .addAll(listOf(javaGenPath))
//    }
// }

kotlin {
    logger.error("we are here")

    this.sourceSets.named("main") {
//        kotlin.srcDir(antlrJavaPath.baseOutputFolder)
//        logger.error("value of baseOutput (path) ${antlrJavaPath.baseOutputFolder.path}")
//        this.kotlin.sourceDirectories.plus(antlrJavaPath.baseOutputFolder)
//
//      //  this.kotlin.sourceDirectories.plus(java.sourceSets.map{it.java.sourceDirectories.files}.flatten())
//
//
//        logger.error("Kotlin Enumerating source set files")
        kotlin.sourceDirectories.forEach {
            logger.error(it.name)
        }
    }
}

tasks {
    generateGrammarSource {
        maxHeapSize = "64m"
//        arguments = arguments + listOf("-visitor", "-long-messages", "-lib", antlrJavaPath.packageFolder.absolutePath)
        arguments = arguments + listOf("-visitor", "-long-messages")
        //     outputDirectory = antlrJavaPath.packageFolder
//        logger.error("outputting generated antlr classes to ${antlrJavaPath.packageFolder}")
    }

    // withType(KotlinCompile::class) {
    //     dependsOn(generateGrammarSource)
    // }

    named("compileKotlin") {
        dependsOn(generateGrammarSource)
    }

    named("compileTestKotlin") {
        dependsOn(generateTestGrammarSource)
    }

//    withType(Test::class.java) {
//        systemProperties["concordion.output.dir"] = "${reporting.baseDir}/spec"
//    }
//    logger.info("concordion output directory: *************************************")
//    // Use the built-in JUnit support of Gradle.
//    "test"(Test::class) {
//        useJUnitPlatform {
//            includeEngines = setOf("junit-jupiter", "vintage")
// //            if (ci.isCi)
// //                excludeTags = setOf(
// //                    "Integration",
// //                    "io.truthencode.tags.Integration",
// //                    "FunctionOnly",
// //                    "io.truthencode.tags.FunctionOnly"
// //                )
//            testLogging {
//                events("passed", "skipped", "failed")
//            }
//        }
//
//        outputs.upToDateWhen { false }
//    }
}