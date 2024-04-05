import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    java
    application
    kotlin("jvm") version "1.9.21"
}

group = "graphics.scenery"
version = "0.2.0-SNAPSHOT"
description = "minimal-scenery-example-project"

repositories {
    maven("https://maven.scijava.org/content/groups/public")
    mavenCentral()
    maven("https://jitpack.io")
    // this allows Gradle to use the local Maven repository in ~/.m2, which can be handy
    // for local builds. Activate e.g. via ./gradlew -PmavenLocal=true or specifying
    // mavenLocal=true in gradle.properties.
    if(project.properties["mavenLocal"] == "true") { mavenLocal() }
}

dependencies {
    // you can use either Git hashes here to identify a version,
    // or version tags from https://github.com/scenerygraphics/scenery/releases
    // the version declaration here also enables to run Gradle with a specific scenery version given,
    // e.g. ./gradlew -PsceneryVersion=my.scenery.version
    val sceneryVersion = project.properties["sceneryVersion"] ?: "0.10.1"
    implementation("graphics.scenery:scenery:$sceneryVersion")

    // necessary for logging to work correctly, adjust to the logging
    // framework of your liking
    runtimeOnly("org.slf4j:slf4j-simple:1.7.30")
}

application {
    mainClass ="graphics.scenery.MinimalSceneryExample"
}

tasks {
    withType<KotlinCompile>().all {
        kotlinOptions {
            jvmTarget = project.properties["jvmTarget"]?.toString() ?: "21"
            freeCompilerArgs += listOf("-Xinline-classes", "-opt-in=kotlin.RequiresOptIn")
        }
    }

    withType<JavaCompile>().all {
        targetCompatibility = project.properties["jvmTarget"]?.toString() ?: "21"
        sourceCompatibility = project.properties["jvmTarget"]?.toString() ?: "21"
    }

    named<Test>("test") {
        useJUnitPlatform()
    }
}
