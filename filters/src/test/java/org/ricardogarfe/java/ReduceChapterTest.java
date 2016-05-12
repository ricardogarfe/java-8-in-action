package org.ricardogarfe.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;

import static org.junit.Assert.assertEquals;

public class ReduceChapterTest {

  private ReduceChapter reduceChapter = new ReduceChapter();
  private static final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

  @Test
  public void testReduceListSum() throws Exception {

    int productResult = reduceChapter.reduceListInitialValue(numbers, (a, b) -> a + b);
    int productIntegerResult = reduceChapter.reduceListInitialValue(numbers, Integer::sum);;

    assertEquals("The sum is not correct", productResult, productIntegerResult);
  }

  @Test
  public void testReduceWithoutInitialValue() throws Exception {

    Optional<Integer> productResult = reduceChapter.reduceListWithoutInitialValue(numbers, (a, b) -> a + b);
    Optional<Integer> productIntegerResult = reduceChapter.reduceListWithoutInitialValue(numbers, Integer::sum);;

    assertEquals("The sum is not correct", productResult.isPresent(), productIntegerResult.isPresent());
  }

}
