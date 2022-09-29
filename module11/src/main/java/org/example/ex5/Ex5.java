package org.example.ex5;

import java.util.stream.Stream;

public class Ex5 {

  public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
    return Stream.concat(first, second).limit(Math.min(first.count(), second.count()));
  }

}
