package org.example.ex3;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Ex3 {

  public static String sortAndToString(String [] arr) {
    return Arrays.stream(arr)
        .map(x -> x.split(",\\s++"))
        .flatMap(Arrays::stream)
        .sorted()
        .collect(Collectors.joining(", "));
  }

}
