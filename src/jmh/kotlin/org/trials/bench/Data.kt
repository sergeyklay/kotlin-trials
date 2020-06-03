package org.trials.bench

import org.openjdk.jmh.annotations.*

@State(Scope.Thread)
open class SizedBenchmark {
    @Param("1.0", "0.5", "0.25", "0.0") var probability: Double = 0.0
    @Param("4096", "8192", "16384", "32768", "65536", "131072") var size: Int = 0
}
