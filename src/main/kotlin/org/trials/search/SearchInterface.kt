package org.trials.search

/**
 * Interface for org.trials.search searchers.
 */
interface SearchInterface<T> {
    fun search(collection: Array<T>, target: T): Boolean
}
