package org.ricardogarfe.java;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit test for simple StringStreamsChapter.
 */
public class StringStreamsChapterTest {

  private StringStreamsChapter stringStreamsChapter = new StringStreamsChapter();

  @Test
  public void testInfiniteStream() throws Exception {

    stringStreamsChapter.infiniteStream();

    Assert.assertTrue(true);
  }

  @Test
  public void testStreamFromFile() throws Exception {

    String filePath = "src/test/resources/file.txt";
    long expectedWords = stringStreamsChapter.streamFromFile(filePath);

    Assert.assertTrue("There are no different words in file!", expectedWords != 0);
  }
}
