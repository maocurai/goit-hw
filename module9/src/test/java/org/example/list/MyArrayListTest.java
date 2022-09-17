package org.example.list;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyArrayListTest {

  @Test
  void sizeTest() {
    MyArrayList<Integer> list = new MyArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(list::add);
    Assertions.assertEquals(5, list.size());
  }

  @Test
  void addElementsTest() {
    MyArrayList<Integer> list = new MyArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(list::add);
    IntStream.rangeClosed(1, 5).
        forEach(x -> Assertions.assertEquals(x, list.get(x-1)));
  }

  @Test
  void getElementByNotExistingIndexTest() {
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(1);
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
  }

  @Test
  void getElementByNegativeIndex() {
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(1);
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
  }

  @Test
  void removeFirstElementTest() {
    MyArrayList<Integer> list = new MyArrayList<>();
    list.add(1);
    list.remove(0);
    Assertions.assertEquals(0, list.size());
  }

  @Test
  void removeLastElementTest() {
    MyArrayList<Integer> list = new MyArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(list::add);
    list.remove(4);
    Assertions.assertEquals(4, list.size());
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(4));
  }

  @Test
  void removeMiddleElementTest() {
    MyArrayList<Integer> list = new MyArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(list::add);
    list.remove(2);
    Assertions.assertEquals(4, list.get(2));
  }

  @Test
  void removeAllElementsTest() {
    MyArrayList<Integer> list = new MyArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(list::add);
    IntStream.range(0, list.size()).forEach(x -> list.remove(0));
    Assertions.assertEquals(0, list.size());
  }

  @Test
  void removeElementByNonExistingIndexTest() {
    MyArrayList<Integer> list = new MyArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(list::add);
    Assertions.assertEquals(5, list.size());
    Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.remove(100));
  }

  @Test
  void removeReturnElementTest() {
    MyArrayList<Integer> list = new MyArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(list::add);
    Object actualRemoved = list.remove(4);
    Assertions.assertEquals(5, actualRemoved);
  }

  @Test
  void growingTest() {
    MyArrayList<Integer> list = new MyArrayList<>();
    Assertions.assertDoesNotThrow(() -> IntStream.rangeClosed(1, 100).forEach(list::add));
    Assertions.assertEquals(100, list.size());
  }


  @Test
  void equalListsByElementsEqualsTest() {
    MyArrayList<Integer> list1 = new MyArrayList<>();
    MyArrayList<Integer> list2 = new MyArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(x -> {
      list1.add(x);
      list2.add(x);
    });
    Assertions.assertTrue(list1.equals(list2) && list2.equals(list1));
  }

  @Test
  void notEqualListsByElementsEqualsTest() {
    MyArrayList<Integer> list1 = new MyArrayList<>();
    MyArrayList<Integer> list2 = new MyArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(list1::add);
    Assertions.assertFalse(list1.equals(list2) && list2.equals(list1));
  }

  @Test
  void equalListsByReferenceEqualsTest() {
    MyArrayList<Integer> list1 = new MyArrayList<>();
    MyArrayList<Integer> list2 = list1;
    Assertions.assertTrue(list1.equals(list2) && list2.equals(list1));
  }

  @Test
  void equalListsWithRemovedElementsEqualsTest() {
    MyArrayList<Integer> list1 = new MyArrayList<>();
    MyArrayList<Integer> list2 = new MyArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(list1::add);
    IntStream.rangeClosed(1, 100).forEach(list2::add);
    IntStream.range(list1.size(), list2.size()).forEach(x -> list2.remove(list1.size()));
    Assertions.assertTrue(list1.equals(list2) && list2.equals(list1));
  }

  @Test
  void equalObjectsHashCodeTest() {
    MyArrayList<Integer> list1 = new MyArrayList<>();
    MyArrayList<Integer> list2 = new MyArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(x -> {
      list1.add(x);
      list2.add(x);
    });
    Assertions.assertTrue(list1.hashCode() == list2.hashCode());
  }

  @Test
  void reflexiveEqualsTest() {
    MyArrayList<Integer> list = new MyArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(list::add);
    Assertions.assertTrue(list.equals(list));
  }

  @Test
  void transitiveEqualsTest() {
    MyArrayList<Integer> list1 = new MyArrayList<>();
    MyArrayList<Integer> list2 = new MyArrayList<>();
    MyArrayList<Integer> list3 = new MyArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(x -> {
      list1.add(x);
      list2.add(x);
      list3.add(x);
    });
    Assertions.assertTrue(list1.equals(list2) && list2.equals(list3)
        && list1.equals(list3));
  }

  @Test
  void nullEqualsTest() {
    MyArrayList<Integer> list = new MyArrayList<>();
    IntStream.rangeClosed(1, 5).forEach(list::add);
    Assertions.assertFalse(list.equals(null));
  }

}