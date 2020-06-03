package org.trials.bench

import org.openjdk.jmh.annotations.*
import org.openjdk.jmh.infra.Blackhole
import org.trials.SequentialSearch
import java.util.concurrent.TimeUnit

@State(Scope.Thread)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 10, time = 55, timeUnit = TimeUnit.MILLISECONDS)
@Measurement(iterations = 100, batchSize = 10, time = 55, timeUnit = TimeUnit.MILLISECONDS)
open class SequentialSearchBench {
    private var searcher: SequentialSearch<Int> = SequentialSearch()
    private var collections: MutableMap<Int, List<Int>> = mutableMapOf()
    private var needles: MutableMap<Int, Int> = mutableMapOf()

    @Setup(Level.Iteration)
    fun setUp() {
        collections = mutableMapOf(
            4096   to (1..4096).toList(),
            8192   to (1..8192).toList(),
            16384  to (1..16384).toList(),
            32768  to (1..32768).toList(),
            65536  to (1..65536).toList(),
            131072 to (1..131072).toList()
        )

        needles = mutableMapOf(
            4096   to (1..4096).shuffled().first(),
            8192   to (1..8192).shuffled().first(),
            16384  to (1..16384).shuffled().first(),
            32768  to (1..32768).shuffled().first(),
            65536  to (1..65536).shuffled().first(),
            131072 to (1..131072).shuffled().first()
        )
    }

    private fun doSearch(collection: List<Int>, needle: Int): Boolean {
        if (searcher.search(collection, needle)) {
            return true
        }

        return false
    }

    @Benchmark
    fun e4096p1(blackhole: Blackhole) {
        blackhole.consume(doSearch(collections[4096]!!, needles[4096]!!))
    }

    @Benchmark
    fun e8192p1(blackhole: Blackhole) {
        blackhole.consume(doSearch(collections[8192]!!, needles[8192]!!))
    }

    @Benchmark
    fun e16384p1(blackhole: Blackhole) {
        blackhole.consume(doSearch(collections[16384]!!, needles[16384]!!))
    }

    @Benchmark
    fun e32768p1(blackhole: Blackhole) {
        blackhole.consume(doSearch(collections[32768]!!, needles[32768]!!))
    }

    @Benchmark
    fun e65536p1(blackhole: Blackhole) {
        blackhole.consume(doSearch(collections[65536]!!, needles[65536]!!))
    }

    @Benchmark
    fun e131072p1(blackhole: Blackhole) {
        blackhole.consume(doSearch(collections[131072]!!, needles[131072]!!))
    }
}
