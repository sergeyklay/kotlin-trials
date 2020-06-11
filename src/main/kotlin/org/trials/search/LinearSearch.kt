package org.trials.search

/**
 * Linear search (or sequential search) is a simple algorithm for searching a
 * target value in arrays and lists. The algorithm checks each element of the
 * array until it finds an element that matches the target value.
 *
 * The time complexity is O(n).
 */
class LinearSearch<T> : SearchInterface<T> {
    override fun search(collection: Array<T>, target: T): Boolean {
        if (collection.isEmpty()) {
            return false
        }

        for (item: T in collection) {
            if (item == target) {
                return true
            }
        }

        return false
    }
}
