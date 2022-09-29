package org.example.ex2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Ex2 {

  public static List<String> toUpperCaseAndSortedList(List<String> list) {
    return list.stream()
        .sorted(Comparator.reverseOrder())
        .map(String::toUpperCase)
        .collect(Collectors.toList());
  }

}
