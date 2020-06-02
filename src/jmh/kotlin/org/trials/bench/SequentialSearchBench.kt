package org.trials.bench

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 5, time = 55, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 4, time = 55, timeUnit = TimeUnit.MILLISECONDS)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
open class SequentialSearchBench {

    @Benchmark
    fun e4096p1(blackhole: Blackhole) {
        val a = 2
        val b = 1

        blackhole.consume(a + b)
    }
}
