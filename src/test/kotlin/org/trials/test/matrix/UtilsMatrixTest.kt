package org.trials.test.matrix

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.shouldBe
import org.trials.IntMatrix

class UtilsMatrixTest: ShouldSpec({
    val matrix = IntMatrix()

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
