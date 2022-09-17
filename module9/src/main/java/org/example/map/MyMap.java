package org.example.map;

public interface MyMap <K, V> {

  V put(K key, V value);
  V remove(K key);
  void clear();
  V get(K key);
  int size();

}
