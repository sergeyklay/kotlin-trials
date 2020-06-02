package org.trials.bench

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole

//@BenchmarkMode(Mode.AverageTime)
//@Measurement(iterations = 3, batchSize = 3)
open class SequentialSearchBench {

    @Benchmark
    fun testMe(blackhole: Blackhole) {
        val a = 1
        val b = 2

        blackhole.consume(a + b)
    }
}
