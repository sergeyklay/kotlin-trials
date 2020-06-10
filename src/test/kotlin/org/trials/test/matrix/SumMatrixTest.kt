package org.trials.test.matrix

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith
import org.trials.IntMatrix

class SumMatrixTest : ShouldSpec({
    val matrix = IntMatrix()

    should("sum matrices") {
        val actual = matrix.sum(
            listOf(
                listOf(3, 0, -3),
                listOf(2, -1, 8)
            ),
            listOf(
                listOf(1, 2, 3),
                listOf(3, 1, -7)
            )
        )

        actual.size shouldBeEqualComparingTo 2

        actual[0] shouldContainExactly listOf(4, 2, 0)
        actual[1] shouldContainExactly listOf(5, 0, 1)
    }

    should("throw an exception when calling sum on matrices with not the same dimension") {
        val exception = shouldThrow<RuntimeException> {
            matrix.sum(
                listOf(
                    listOf(3, 0, -3),
                    listOf(2, -1, 8),
                    listOf(2, -1, 8)
                ),
                listOf(
                    listOf(1, 2, 3),
                    listOf(3, 1, -7)
                )
            )
        }

        exception.message should startWith("Dimension of matrices is not equivalent")
    }
})
