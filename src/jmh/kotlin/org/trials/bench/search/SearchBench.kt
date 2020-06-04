package org.trials.bench.search

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import org.trials.search.BinarySearch
import org.trials.search.SequentialSearch
import java.util.*
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 10, time = 55, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 100, time = 55, timeUnit = TimeUnit.MILLISECONDS)
open class SearchBench : SizedBenchmark() {
    private var random = Random()
    private var sequentialSearcher: SequentialSearch<Int> =
        SequentialSearch()
    private var binarySearcher: BinarySearch<Int> =
        BinarySearch()

    private var collection: Array<Int> = arrayOf()
    private var needle: Int = 0

    @Setup(Level.Iteration)
    fun setUp() {
        collection = (1..size).toList().toTypedArray()

        needle = if (probability == 0.0) {
            -1
        } else {
            random.nextInt(size * (1.0 / probability).toInt()) + 1
        }
    }

    @Benchmark
    fun binarySearch(blackhole: Blackhole) {
        blackhole.consume(binarySearcher.search(collection, needle))
    }

    @Benchmark
    fun sequentialSearch(blackhole: Blackhole) {
        blackhole.consume(sequentialSearcher.search(collection, needle))
    }
}
