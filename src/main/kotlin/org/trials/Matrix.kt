package org.trials

/**
 * A matrix is a rectangular arrangement of numbers into rows and columns.
 * When we work with matrices, we refer to real numbers as scalars.
 */
class Matrix {
    /**
     * Transpose of a matrix is an operator which flips a matrix over its diagonal,
     * that is it switches the row and column indices of the matrix A by producing
     * another matrix denoted as A(t).
     */
    fun transpose(collection: List<List<Int>>): List<List<Int>> {
        if (collection.isEmpty()) {
            return collection
        }

        val response = MutableList(collection[0].size) {
            MutableList(collection.size) { 0 }
        }

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
     * Asserts that matrices have the same dimension.
     */
    private fun assertSameDimension(c1: List<List<Int>>, c2: List<List<Int>>) {
        if (c1.map { it.size } != c2.map { it.size }) {
            throw RuntimeException("Dimension of matrices is not equivalent")
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
     * A zero matrix is a matrix in which every element is zero.
     */
    fun isZero(collection: List<List<Int>>): Boolean {
        return collection.isNotEmpty() && !collection.any { c ->
            c.filterNot { it == 0 }.isNotEmpty()
        }
    }
}
