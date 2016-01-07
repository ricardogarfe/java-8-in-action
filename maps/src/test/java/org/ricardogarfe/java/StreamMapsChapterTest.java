package org.ricardogarfe.java;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StreamMapsChapterTest {

    private StreamMapsChapter streamMapsChapter = new StreamMapsChapter();

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {

    }

    @Test
    public void testDistinctChars() throws Exception {

        List<String> words = Arrays.asList("Hello", "World");

        List<String> resultDistinctChars = streamMapsChapter.distinctChars(words);
        assertTrue("Error getting different chars from string List.", resultDistinctChars.size() == 7);

    }

}
