package org.trials.bench

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import org.trials.SequentialSearch
import java.util.*
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 10, time = 55, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 100, time = 55, timeUnit = TimeUnit.MILLISECONDS)
open class SequentialSearchBench : SizedBenchmark() {
    private var random = Random()
    private var searcher: SequentialSearch<Int> = SequentialSearch()
    private var collection: List<Int> = listOf()
    private var needle: Int = 0

    @Setup(Level.Iteration)
    fun setUp() {
        collection = (1..size).toList()

        needle = if (probability == 0.0) {
            -1
        } else {
            random.nextInt(size * (1.0 / probability).toInt()) + 1
        }
    }

    @Benchmark
    fun sequentialSearch(blackhole: Blackhole) {
        blackhole.consume(searcher.search(collection, needle))
    }
}
