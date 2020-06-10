package org.trials.test

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.startWith
import org.trials.Matrix

class MatrixTest: ShouldSpec({
    val matrix = Matrix()

    should("not transpose empty matrices") {
        matrix.transpose(emptyList()).isEmpty() shouldBe true
    }

    should("transpose matrices") {
        val actual = matrix.transpose(
            listOf(
                listOf(1, 2),
                listOf(3, 4),
                listOf(5, 6)
            )
        )

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

        val actual = matrix.transpose(matrix.transpose(expected))
        actual shouldContainExactly expected
    }

    should("multiply matrices") {
        val actual = matrix.multiply(
            listOf(
                listOf(5, 2),
                listOf(3, 1)
            ),
            2
        )

        actual.size shouldBeEqualComparingTo 2

        actual[0] shouldContainExactly listOf(10, 4)
        actual[1] shouldContainExactly listOf(6, 2)
    }

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

    should("detect zero matrix") {
        matrix.isZero(
            listOf(
                listOf(0, 0, 0),
                listOf(0, 0, 0),
                listOf(0, 0, 0)
            )
        ) shouldBe true

        matrix.isZero(
            listOf(
                listOf(0, 0, 0),
                listOf(0, 1, 0),
                listOf(0, 0, 0)
            )
        ) shouldBe false
    }

    should("create zero matrix") {
        val actual = matrix.zeroOf(3, 3)

        actual.size shouldBeEqualComparingTo 3

        actual[0] shouldContainExactly listOf(0, 0, 0)
        actual[1] shouldContainExactly listOf(0, 0, 0)
        actual[2] shouldContainExactly listOf(0, 0, 0)
    }
})
