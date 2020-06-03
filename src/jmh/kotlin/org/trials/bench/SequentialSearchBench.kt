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
    private var needles: MutableMap<String, Int> = mutableMapOf()
    private var collections: MutableMap<Int, List<Int>> = mutableMapOf(
        4096   to (1..4096).toList(),
        8192   to (1..8192).toList(),
        16384  to (1..16384).toList(),
        32768  to (1..32768).toList(),
        65536  to (1..65536).toList(),
        131072 to (1..131072).toList()
    )

    @Setup(Level.Iteration)
    fun setUp() {
        needles = mutableMapOf(
            "4096p${size}" to if (size > 0) random.nextInt(4096 * size) + 1 else -1,
            "8192p${size}" to if (size > 0) random.nextInt(8192 * size) + 1 else -1,
            "16384p${size}" to if (size > 0) random.nextInt(16384 * size) + 1 else -1,
            "32768p${size}" to if (size > 0) random.nextInt(32768 * size) + 1 else -1,
            "65536p${size}" to if (size > 0) random.nextInt(65536 * size) + 1 else -1,
            "131072p${size}" to if (size > 0) random.nextInt(131072 * size) + 1 else -1
        )
    }

    @Benchmark
    fun e4096(blackhole: Blackhole) {
        blackhole.consume(searcher.search(collections[4096]!!, needles["4096p1"]!!))
    }

    @Benchmark
    fun e8192(blackhole: Blackhole) {
        blackhole.consume(searcher.search(collections[8192]!!, needles["8192p1"]!!))
    }

    @Benchmark
    fun e16384(blackhole: Blackhole) {
        blackhole.consume(searcher.search(collections[16384]!!, needles["16384p1"]!!))
    }

    @Benchmark
    fun e32768(blackhole: Blackhole) {
        blackhole.consume(searcher.search(collections[32768]!!, needles["32768p1"]!!))
    }

    @Benchmark
    fun e65536(blackhole: Blackhole) {
        blackhole.consume(searcher.search(collections[65536]!!, needles["65536p1"]!!))
    }

    @Benchmark
    fun e131072(blackhole: Blackhole) {
        blackhole.consume(searcher.search(collections[131072]!!, needles["131072p1"]!!))
    }
}
