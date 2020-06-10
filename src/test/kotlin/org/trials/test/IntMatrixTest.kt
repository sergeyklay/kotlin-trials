package org.trials.test

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import org.trials.IntMatrix

class IntMatrixTest : ShouldSpec({
    should("not transpose empty matrices") {
        val matrix = IntMatrix()
        matrix.transpose().isEmpty() shouldBe true
    }

    should("transpose matrices") {
        val matrix = IntMatrix(
            listOf(
                listOf(1, 2),
                listOf(3, 4),
                listOf(5, 6)
            )
        )

        val actual = matrix.transpose()

        actual.size shouldBeEqualComparingTo 2

        actual[0] shouldContainExactly listOf(1, 3, 5)
        actual[1] shouldContainExactly listOf(2, 4, 6)
    }

    should("get the matrix in the initial state after transpose it twice") {
        val expected = listOf(
            listOf(1, 2),
            listOf(3, 4),
            listOf(5, 6)
        )

        IntMatrix(IntMatrix(expected).transpose()).transpose() shouldContainExactly expected
    }

    should("multiply matrices") {
        val matrix = IntMatrix(
            listOf(
                listOf(5, 2),
                listOf(3, 1)
            )
        )

        val actual = matrix.multiply(2)

        actual.size shouldBeEqualComparingTo 2

        actual[0] shouldContainExactly listOf(10, 4)
        actual[1] shouldContainExactly listOf(6, 2)
    }

    should("sum matrices") {
        val matrix = IntMatrix(
            listOf(
                listOf(3, 0, -3),
                listOf(2, -1, 8)
            )
        )

        val actual = matrix.sum(
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
            val matrix = IntMatrix(
                listOf(
                    listOf(3, 0, -3),
                    listOf(2, -1, 8),
                    listOf(2, -1, 8)
                )
            )

            matrix.sum(
                listOf(
                    listOf(1, 2, 3),
                    listOf(3, 1, -7)
                )
            )
        }

        exception.message should startWith("Dimension of matrices is not equivalent")
    }

    should("subtract matrices") {
        val matrix = IntMatrix(
            listOf(
                listOf(1, 2),
                listOf(2, 3)
            )
        )

        val actual = matrix.subtract(
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
            val matrix = IntMatrix(
                listOf(
                    listOf(3, 0, -3),
                    listOf(2, -1)
                )
            )

            matrix.subtract(
                listOf(
                    listOf(1, 2, 3),
                    listOf(3, 1, -7)
                )
            )
        }

        exception.message should startWith("Dimension of matrices is not equivalent")
    }

    should("detect zero matrix") {
        IntMatrix(
            listOf(
                listOf(0, 0, 0),
                listOf(0, 0, 0),
                listOf(0, 0, 0)
            )
        ).isZero() shouldBe true

        IntMatrix(
            listOf(
                listOf(0, 0, 0),
                listOf(0, 1, 0),
                listOf(0, 0, 0)
            )
        ).isZero() shouldBe false
    }

    should("create zero matrix") {
        val matrix = IntMatrix()
        val actual = matrix.zeroOf(3, 3)

        actual.size shouldBeEqualComparingTo 3

        actual[0] shouldContainExactly listOf(0, 0, 0)
        actual[1] shouldContainExactly listOf(0, 0, 0)
        actual[2] shouldContainExactly listOf(0, 0, 0)
    }
})
