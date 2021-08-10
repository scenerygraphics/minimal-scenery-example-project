import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    application
    kotlin("jvm") version "1.5.20"
}

group = "graphics.scenery"
version = "0.1.0-SNAPSHOT"
description = "minimal-scenery-example-project"

repositories {
    maven("https://maven.scijava.org/content/groups/public")
    maven("https://nexus.senbox.net/nexus/content/groups/public/")
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    // you can use either Git hashes here to identify a version,
    // or version tags from https://github.com/scenerygraphics/scenery/releases
    implementation("graphics.scenery:scenery:57dc16fc0c")

    implementation(kotlin("stdlib-jdk8"))

    // necessary for logging to work correctly, adjust to the logging
    // framework of your liking
    runtimeOnly("org.slf4j:slf4j-simple:1.7.30")
}

application {
    @Suppress("DEPRECATION")
    mainClassName ="graphics.scenery.MinimalSceneryExample"
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "11"
        sourceCompatibility = "11"
    }

    named<Test>("test") {
        useJUnitPlatform()
    }
}
