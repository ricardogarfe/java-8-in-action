package org.ricardogarfe.java;

import java.util.stream.Stream;

public class StringStreamsChapter {

  public void infiniteStream() {
    Stream<String> stream = Stream.of("Java 8 ", "Lambdas ", "In ", "Action");
    stream.map(String::toUpperCase).forEach(System.out::println);
  }
}
