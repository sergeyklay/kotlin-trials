val kotlinJvmTarget = "1.8"
val jmhCoreVersion = "1.22"

plugins {
    kotlin("jvm") version "1.3.72"
    id("me.champeau.gradle.jmh") version "0.5.0"
}

group = "org.trials"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    // Benchmarking
    implementation("org.openjdk.jmh", "jmh-core", jmhCoreVersion)
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = kotlinJvmTarget
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = kotlinJvmTarget
    }
}

jmh {
    jmhVersion = jmhCoreVersion
}
