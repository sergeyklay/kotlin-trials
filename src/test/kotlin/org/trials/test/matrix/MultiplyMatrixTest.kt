package org.trials.test.matrix

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import org.trials.IntMatrix

class MultiplyMatrixTest : ShouldSpec({
    val matrix = IntMatrix()

    should("multiply a matrix by the given scalar") {
        val actual = matrix.multiply(
            listOf(
                listOf(5, 2),
                listOf(3, 1)
            ), 2
        )

        actual.size shouldBeEqualComparingTo 2

        actual[0] shouldContainExactly listOf(10, 4)
        actual[1] shouldContainExactly listOf(6, 2)
    }
})
