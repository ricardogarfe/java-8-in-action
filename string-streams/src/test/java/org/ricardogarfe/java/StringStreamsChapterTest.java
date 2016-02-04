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

}
