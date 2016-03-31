package org.ricardogarfe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberBenchmarkStreams {

  private Predicate<Integer> evenNumber = (n -> n % 2 == 0);
  private final static int MAX_NUMBER_TESTS = 10;

  public List<NumberBenchmark> evenNumbers(List<Integer> numbers) {

    List<NumberBenchmark> numberBenchmarks = new ArrayList<>();

    for (int i = 0; i < MAX_NUMBER_TESTS; i++) {
      long start = System.currentTimeMillis();
      List<Integer> even = numbers
          .stream()
          .filter(evenNumber)
          .sorted()
          .collect(Collectors.toList());

      numberBenchmarks.add(
          new NumberBenchmark(
              even.size(), System.currentTimeMillis() - start, Thread.activeCount()
          ));
    }
    return numberBenchmarks;
  }

  public List<NumberBenchmark> evenParallelNumbers(List<Integer> numbers) {

    List<NumberBenchmark> numberBenchmarks = new ArrayList<>();

    for (int i = 0; i < MAX_NUMBER_TESTS; i++) {
      long start = System.currentTimeMillis();
      List<Integer> even = numbers
          .stream()
          .parallel()
          .filter(evenNumber)
          .sorted()
          .collect(Collectors.toList());

      numberBenchmarks.add(
          new NumberBenchmark(
              even.size(), System.currentTimeMillis() - start, Thread.activeCount()
          ));
    }
    return numberBenchmarks;
  }

  public List<NumberBenchmark> iterateEvenNumbers(List<Integer> numbers) {

    List<NumberBenchmark> numberBenchmarks = new ArrayList<>();

    for (int i = 0; i < MAX_NUMBER_TESTS; i++) {
      List<Integer> even = new ArrayList<>();
      long start = System.currentTimeMillis();
      for (Integer number : numbers) {
        if (number % 2 == 0) {
          even.add(number);
        }
      }

      Collections.sort(even, new Comparator<Integer>(){
        public int compare(Integer firstEven, Integer secondEven){
          return firstEven.compareTo(secondEven);
        }
      });

      numberBenchmarks.add(
          new NumberBenchmark(
              even.size(), System.currentTimeMillis() - start, Thread.activeCount()
          ));
    }
    return numberBenchmarks;

  }
}
