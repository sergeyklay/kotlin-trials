import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.trials.SequentialSearch

class SequentialSearchTest {
    @Test
    fun shouldFindElement() {
        val searcher: SequentialSearch<Int> = SequentialSearch()
        val collection = (1..100).toList().toTypedArray()

        assertTrue(searcher.search(collection, 1))
        assertTrue(searcher.search(collection, 7))
        assertTrue(searcher.search(collection, 42))
        assertTrue(searcher.search(collection, 100))
        assertFalse(searcher.search(collection, 300))
    }
}
