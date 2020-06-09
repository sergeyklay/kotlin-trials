import org.gradle.api.tasks.testing.logging.TestLogEvent

// The bytecode generated by the Kotlin compiler.
//
// Note: The version of the JVM you use to run the Kotlin compiler is
// independent from the version of the bytecode that the compiler generates.
//
// For example, the bytecode generated by the Kotlin compiler, when the
// target version is set to either 1.6 or 1.8, is fully compatible with JVM 11.
val jvmBytecodeVersion = "1.8"

val jmhVersion = "1.23"
val jupiterVersion = "5.6.2"
val kotestVersion = "4.0.6"

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

    testImplementation("org.junit.jupiter:junit-jupiter-api:$jupiterVersion")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$jupiterVersion")

    testImplementation("io.kotest:kotest-runner-junit5-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
    testImplementation("io.kotest:kotest-property-jvm:$kotestVersion")

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
        kotlinOptions.jvmTarget = jvmBytecodeVersion
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = jvmBytecodeVersion
    }
}

jmh {
    threads = 4 // Number of worker threads to run with
    verbosity = "NORMAL" // Verbosity mode. Available modes are: [SILENT, NORMAL, EXTRA]
    humanOutputFile = project.file("${project.buildDir}/reports/jmh/human.txt") // human-readable output file
    resultsFile = project.file("${project.buildDir}/reports/jmh/results.txt") // results file
}
