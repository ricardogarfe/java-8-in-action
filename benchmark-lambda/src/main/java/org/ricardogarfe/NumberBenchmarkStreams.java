package org.ricardogarfe;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberBenchmarkStreams {

  private Predicate<Integer> evenNumber = (n -> n % 2 == 0);
  private final static int MAX_NUMBER_TESTS = 10;
  private final static String LOG_TEMPLATE = "%d elements computed in %5d msecs with %d threads\n";

  public List<NumberBenchmark> evenNumbers(List<Integer> numbers) {

    System.out.printf("Simple even Stream.\n");

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

  public void evenParallelNumbers(List<Integer> numbers) {

    System.out.printf("Simple even Stream.\n");

    for (int i = 0; i < MAX_NUMBER_TESTS; i++) {
      long start = System.currentTimeMillis();
      List<Integer> even = numbers
          .stream()
          .parallel()
          .filter(evenNumber)
          .sorted()
          .collect(Collectors.toList());

      System.out.printf(
          "%d elements computed in %5d msecs with %d threads\n",
          even.size(), System.currentTimeMillis() - start,
          Thread.activeCount());
    }
  }
}
