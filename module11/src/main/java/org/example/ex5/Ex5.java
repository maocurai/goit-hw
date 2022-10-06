package org.example.ex5;

import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex5 {

  public static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
    Iterator<T> firstIterator = first.iterator();
    Iterator<T> secondIterator = second.iterator();
    return IntStream.iterate(0, x -> firstIterator.hasNext() && secondIterator.hasNext(), x -> ++x)
        .mapToObj(x -> x % 2 == 0 ? firstIterator.next() : secondIterator.next());
    }
}
