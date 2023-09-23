/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2015-2021 Andre White.
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

description = "Common misc String and convenience Utilities"

plugins {
    id("scala-library-profile")
//    id("acceptance-test-conventions")
    scala
}
val scalaLibraryVersion: String by project
dependencies {
    dependencies {
        val scalaLibraryVersion: String by project
        val scalaMajorVersion: String by project

        implementation(enforcedPlatform(project(":ddo-platform-scala")))
        // Platform dependent
        implementation(libs.scala2.library)

        implementation(libs.enumeratum.s213)
        implementation(libs.logback.classic)
        implementation(libs.typesafe.scala.logging.s213)
    }
}