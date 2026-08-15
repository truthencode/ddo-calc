import net.ltgt.gradle.errorprone.errorprone
import net.ltgt.gradle.nullaway.nullaway
import org.gradle.accessors.dm.LibrariesForLibs

/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2022-2023 Andre White.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Common java conventions
 * @author Andre White
 * @since 0.0.1
 * Includes general configurations for jvm projects that use the java plugin.
 * This includes kotlin / scala plugins which automatically apply the java plugin
 */
val libs = the<LibrariesForLibs>()
plugins {
    java
    id("buildlogic.common-conventions")
    id("net.ltgt.nullaway")
    id("net.ltgt.errorprone")
}

dependencies {

    errorprone(libs.nullaway.errorprone)
    errorprone(libs.errorprone.processor)
// add implementation dependency on jspecify for non-java-library projects
// java-library will have an API dependency
    if (!plugins.hasPlugin("java-library")) {
        implementation(libs.jspecify)
    }
}

// See https://gist.github.com/adarro/0411f34ae1f048726b28e9f33e5c0a97 for JPMS revisit
// TODO: remove hard-coded JDK 21 move to lib constant as least worst case?
// TODO: locate all instances using this concept and consolidate
val defaultJavaToolChainVersion = providers.gradleProperty("defaultJavaToolChainVersion").getOrElse("21")

val javaToolchainVersion =
    provider {
        defaultJavaToolChainVersion.toInt()
    }

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(javaToolchainVersion.get()))
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.errorprone {
        val regExcludeScala = Regex("""(.*\.scala|.*/generated*/.*)""")
        excludedPaths = regExcludeScala.pattern
        disableWarningsInGeneratedCode = true

        nullaway {
            suggestSuppressions = true
            onlyNullMarked = true
            isAssertsEnabled = true
            isJSpecifyMode = true
        }
    }

    // Add Type Annotations to Symbol for JDK 21+ to support NullAway and other tools that rely on type annotations.

     // We use a lazy provider to safely inspect the toolchain metadata before execution
//    val compilerMetadata = javaCompiler.map { it.metadata }.get()

//    options.compilerArgs.addAll(compilerMetadata.map { metadata ->
//        val vendorName = metadata.vendor.toString().lowercase()
//        val version = metadata.languageVersion.asInt()
//
//        // 1. Check version: Must be less than JDK 22
//        // 2. Check vendor: Exclude Oracle, ensure it is an OpenJDK-based build
//        val isTargetVersion = version < 22
//        val isNotOracle = !vendorName.contains("oracle")
//        val isOpenJdk = vendorName.contains("openjdk") ||
//                        vendorName.contains("adoptium") ||
//                        vendorName.contains("temurin") ||
//                        vendorName.contains("zulu") ||
//                        vendorName.contains("azul")
//
//        if (isTargetVersion && isNotOracle && isOpenJdk) {
//            listOf("-XDaddTypeAnnotationsToSymbol=true")
//        } else {
//            emptyList()
//        }
//    })
}

tasks.withType<Javadoc> {
    options.encoding = "UTF-8"
}
