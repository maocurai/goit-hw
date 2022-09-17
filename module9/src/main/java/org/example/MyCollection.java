package org.example;

public interface MyCollection<T> {

  void add(T o);

  int size();

  void clear();

  T remove(int index);

}
