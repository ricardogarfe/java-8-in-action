package org.ricardogarfe.java;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PythagoreanTriple {

  public Stream<int[]> calculateTheorem() {

    Stream<int[]> pythagoreanTriples =
        IntStream.rangeClosed(1, 100).boxed()
            .flatMap(a -> IntStream.rangeClosed(a, 100)
                .filter(b -> Math.sqrt(a * a + b * b) % 1 == 0)
                .mapToObj(b ->
                    new int[]{a, b, (int) Math.sqrt(a * a + b * b)})
            );

    return pythagoreanTriples;
  }
}
