package org.example.stack;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MyStack<T>  {

  private Object[] data;

  private static final int DEFAULT_CAPACITY = 10;

  private int size = 0;

  public MyStack() {
    data = new Object[DEFAULT_CAPACITY];
  }

  public MyStack(int capacity) {
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
  public T push(T o) {
    if (size < data.length) {
      data[size] = o;
      ++size;
    } else {
      grow();
      push(o);
    }
    return o;
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

  public int size() {
    return size;
  }

  public void clear() {
    Arrays.fill(data, null);
    size = 0;
  }

  public T peek() {
    if (size - 1 >= 0) {
      return (T) data[size - 1];
    } else {
      throw new IndexOutOfBoundsException(size);
    }
  }

  public T pop() {
    if (size - 1 >= 0) {
      T iteam = (T) data[size - 1];
      data[size - 1] = null;
      --size;
      return iteam;
    } else {
      throw new IndexOutOfBoundsException(size);
    }
  }
}
