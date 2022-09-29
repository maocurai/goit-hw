package org.example.list;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;

public class MyArrayList<T> implements MyList<T> {

  private Object[] data;

  private static final int DEFAULT_CAPACITY = 10;

  private int size = 0;

  public MyArrayList() {
    data = new Object[DEFAULT_CAPACITY];
  }

  public MyArrayList(int capacity) {
    data = new Object[capacity];
  }

  /**
   * Checks if the number of elements less than index position.
   * @param index position
   * @return true if index bound
   */
  private boolean checkElementIndex(int index) {
    return (index < size && index >= 0);
  }


  /**
   * Increases array size by 1.5
   */
  private void grow() {
    data = Arrays.copyOf(data, (int) (data.length * 1.5));
  }

  /**
   * Adds element to list.
   *
   * @param o element to add
   */
  public void add(T o) {
    if (size < data.length) {
      data[size] = o;
      ++size;
    } else {
      grow();
      add(o);
    }
  }


  /**
   * Returns element by the position.
   *
   * @param index element position
   * @return list element
   */
  public T get(int index) {
    if (checkElementIndex(index)) {
      return (T) data[index];
    } else {
      throw new IndexOutOfBoundsException(index);
    }
  }

  /**
   * Removes element by position.
   *
   * @param index position
   * @return value of removed element
   */
  public T remove(int index) {
    if (checkElementIndex(index)) {
      --size;
      T oldElement = (T) data[index];
      copyExcept(index);
      return oldElement;
    } else {
      throw new IndexOutOfBoundsException(index);
    }
  }


  private void copyExcept(int index) {
    data = IntStream.range(0, data.length)
        .filter(x -> x != index)
        .mapToObj(x -> data[x])
        .toArray();
  }

  /**
   * Returns number of elements in list.
   * @return number of elements in list
   */
  public int size() {
    return size;
  }

  @Override
  public void clear() {
    Arrays.fill(data, null);
    size = 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    MyArrayList<T> that = (MyArrayList<T>) o;
    return (size == that.size)
        && IntStream.range(0, size).allMatch(x -> data[x].equals(that.data[x]));
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(size);
    result = 31 * result + Arrays.hashCode(data);
    return result;
  }

}
