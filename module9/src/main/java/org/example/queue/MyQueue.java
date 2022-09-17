package org.example.queue;

import java.util.Arrays;
import java.util.stream.IntStream;
import org.example.MyCollection;

public class MyQueue<T> implements MyCollection<T> {

  private Object[] data;
  private static final int DEFAULT_CAPACITY = 10;
  private int size = 0;

  private int head = 0;

  public <T> MyQueue() {
    data = new Object[DEFAULT_CAPACITY];
  }


  private <T> MyQueue(Object[] arr) {
    size = arr.length;
    data = Arrays.copyOf(arr, arr.length);
  }

  /**
   * Checks if the number of elements less than index position.
   * @param index position
   * @return
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

  @Override
  public int size() {
    return size;
  }

  @Override
  public void clear() {
    Arrays.fill(data, null);
    size = 0;
    head = 0;
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
    data = IntStream.range(head, data.length)
        .filter(x -> x != index)
        .mapToObj(x -> data[x])
        .toArray();
    head = 0;
  }

  public T peek() {
    return (T) data[head];
  }

  public T poll() {
    T iteam = (T) data[head];
    data[head] = null;
    head++;
    size--;
    return iteam;
  }
}
