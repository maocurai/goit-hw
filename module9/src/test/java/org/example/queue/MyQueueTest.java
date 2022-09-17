package org.example.queue;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyQueueTest {

  @Test
  void addTest() {
    MyQueue<Integer> queue = new MyQueue<>();
    queue.add(1);
    Assertions.assertEquals(1, queue.poll());
  }

  @Test
  void pollTest() {
    MyQueue<Integer> queue = new MyQueue<>();
    IntStream.rangeClosed(0, 5).forEach(queue::add);
    IntStream.rangeClosed(0, 5)
        .forEach(x -> Assertions.assertEquals(x, queue.poll()));
  }

  @Test
  void sizeTest() {
    MyQueue<Integer> queue = new MyQueue<>();
    IntStream.rangeClosed(0, 5).forEach(queue::add);
    Assertions.assertEquals(6, queue.size());
  }

  @Test
  void sizeAfterClearTest() {
    MyQueue<Integer> queue = new MyQueue<>();
    IntStream.rangeClosed(0, 5).forEach(queue::add);
    queue.clear();
    Assertions.assertEquals(0, queue.size());
  }

  @Test
  void removeTest() {
    MyQueue<Integer> queue = new MyQueue<>();
    queue.add(0);
    queue.add(1);
    queue.remove(0);
    Assertions.assertEquals(1, queue.poll());
  }

  @Test
  void peekTest() {
    MyQueue<Integer> queue = new MyQueue<>();
    queue.add(0);
    Assertions.assertEquals(0, queue.peek());
  }

  @Test
  void poolAfterPeekTest() {
    MyQueue<Integer> queue = new MyQueue<>();
    queue.add(0);
    queue.peek();
    Assertions.assertEquals(0, queue.poll());
  }
}