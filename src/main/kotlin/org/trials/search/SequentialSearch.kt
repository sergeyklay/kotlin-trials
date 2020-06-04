package org.trials.search

class SequentialSearch<T> {
    fun search(collection: Array<T>, t: T): Boolean {
        for (item: T in collection) {
            if (item == t) {
                return true
            }
        }

        return false
    }
}
