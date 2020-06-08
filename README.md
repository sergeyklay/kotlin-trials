# Trials

[![Build Status][actions-badge]][actions link]

My primary playground for doing algorithmic trials using Kotlin. Hence, the
name. Reading [Introduction to Algorithms][algo-book] nowadays and I put my
solutions for exercises given in the book in this tutorial. Some other utils
as well.

## Contents
- **Search**
  - [Binary Search][bin-search-impl] _O(log n)_
  - [Jump Search][jump-search-impl] _O(√n)_
  - [Linear Search][lin-search-impl] _O(n)_

## Run benchmarks

```shell script
$ ./gradlew --no-daemon clean jmh
```

## Run tests

```shell script
$ ./gradlew check
```

## License

This is free and unencumbered software released into the public domain.
For more see [LICENSE](./LICENSE) file.

[actions link]: https://github.com/sergeyklay/kotlin-trials/actions
[actions-badge]: https://github.com/sergeyklay/kotlin-trials/workflows/build/badge.svg
[algo-book]: https://www.amazon.com/Introduction-Algorithms-3rd-MIT-Press/dp/0262033844
[bin-search-impl]: https://github.com/sergeyklay/kotlin-trials/blob/master/src/main/kotlin/org/trials/search/BinarySearch.kt
[jump-search-impl]: https://github.com/sergeyklay/kotlin-trials/blob/master/src/main/kotlin/org/trials/search/JumpSearch.kt
[lin-search-impl]: https://github.com/sergeyklay/kotlin-trials/blob/master/src/main/kotlin/org/trials/search/LinearSearch.kt
