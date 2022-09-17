package org.example.stack;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyStackTest {

  @Test
  void pushPopTest() {
    MyStack<Integer> stack = new MyStack<>();
    IntStream.rangeClosed(0, 5).forEach(stack::push);
    IntStream.iterate(5, x -> x >= 0, x -> --x)
        .forEach(x -> Assertions.assertEquals(x, stack.pop()));
  }

  @Test
  void pushSizeTest() {
    MyStack<Integer> stack = new MyStack<>();
    IntStream.rangeClosed(0, 5).forEach(stack::push);
    Assertions.assertEquals(6, stack.size());
  }

  @Test
  void removeReturnTypeTest() {
    MyStack<Integer> stack = new MyStack<>();
    IntStream.rangeClosed(0, 5).forEach(stack::push);
    Assertions.assertEquals(0, stack.remove(0));
  }

  @Test
  void sizeAfterRemoveTest() {
    MyStack<Integer> stack = new MyStack<>();
    IntStream.rangeClosed(0, 5).forEach(stack::push);
    stack.remove(0);
    Assertions.assertEquals(5, stack.size());
  }

  @Test
  void sizeAfterRemovingAllElementsTest() {
    MyStack<Integer> stack = new MyStack<>();
    IntStream.rangeClosed(0, 5).forEach(stack::push);
    IntStream.iterate(5, x -> x >= 0, x -> --x)
        .forEach(stack::remove);
    Assertions.assertEquals(0, stack.size());

  }

  @Test
  void sizeAfterClearTest() {
    MyStack<Integer> stack = new MyStack<>();
    IntStream.rangeClosed(0, 5).forEach(stack::push);
    stack.clear();
    Assertions.assertEquals(0, stack.size());
  }

  @Test
  void sizeAfterPoppingAllElementsTest() {
    MyStack<Integer> stack = new MyStack<>();
    IntStream.rangeClosed(0, 5).forEach(stack::push);
    IntStream.rangeClosed(0, 5).forEach(x -> stack.pop());
    Assertions.assertEquals(0, stack.size());
  }

  @Test
  void peekTest() {
    MyStack<Integer> stack = new MyStack<>();
    stack.push(0);
    Assertions.assertEquals(0, stack.peek());
  }

  @Test
  void popAfterPeekTest() {
    MyStack<Integer> stack = new MyStack<>();
    stack.push(0);
    stack.peek();
    Assertions.assertEquals(0, stack.pop());
  }

  @Test
  void peekFromEmptyStackTest() {
    MyStack<Integer> stack = new MyStack<>();
    stack.push(0);
    stack.pop();
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> stack.peek());
  }

  @Test
  void popFromEmptyStackTest() {
    MyStack<Integer> stack = new MyStack<>();
    IntStream.rangeClosed(0, 5).forEach(stack::push);
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
      IntStream.rangeClosed(0, 6).forEach(x -> stack.pop());
    });
  }

  @Test
  void growingTest() {
    MyStack<Integer> stack = new MyStack<>();
    IntStream.rangeClosed(0, 99).forEach(stack::push);
    Assertions.assertEquals(100, stack.size());
  }
}