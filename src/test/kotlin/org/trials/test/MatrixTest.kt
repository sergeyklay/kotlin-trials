package org.trials.test

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.should
import io.kotest.matchers.string.startWith
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.trials.Matrix

class MatrixTest {
    @Test
    fun `should not transpose empty matrices`() {
        val matrix = Matrix()

        assertTrue(matrix.transpose(emptyList()).isEmpty())
    }

    @Test
    fun `should transpose matrices`() {
        val matrix = Matrix()
        val actual = matrix.transpose(
            listOf(
                listOf(1, 2),
                listOf(3, 4),
                listOf(5, 6)
            )
        )

        assertEquals(2, actual.size)

        assertEquals(listOf(1, 3, 5), actual[0])
        assertEquals(listOf(2, 4, 6), actual[1])
    }

    @Test
    fun `transpose matrix twice will return it to the initial state`() {
        val matrix = Matrix()
        val actual = matrix.transpose(
            matrix.transpose(
                listOf(
                    listOf(1, 2),
                    listOf(3, 4),
                    listOf(5, 6)
                )
            )
        )

        assertEquals(3, actual.size)

        assertEquals(listOf(1, 2), actual[0])
        assertEquals(listOf(3, 4), actual[1])
        assertEquals(listOf(5, 6), actual[2])
    }

    @Test
    fun `should multiply matrices`() {
        val matrix = Matrix()
        val actual = matrix.multiply(
            listOf(
                listOf(5, 2),
                listOf(3, 1)
            ),
            2
        )

        assertEquals(2, actual.size)

        assertEquals(listOf(10, 4), actual[0])
        assertEquals(listOf(6, 2), actual[1])
    }

    @Test
    fun `should sum matrices`() {
        val matrix = Matrix()
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

        assertEquals(2, actual.size)

        assertEquals(listOf(4, 2, 0), actual[0])
        assertEquals(listOf(5, 0, 1), actual[1])
    }

    @Test
    fun `calling sum on matrices with not the same dimension will throw an exception`() {
        val matrix = Matrix()
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

    @Test
    fun `should subtract matrices`() {
        val matrix = Matrix()
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

        assertEquals(2, actual.size)

        assertEquals(listOf(3, 2), actual[0])
        assertEquals(listOf(0, -2), actual[1])
    }

    @Test
    fun `calling subtract on matrices with not the same dimension will throw an exception`() {
        val matrix = Matrix()
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

    @Test
    fun `should detect zero matrix`() {
        val matrix = Matrix()

        assertTrue(
            matrix.isZero(
                listOf(
                    listOf(0, 0, 0),
                    listOf(0, 0, 0),
                    listOf(0, 0, 0)
                )
            )
        )

        assertFalse(
            matrix.isZero(
                listOf(
                    listOf(0, 0, 0),
                    listOf(0, 1, 0),
                    listOf(0, 0, 0)
                )
            )
        )
    }
}
