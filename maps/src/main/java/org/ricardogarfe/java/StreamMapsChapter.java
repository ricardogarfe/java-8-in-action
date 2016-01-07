package org.ricardogarfe.java;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamMapsChapter {

    public List<String> distinctChars (List<String> words) {

        return words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());
    }
}
