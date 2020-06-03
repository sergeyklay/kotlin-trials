package org.trials.bench

import org.openjdk.jmh.annotations.*

@State(Scope.Thread)
open class SizedBenchmark {
    @Param("1", "2") var size: Int = 0
}
