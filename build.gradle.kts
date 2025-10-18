group = "io.github.mikaojk"
version = "1.0.0"

val javaVersion = 25

plugins {
    alias(libs.plugins.kotlin.jvm)
    application
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(javaVersion)
    }
}

application {
    mainClass.set("io.github.mikaojk.MainKt")
}

repositories {
    mavenCentral()
}
