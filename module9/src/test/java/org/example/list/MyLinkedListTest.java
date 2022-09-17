package org.example.list;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyLinkedListTest {

  @Test
  void addTest() {
    MyLinkedList<Integer> list = new MyLinkedList<>();
    list.add(1);
    Assertions.assertEquals(1, list.get(0));
    Assertions.assertEquals(1, list.size());
  }

  @Test
  void getTest() {
    MyLinkedList<Integer> list = new MyLinkedList<>();
    IntStream.rangeClosed(0, 3).forEach(list::add);
    Assertions.assertEquals(0, list.get(0));
    Assertions.assertEquals(1, list.get(1));
    Assertions.assertEquals(2, list.get(2));
    Assertions.assertEquals(3, list.get(3));
  }

  @Test
  void negativeIndexGetTest() {
    MyLinkedList<Integer> list = new MyLinkedList<>();
    IntStream.rangeClosed(0, 3).forEach(list::add);
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
  }

  @Test
  void outOfBoundsIndexGetTest() {
    MyLinkedList<Integer> list = new MyLinkedList<>();
    IntStream.rangeClosed(0, 3).forEach(list::add);
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(10));
  }

  @Test
  void removeTest() {
    MyLinkedList<Integer> list = new MyLinkedList<>();
    IntStream.rangeClosed(0, 3).forEach(list::add);
    IntStream.rangeClosed(0, 2).forEach(x -> list.remove(0));
    Assertions.assertEquals(1, list.size());
    Assertions.assertEquals(3, list.get(0));
  }

  @Test
  void size() {
    MyLinkedList<Integer> list = new MyLinkedList<>();
    IntStream.rangeClosed(0, 3).forEach(list::add);
    Assertions.assertEquals(4, list.size());
  }

  @Test
  void allElementsRemovedSizeTest() {
    MyLinkedList<Integer> list = new MyLinkedList<>();
    IntStream.rangeClosed(0, 3).forEach(list::add);
    IntStream.rangeClosed(0, 3).forEach(x -> list.remove(0));
    Assertions.assertEquals(0, list.size());
  }

  @Test
  void clear() {
    MyLinkedList<Integer> list = new MyLinkedList<>();
    IntStream.rangeClosed(0, 3).forEach(list::add);
    list.clear();
    Assertions.assertEquals(0, list.size());
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
  }
}