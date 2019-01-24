package org.ricardogarfe.java;

import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

public class ReduceChapter {

  public Integer reduceListInitialValue(List<Integer> numbers, BinaryOperator<Integer> binaryOperator) {
    return numbers.stream().reduce(0, binaryOperator);
  }

  public Optional<Integer> reduceListWithoutInitialValue(List<Integer> numbers, BinaryOperator<Integer> binaryOperator) {
    System.out.println("reduceListWithoutInitialValue");
    return numbers.stream().reduce(binaryOperator);
  }
}
