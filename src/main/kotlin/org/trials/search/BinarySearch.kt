package org.trials.search

/**
 * Binary search is a fast algorithm for finding the position of an element in
 * a sorted array. The algorithm runs in work logarithmic time making O(log ⁡n)
 * comparisons, where n is the length of the input array.
 *
 * The time complexity is O(log n).
 */
class BinarySearch<T: Comparable<T>> {
    fun search(collection: Array<T>, target: T): Boolean {
        if (collection.isEmpty()) {
            return false
        }

        var low = 0
        var high = collection.size - 1

        while (low <= high) {
            val mid: Int = (low + high) / 2
            val rc = target.compareTo(collection[mid])

            when {
                rc < 0 -> {
                    high = mid - 1
                }
                rc > 0 -> {
                    low = mid + 1
                }
                else -> {
                    return true
                }
            }
        }

        return false
    }
}
