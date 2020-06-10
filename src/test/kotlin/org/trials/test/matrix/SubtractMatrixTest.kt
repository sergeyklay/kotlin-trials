package org.trials.test.matrix

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith
import org.trials.IntMatrix

class SubtractMatrixTest: ShouldSpec({
    val matrix = IntMatrix()

    should("subtract matrices") {
        val actual = matrix.subtract(
            listOf(
                listOf(1, 2),
                listOf(2, 3)
            ),
            listOf(
                listOf(-2, 0),
                listOf(2, 5)
            )
        )

        actual.size shouldBeEqualComparingTo 2

        actual[0] shouldContainExactly listOf(3, 2)
        actual[1] shouldContainExactly listOf(0, -2)
    }

    should("throw an exception when calling subtract on matrices with not the same dimension") {
        val exception = shouldThrow<RuntimeException> {
            matrix.subtract(
                listOf(
                    listOf(3, 0, -3),
                    listOf(2, -1)
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
