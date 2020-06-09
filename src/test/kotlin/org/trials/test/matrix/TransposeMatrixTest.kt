package org.trials.test.matrix

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.trials.matrix.TransposeMatrix

class TransposeMatrixTest {
    @Test
    fun shouldTransposeEmptyMatrixOfInts() {
        val matrix = TransposeMatrix()

        assertEquals(emptyList<Int>(), matrix.transposeInts(emptyList()))
    }

    @Test
    fun shouldTransposeMatrixOfInts() {
        val matrix = TransposeMatrix()
        val actual = matrix.transposeInts(
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
    fun shouldTransposeTransposedMatrixOfInts() {
        val matrix = TransposeMatrix()
        val actual = matrix.transposeInts(
            matrix.transposeInts(
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
}
