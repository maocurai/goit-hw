package org.example.map;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MyHashMapTest {

  @Test
  void putTest() {
    MyHashMap<Integer, String> map = new MyHashMap();
    IntStream.rangeClosed(0, 3).forEach(x -> map.put(x, String.valueOf(x)));
    IntStream.rangeClosed(0, 3)
        .forEach(x -> Assertions.assertEquals(String.valueOf(x), map.get(x)));
  }

  @Test
  void putRepeatingKeyTest() {
    MyHashMap<Integer, String> map = new MyHashMap();
    map.put(1, "Hello");
    map.put(1, "Bye");
    Assertions.assertEquals("Bye", map.get(1));
  }

  @Test
  void repeatingKeySizeTest() {
    MyHashMap<Integer, String> map = new MyHashMap();
    map.put(1, "Hello");
    map.put(1, "Bye");
    Assertions.assertEquals(1, map.size());
  }

  @Test
  void removePairsSizeTest() {
    MyHashMap<Integer, String> map = new MyHashMap();
    IntStream.rangeClosed(0, 3).forEach(x -> map.put(x, String.valueOf(x)));
    IntStream.rangeClosed(0, 3).forEach(x -> map.remove(x));
    Assertions.assertEquals(0, map.size());
  }

  @Test
  void removeTest() {
    MyHashMap<Integer, String> map = new MyHashMap();
    IntStream.rangeClosed(0, 3).forEach(x -> map.put(x, String.valueOf(x)));
    IntStream.rangeClosed(0, 3).forEach(x -> map.remove(x));
    IntStream.rangeClosed(0, 3).forEach(x -> Assertions.assertNull(map.get(x)));
  }

  @Test
  void removeReturnValueTest() {
    MyHashMap<Integer, String> map = new MyHashMap();
    IntStream.rangeClosed(0, 3).forEach(x -> map.put(x, String.valueOf(x)));
    IntStream.rangeClosed(0, 3)
        .forEach(x -> Assertions.assertEquals(String.valueOf(x), map.remove(x)));
  }

  @Test
  void removePairByNotExistingKeyTest() {
    MyHashMap<Integer, String> map = new MyHashMap();
    IntStream.rangeClosed(0, 3).forEach(x -> map.put(x, String.valueOf(x)));
    Assertions.assertNull(map.remove(100));
  }

  @Test
  void getValueByNotExistingKeyTest() {
    MyHashMap<Integer, String> map = new MyHashMap();
    IntStream.rangeClosed(0, 3).forEach(x -> map.put(x, String.valueOf(x)));
    Assertions.assertNull(map.get(100));
  }

  @Test
  void getValueByRemovedKeyTest() {
    MyHashMap<Integer, String> map = new MyHashMap();
    map.put(1, "Value");
    map.remove(1);
    Assertions.assertNull(map.get(1));
  }

  @Test
  void sizeAfterClearTest() {
    MyHashMap<Integer, String> map = new MyHashMap();
    IntStream.rangeClosed(0, 3).forEach(x -> map.put(x, String.valueOf(x)));
    map.clear();
    Assertions.assertEquals(0, map.size());
  }

  @Test
  void getValueAfterClearTest() {
    MyHashMap<Integer, String> map = new MyHashMap();
    IntStream.rangeClosed(0, 3).forEach(x -> map.put(x, String.valueOf(x)));
    map.clear();
    IntStream.rangeClosed(0, 3).forEach(x -> Assertions.assertNull(map.get(x)));
  }

  @Test
  void growingSizeTest() {
    MyHashMap<Integer, String> map = new MyHashMap();
    IntStream.rangeClosed(0, 100).forEach(x -> map.put(x, String.valueOf(x)));
    Assertions.assertEquals(101, map.size());
  }

  @Test
  void gettingValuesAfterGrowingTest() {
    MyHashMap<Integer, String> map = new MyHashMap();
    map.put(-1, "Hi");
    IntStream.rangeClosed(0, 100).forEach(x -> map.put(x, String.valueOf(x)));
    Assertions.assertEquals("Hi", map.get(-1));
  }

}