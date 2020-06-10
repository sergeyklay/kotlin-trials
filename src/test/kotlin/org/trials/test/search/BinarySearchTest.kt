package org.trials.test.search

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.shouldBe
import org.trials.search.BinarySearch

class BinarySearchTest : ShouldSpec({
    val searcher: BinarySearch<Int> = BinarySearch()
    val collection = (1..100).toList().toTypedArray()

    should("find element in the collection") {
        searcher.search(collection, 1) shouldBe true
        searcher.search(collection, 7) shouldBe true
        searcher.search(collection, 42) shouldBe true
        searcher.search(collection, 100) shouldBe true
    }

    should("no find elements in an empty collection") {
        val emptyCollection = arrayOf<Int>()

        searcher.search(emptyCollection, 0) shouldBe false
        searcher.search(emptyCollection, 100) shouldBe false
        searcher.search(emptyCollection, -100) shouldBe false
    }

    should("should not find an element in the collection if it isn't there") {
        searcher.search(collection, 0) shouldBe false
        searcher.search(collection, 300) shouldBe false
        searcher.search(collection, -10000) shouldBe false
    }
})
