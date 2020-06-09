package org.trials.test.search

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.trials.search.LinearSearch

class LinearSearchTest {
    @Test
    fun `should find element`() {
        val searcher: LinearSearch<Int> = LinearSearch()
        val collection = (1..100).toList().toTypedArray()

        assertTrue(searcher.search(collection, 1))
        assertTrue(searcher.search(collection, 7))
        assertTrue(searcher.search(collection, 42))
        assertTrue(searcher.search(collection, 100))
    }

    @Test
    fun `should not find element in empty array`() {
        val searcher: LinearSearch<Int> = LinearSearch()
        val collection = arrayOf<Int>()

        assertFalse(searcher.search(collection, 0))
        assertFalse(searcher.search(collection, 100))
    }

    @Test
    fun `should not find element`() {
        val searcher: LinearSearch<Int> = LinearSearch()
        val collection = (1..100).toList().toTypedArray()

        assertFalse(searcher.search(collection, 0))
        assertFalse(searcher.search(collection, 300))
        assertFalse(searcher.search(collection, -10000))
    }
}
