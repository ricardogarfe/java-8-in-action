package org.ricardogarfe.java;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class StreamMapsChapterTest {

    private StreamMapsChapter streamMapsChapter = new StreamMapsChapter();

    @BeforeClass
    public static void setUpBeforeClass() {

    }

    @Test
    public void testDistinctChars() {

        List<String> words = Arrays.asList("Hello", "World");
        List<String> resultDistinctChars = streamMapsChapter.distinctChars(words);
        assertTrue("Error getting different chars from string List.", resultDistinctChars.size() == 7);
        resultDistinctChars.forEach(System.out::println);
    }

    @Test
    public void testRetrieveSquaredNumber() {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expectedSquared = Arrays.asList(1, 4, 9, 16, 25);

        List<Integer> squaredResult = streamMapsChapter.retrieveSquaredNumber(numbers);
        assertTrue("Different Squared result.", expectedSquared.equals(squaredResult));

    }

}
