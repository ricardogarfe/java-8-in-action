package org.ricardogarfe.java;

import org.junit.Assert;
import org.junit.Test;

import java.util.stream.Stream;

public class PythagoreanTripleTest {

    private PythagoreanTriple pythagoreanTriple = new PythagoreanTriple();

    @Test
    public void testCalculateTheorem() {

        Stream<int[]> pythagoreanTriples = pythagoreanTriple.calculateTheorem();

        pythagoreanTriples.limit(5)
                .forEach(t ->
                        System.out.println(t[0] + ", " + t[1] + ", " + t[2]));

        Assert.assertTrue(true);
    }
}
