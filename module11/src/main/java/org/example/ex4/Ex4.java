package org.example.ex4;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Ex4 {

  public static Stream<Long> getInfiniteStream(int seed, int a, int c, int m) {
     return LongStream.iterate(seed, x -> (a * x + c) % m).boxed();
  }
}
