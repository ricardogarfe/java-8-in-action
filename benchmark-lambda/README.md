# Foreach benchmark

Results:

```shell
    ForEach Method
    Person Age: 3
    Person Age: 5
    Person Age: 7
    Person Age: 9
    ForEach time:   0.001
     Start: 1445943238433
     End:   1445943238434

Lambda Method
    Person Age: 3
    Person Age: 5
    Person Age: 7
    Person Age: 9
    Lambda ForEach time:    0.055
     Start: 1445943238436
     End:   1445943238491
```

# For benchmark

Benchmark extracting even numbers from 10000000 registers.

Results:
```shell
Simple Statics:	 10000000 even elements computed 10 times 
* Average time:	 1749 msecs 
* Max time:	6781 
* Min time:	817

Parallel Statics:	 10000000 even elements computed 10 times 
* Average time:	  791 msecs 
* Max time:	3517 
* Min time:	446
```

Tests in [NumberBenchmarkStreamsTest](src/test/org/ricardogarfe/NumberBenchmarkStreamsTest) class.

## Documentation

Code samples from:
* [Java API](https://docs.oracle.com/javase/8/docs/api/overview-summary.html "Java™ Platform, Standard Edition 8 API Specification")
* [ZeroTurnAround](http://zeroturnaround.com/rebellabs/java-8-explained-applying-lambdas-to-java-collections/ "Java 8 Explained: Using Filters, Maps, Streams and Foreach to apply Lambdas to Java Collections!")
* [JavaWorld](http://www.javaworld.com/article/2461744/java-language/java-language-iterating-over-collections-in-java-8.html "Iterating over collections in Java 8")
