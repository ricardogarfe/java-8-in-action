package org.ricardogarfe.java;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ReduceChapterTest {

    private static final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
    private ReduceChapter reduceChapter = new ReduceChapter();

    @Test
    public void testReduceListSum() {

        int productResult = reduceChapter.reduceListInitialValue(numbers, (a, b) -> a + b);
        int productIntegerResult = reduceChapter.reduceListInitialValue(numbers, Integer::sum);

        assertEquals("The sum is not correct", productResult, productIntegerResult);
    }

    @Test
    public void testReduceWithoutInitialValue() {

        Optional<Integer> productResult = reduceChapter.reduceListWithoutInitialValue(numbers, (a, b) -> a + b);
        Optional<Integer> productIntegerResult = reduceChapter.reduceListWithoutInitialValue(numbers, Integer::sum);

        assertEquals("The sum is not correct", productResult.isPresent(), productIntegerResult.isPresent());
    }

}
