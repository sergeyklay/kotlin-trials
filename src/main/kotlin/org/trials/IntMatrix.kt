package org.trials

/**
 * A matrix is a rectangular arrangement of numbers into rows and columns.
 * When we work with matrices, we refer to real numbers as scalars.
 */
class IntMatrix() {
    /**
     * Transpose of a matrix is an operator which flips a matrix over its diagonal,
     * that is it switches the row and column indices of the matrix A by producing
     * another matrix denoted as A(t).
     */
    fun transpose(collection: List<List<Int>>): List<List<Int>> {
        if (collection.isEmpty()) {
            return collection
        }

        val response = zeroOf(collection[0].size, collection.size)

        for (r in collection.indices) for (c in collection[0].indices) {
            response[c][r] = collection[r][c]
        }

        return response
    }

    /**
     * Scalar multiplication.
     * Each entry in the matrix is multiplied by the given scalar.
     */
    fun multiply(collection: List<List<Int>>, scalar: Int): List<List<Int>> {
        return collection.map {
            it.map { int -> int * scalar }
        }
    }

    /**
     * Sum of matrices.
     * Note: matrices must be the same dimension (or size).
     */
    fun sum(c1: List<List<Int>>, c2: List<List<Int>>): List<List<Int>> {
        assertSameDimension(c1, c2)

        return c1.mapIndexed { row, collection ->
            collection.mapIndexed { col, value ->
                value + c2[row][col]
            }
        }
    }

    /**
     * Subtract two matrices.
     * Note: matrices must be the same dimension (or size).
     */
    fun subtract(c1: List<List<Int>>, c2: List<List<Int>>): List<List<Int>> {
        assertSameDimension(c1, c2)

        return c1.mapIndexed { row, collection ->
            collection.mapIndexed { col, value ->
                value - c2[row][col]
            }
        }
    }

    /**
     * Verifies that the matrix is zero.
     * A zero matrix is a matrix in which every element is zero.
     */
    fun isZero(collection: List<List<Int>>): Boolean {
        return collection.isNotEmpty() && !collection.any { c ->
            c.filterNot { it == 0 }.isNotEmpty()
        }
    }

    /**
     * Create a zero matrix.
     * A zero matrix is a matrix in which every element is zero.
     */
    fun zeroOf(rows: Int, cols: Int): MutableList<MutableList<Int>> {
        return MutableList(rows) {
            MutableList(cols) { 0 }
        }
    }

    /**
     * Asserts that matrices have the same dimension.
     */
    private fun assertSameDimension(c1: List<List<Int>>, c2: List<List<Int>>) {
        if (c1.map { it.size } != c2.map { it.size }) {
            throw RuntimeException("Dimension of matrices is not equivalent")
        }
    }
}
