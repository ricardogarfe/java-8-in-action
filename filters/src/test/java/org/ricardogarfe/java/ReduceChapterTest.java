package org.ricardogarfe.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReduceChapterTest {

  @Test
  public void testReduceListSum() throws Exception {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

    int productResult = numbers.stream().reduce(0, (a, b) -> a + b);
    int productIntegerResult = numbers.stream().reduce(0, Integer::sum);

    assertEquals("The sum is not correct", productResult, productIntegerResult);
  }
}
