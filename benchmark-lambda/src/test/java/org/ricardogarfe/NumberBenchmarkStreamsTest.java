package org.ricardogarfe;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;

public class NumberBenchmarkStreamsTest {

  private final static String LOG_TEMPLATE = "%s Statics:\t %d even elements computed %d times %n* Average time:\t%5.0f msecs %n* Max time:\t%d %n* Min time:\t%d";
  public static final int TEST_SIZE = 10_000_000;

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
        "Simple",
        TEST_SIZE,
        longSummaryStatistics.getCount(),
        longSummaryStatistics.getAverage(),
        longSummaryStatistics.getMax(),
        longSummaryStatistics.getMin()
    );

    Assert.assertTrue(true);
  }

  @Test
  public void testParallelEvenNumberStream() throws Exception {

    List<NumberBenchmark> numberBenchmarks = numberBenchmarkStreams.evenParallelNumbers(numbers);
    LongSummaryStatistics longSummaryStatistics = numberBenchmarks.stream().mapToLong(NumberBenchmark::getElapsedTime).summaryStatistics();

    System.out.printf(LOG_TEMPLATE,
        "Parallel",
        TEST_SIZE,
        longSummaryStatistics.getCount(),
        longSummaryStatistics.getAverage(),
        longSummaryStatistics.getMax(),
        longSummaryStatistics.getMin()
    );

    Assert.assertTrue(true);
  }

  private void initializeStream() {
    numbers = new ArrayList<>();
    for (int i = 0; i < TEST_SIZE; i++) {
      numbers.add((int) Math.round(Math.random() * 100));
    }
  }

}
