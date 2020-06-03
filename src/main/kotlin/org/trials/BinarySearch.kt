package org.trials

class BinarySearch<T: Comparable<T>> {
    fun search(collection: Array<T>, target: T): Boolean {
        var low = 0
        var high = collection.size

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
