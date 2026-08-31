import org.gradle.accessors.dm.LibrariesForLibs
import org.gradle.kotlin.dsl.dependencies

plugins {

    id("buildlogic.bloop")
    // TODO: fix apply false plugin deprecation
    id("buildlogic.quarkus-common-conventions") // apply false
    id("buildlogic.scala-conventions")
}
val libs = the<LibrariesForLibs>()
// https://github.com/scalacenter/bloop/pull/1548
//bloop {
//    stdLibName = "scala3-library_3"
//}
// currently only supporting scala 3x here

dependencies {
    implementation(libs.quarkus.scala.s3)
}
