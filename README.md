# Trials

[![Build Status][actions-badge]][actions link]

For general purpose projects setup this repository contains some general
purpose code, keeping it for my understanding and also keeping a log for
what I've been learning.

As [Bruce Eckel][eckel] wrote in his book '[Thinking in Java][thinking-in-java]',
the satisfaction of re-writing a class is in getting things right. So I keep
practicing something now and then. This repository is primary a playground
for those trials. Hence, the name.

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
[eckel]: https://en.wikipedia.org/wiki/Bruce_Eckel
[thinking-in-java]: https://en.wikipedia.org/wiki/Thinking_in_Java
