import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinJvmTarget = "1.8"

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
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = kotlinJvmTarget
    }
}
