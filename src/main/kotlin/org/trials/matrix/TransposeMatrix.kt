package org.trials.matrix

class TransposeMatrix {
    fun transposeInts(collection: List<List<Int>>): List<List<Int>> {
        if (collection.isEmpty() || collection[0].isEmpty()) {
            return emptyList()
        }

        val response = MutableList(collection[0].size) {
            MutableList(collection.size) { 0 }
        }

        for (r in collection.indices) for (c in collection[0].indices) {
            response[c][r] = collection[r][c]
        }

        return response
    }
}
