package org.ricardogarfe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class NumberBenchmarkStreamsTest {

  private NumberBenchmarkStreams numberBenchmarkStreams = new NumberBenchmarkStreams();

  private List<Integer> numbers;

  @Before
  public void setUp() {
    initializeStream();
  }

  @Test
  public void testSimpleEvenNumberStream() throws Exception {

    numberBenchmarkStreams.evenNumbers(numbers);
    Assert.assertTrue(true);
  }

  @Test
  public void testParallelEvenNumberStream() throws Exception {

    numberBenchmarkStreams.evenParallelNumbers(numbers);
    Assert.assertTrue(true);
  }

  private void initializeStream() {
    numbers = new ArrayList<>();
    for (int i = 0; i < 10_000_000; i++) {
      numbers.add((int) Math.round(Math.random() * 100));
    }
  }

}
