package org.ricardogarfe.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * Unit test for simple StringStreamsChapter.
 */
public class StringStreamsChapterTest {

  private StringStreamsChapter stringStreamsChapter = new StringStreamsChapter();

  @Test
  public void testCreateStringStream() {

    stringStreamsChapter.createStringStream();

    Assert.assertTrue(true);
  }

  @Test
  public void testStreamFromFile() throws Exception {

    String filePath = "src/test/resources/file.txt";
    long expectedWords = stringStreamsChapter.streamFromFile(filePath);

    Assert.assertTrue("There are no different words in file!", expectedWords != 0);
  }

  @Test
  public void testInfiniteStream() {
    Stream.iterate(0, n -> n + 2)
        .limit(10)
        .forEach(System.out::println);
    Assert.assertTrue(true);
  }

  @Test
  public void testFibonacciTuples() {

    stringStreamsChapter.fibonacciTuples();
    Assert.assertTrue(true);
  }

  @Test
  public void testGenerateInfiniteStream() {
    Stream.generate(Math::random)
        .limit(5)
        .forEach(System.out::println);
  }

  @Test
  public void testFibonacciTuplesIntSupplier() {

    stringStreamsChapter.fibonacciTuplesIntSupplier();
    Assert.assertTrue(true);
  }

}
