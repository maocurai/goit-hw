package org.example.ex1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ex1 {

  public static String oddPositionNamesToString(List<String> names) {
    return IntStream.range(0, names.size())
        .filter(x -> x % 2 == 1)
        .mapToObj(x -> x + ". " + names.get(x))
        .collect(Collectors.joining(", "));
  }

}
