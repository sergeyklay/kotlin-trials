package org.trials.search

import kotlin.math.sqrt
import kotlin.math.min

/**
 * Jump search (also known as block search) is an algorithm for finding the
 * position of an element in a sorted array. Unlike linear search, it doesn't
 * compare each element of an array with the target value. Instead, to find a
 * value, the array is represented as a sequence of blocks.
 *
 * The time complexity is O(√n).
 */
class JumpSearch<T: Comparable<T>> {
    fun search(collection: Array<T>, target: T): Boolean {
        if (collection.isEmpty()) {
            return false
        }

        val step = sqrt(collection.size.toDouble()).toInt()
        var block = step
        var from = 0

        while (collection[min(block, collection.size) - 1] < target) {
            from = block
            block += step
            if (from >= collection.size) {
                return false
            }
        }

        val min = min(block, collection.size)
        while(collection[from] < target) {
            if (++from == min) {
                return false
            }
        }

        return  collection[from] == target
    }
}
