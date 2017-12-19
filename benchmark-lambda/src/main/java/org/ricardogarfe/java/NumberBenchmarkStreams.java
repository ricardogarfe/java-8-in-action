package org.ricardogarfe.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberBenchmarkStreams {

    private static final Predicate<Integer> evenNumber = (n -> n % 2 == 0);
    private static final int MAX_NUMBER_TESTS = 10;

    public List<NumberBenchmark> evenNumbers(final List<Integer> numbers) {

        List<NumberBenchmark> numberBenchmarks = new ArrayList<>();
        List<Integer> even;

        for (int i = 0; i < MAX_NUMBER_TESTS; i++) {
            long start = System.currentTimeMillis();
            even = numbers
                    .stream()
                    .filter(evenNumber)
                    .sorted()
                    .collect(Collectors.toList());

            numberBenchmarks.add(
                    NumberBenchmark.createNumberBenchmark(
                            even.size(), System.currentTimeMillis() - start, Thread.activeCount()
                    ));
        }
        return numberBenchmarks;
    }

    public List<NumberBenchmark> evenParallelNumbers(List<Integer> numbers) {

        List<NumberBenchmark> numberBenchmarks = new ArrayList<>();
        List<Integer> even;

        for (int i = 0; i < MAX_NUMBER_TESTS; i++) {
            long start = System.currentTimeMillis();
            even = numbers
                    .stream()
                    .parallel()
                    .filter(evenNumber)
                    .sorted()
                    .collect(Collectors.toList());

            numberBenchmarks.add(
                    NumberBenchmark.createNumberBenchmark(
                            even.size(), System.currentTimeMillis() - start, Thread.activeCount()
                    ));
        }
        return numberBenchmarks;
    }

    public List<NumberBenchmark> iterateEvenNumbers(List<Integer> numbers) {

        List<NumberBenchmark> numberBenchmarks = new ArrayList<>();
        List<Integer> even;

        for (int i = 0; i < MAX_NUMBER_TESTS; i++) {
            even = new ArrayList<>();
            long start = System.currentTimeMillis();
            for (Integer number : numbers) {
                if (number % 2 == 0) {
                    even.add(number);
                }
            }

            Collections.sort(even, new Comparator<Integer>() {
                public int compare(Integer firstEven, Integer secondEven) {
                    return firstEven.compareTo(secondEven);
                }
            });

            numberBenchmarks.add(
                    NumberBenchmark.createNumberBenchmark(
                            even.size(), System.currentTimeMillis() - start, Thread.activeCount()
                    ));
        }
        return numberBenchmarks;

    }
}
