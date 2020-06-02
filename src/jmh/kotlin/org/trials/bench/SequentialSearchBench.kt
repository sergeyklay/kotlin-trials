package org.trials.bench

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole

open class SequentialSearchBench {

    @Benchmark
    fun testMe(blackhole: Blackhole) {
        val a = 1
        val b = 2

        blackhole.consume(a + b)
    }
}
