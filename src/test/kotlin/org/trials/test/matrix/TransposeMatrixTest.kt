package org.trials.test.matrix

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.shouldBe
import org.trials.IntMatrix

class TransposeMatrixTest: ShouldSpec({
    val matrix = IntMatrix()

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

        matrix.transpose(matrix.transpose(expected)) shouldContainExactly expected
    }
})
