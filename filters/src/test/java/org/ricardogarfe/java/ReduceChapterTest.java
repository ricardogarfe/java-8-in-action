package org.ricardogarfe.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ReduceChapterTest {

  private static final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

  @Test
  public void testReduceListSum() throws Exception {

    int productResult = numbers.stream().reduce(0, (a, b) -> a + b);
    int productIntegerResult = numbers.stream().reduce(0, Integer::sum);

    assertEquals("The sum is not correct", productResult, productIntegerResult);
  }

  @Test
  public void testReduceWithoutInitialValue() throws Exception {

    Optional<Integer> productResult = numbers.stream().reduce((a, b) -> a + b);
    Optional<Integer> productIntegerResult = numbers.stream().reduce(Integer::sum);

    assertEquals("The sum is not correct", productResult.isPresent(), productIntegerResult.isPresent());
  }

}
