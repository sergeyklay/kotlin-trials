package org.trials.test.matrix

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith
import org.trials.IntMatrix

class ProductMatrixTest : ShouldSpec({
    val matrix = IntMatrix()

    should("product matrices") {
        val actual = matrix.product(
            listOf(
                listOf(2, 4, 6),
                listOf(1, 3, 5)
            ),
            listOf(
                listOf(1, 2),
                listOf(3, 4),
                listOf(5, 6)
            )
        )

        actual.size shouldBeEqualComparingTo 2

        actual[0] shouldContainExactly listOf(44, 56)
        actual[1] shouldContainExactly listOf(35, 44)
    }

    should("get zero matrix by product of the matrix by the zero matrix") {
        val actual = matrix.product(
            listOf(
                listOf(0, 0, 0),
                listOf(0, 0, 0)
            ),
            listOf(
                listOf(1, 2),
                listOf(3, 4),
                listOf(5, 6)
            )
        )

        actual.size shouldBeEqualComparingTo 2

        actual[0] shouldContainExactly listOf(0, 0)
        actual[1] shouldContainExactly listOf(0, 0)
    }

    should("product two vectors") {
        val actual = matrix.product(
            listOf(
                listOf(4),
                listOf(5),
                listOf(6)
            ),
            listOf(
                listOf(1, 2, 3)
            )
        )

        actual.size shouldBeEqualComparingTo 3

        actual[0] shouldContainExactly listOf(4, 8, 12)
        actual[1] shouldContainExactly listOf(5, 10, 15)
        actual[2] shouldContainExactly listOf(6, 12, 18)
    }

    should("throw an exception when calling product on empty matrices") {
        val exception1 = shouldThrow<RuntimeException> {
            matrix.product(
                listOf(
                    listOf(3, 0, -3),
                    listOf(2, -1)
                ),
                emptyList()
            )
        }

        exception1.message should startWith("To perform a dot product both matrices should not be empty")

        val exception2 = shouldThrow<RuntimeException> {
            matrix.product(
                emptyList(),
                listOf(
                    listOf(3, 0, -3),
                    listOf(2, -1)
                )
            )
        }

        exception2.message should startWith("To perform a dot product both matrices should not be empty")
    }

    should("throw an exception when calling product on matrices with invalid dimension") {
        val exception = shouldThrow<RuntimeException> {
            matrix.product(
                listOf(
                    listOf(3, 0, -3),
                    listOf(2, -1)
                ),
                listOf(
                    listOf(3, 0, -3),
                    listOf(2, -1)
                )
            )
        }

        exception.message should startWith(
            "The number of columns of the 1st matrix must be equal to the number of rows of the 2nd matrix"
        )
    }
})
