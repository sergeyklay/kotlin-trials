package org.trials.bench.search

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import org.trials.search.*
import java.util.*
import java.util.concurrent.TimeUnit

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@Warmup(iterations = 10, time = 55, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 100, time = 55, timeUnit = TimeUnit.MILLISECONDS)
open class SearchBench : SizedBenchmark() {
    private var random = Random()

    private var linearSearcher: LinearSearch<Int> = LinearSearch()
    private var binarySearcher: BinarySearch<Int> = BinarySearch()
    private var jumpSearcher: JumpSearch<Int> = JumpSearch()

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
    fun linearSearch(blackhole: Blackhole) {
        blackhole.consume(linearSearcher.search(collection, needle))
    }

    @Benchmark
    fun binarySearch(blackhole: Blackhole) {
        blackhole.consume(binarySearcher.search(collection, needle))
    }

    @Benchmark
    fun jumpSearch(blackhole: Blackhole) {
        blackhole.consume(jumpSearcher.search(collection, needle))
    }
}
