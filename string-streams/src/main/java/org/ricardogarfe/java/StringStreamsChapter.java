package org.ricardogarfe.java;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.function.IntSupplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringStreamsChapter {

  public void createStringStream() {
    Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
    stream.map(String::toUpperCase).forEach(System.out::println);
  }

  public long streamFromFile(String relativePath) throws Exception {

    long uniqueWords = 0;

    try (
        Stream<String> lines =
            Files.lines(Paths.get(relativePath), Charset.defaultCharset())) {
              uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
              .distinct()
              .count();
    } catch (IOException e) {
      throw new Exception("Error reading file from path.");
    }
    return uniqueWords;
  }

  public void fibonacciTuples() {
    Stream.iterate(new int[]{0,1},
        t -> new int[]{t[1], t[0] + t[1]})
        .limit(20)
        .map(t -> t[0])
        .forEach(System.out::println);
  }

  public void fibonacciTuplesIntSupplier() {

    IntSupplier fib = new IntSupplier(){
      private int previous = 0;
      private int current = 1;
      public int getAsInt(){
        int oldPrevious = this.previous;
        int nextValue = this.previous + this.current;
        this.previous = this.current;
        this.current = nextValue;
        return oldPrevious;
      }
    };

    IntStream.generate(fib).limit(10).forEach(System.out::println);
  }

}
