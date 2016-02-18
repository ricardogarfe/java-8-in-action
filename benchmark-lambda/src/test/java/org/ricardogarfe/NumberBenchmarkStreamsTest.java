package org.ricardogarfe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;

public class NumberBenchmarkStreamsTest {

  private final static String LOG_TEMPLATE = "%d elements computed with %nAverage time:\t%5.0f msecs %nMax:\t%d %nMin:\t%d";

  private NumberBenchmarkStreams numberBenchmarkStreams = new NumberBenchmarkStreams();

  private List<Integer> numbers;

  @Before
  public void setUp() {
    initializeStream();
  }

  @Test
  public void testSimpleEvenNumberStream() throws Exception {

    List<NumberBenchmark> numberBenchmarks = numberBenchmarkStreams.evenNumbers(numbers);
    LongSummaryStatistics longSummaryStatistics = numberBenchmarks.stream().mapToLong(NumberBenchmark::getElapsedTime).summaryStatistics();

    System.out.printf(LOG_TEMPLATE,
        longSummaryStatistics.getCount(),
        longSummaryStatistics.getAverage(),
        longSummaryStatistics.getMax(),
        longSummaryStatistics.getMin()
    );

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
