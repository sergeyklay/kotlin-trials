import org.gradle.api.tasks.testing.logging.TestLogEvent

val kotlinJvmTarget = "1.8"
val jmhVersion = "1.22"

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
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")

    // Benchmarking
    jmh("org.openjdk.jmh", "jmh-core", jmhVersion)
}

tasks {
    test {
        useJUnitPlatform()
        testLogging {
            events (TestLogEvent.FAILED,
                    TestLogEvent.PASSED,
                    TestLogEvent.SKIPPED)
        }
    }
    compileKotlin {
        kotlinOptions.jvmTarget = kotlinJvmTarget
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = kotlinJvmTarget
    }
}

jmh {
    threads = 4 // Number of worker threads to run with
    verbosity = "NORMAL" // Verbosity mode. Available modes are: [SILENT, NORMAL, EXTRA]
    humanOutputFile = project.file("${project.buildDir}/reports/jmh/human.txt") // human-readable output file
    resultsFile = project.file("${project.buildDir}/reports/jmh/results.txt") // results file
}
