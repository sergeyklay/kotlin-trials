package org.trials

class SequentialSearch<T> {
    fun search(collection: Array<T>, t: T): Boolean {
        for (item: T in collection) {
            if (item == t) {
                return true
            }
        }

        return false
    }

    fun search(collection: Iterable<T>, t: T): Boolean {
        val iter: Iterator<T> = collection.iterator()

        while (iter.hasNext()) {
            if (iter.next() == t) {
                return true
            }
        }

        return false
    }
}
