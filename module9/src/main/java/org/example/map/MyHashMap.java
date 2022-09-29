package org.example.map;

import java.util.Arrays;
import java.util.Objects;
import lombok.Setter;

public class MyHashMap<K, V> implements MyMap<K, V> {

  private static final int DEFAULT_CAPACITY = 10;

  private static final float DEFAULT_LOAD_FACTOR = 0.75f;

  private static final float GROWS_FACTOR = 1.5f;

  private Node<K, V>[] nodes;

  private int size = 0;

  public MyHashMap() {
    nodes = new Node[DEFAULT_CAPACITY];
  }

  @Override
  public V put(K key, V value) {
    rehash();
    int hashCode = getHashCode(key);
    int index = getIndex(hashCode);
    Node<K, V> currentNode = nodes[index];
    if(currentNode == null) {
      nodes[index] = new Node<>(key, value, hashCode);
      size++;
      return value;
    } else {
      Node<K, V> prevNode = currentNode;
      while (currentNode != null) {
        if (currentNode.hashCode == hashCode) {
          V existingValue = currentNode.value;
          currentNode.setValue(value);
          return existingValue;
        }
        prevNode = currentNode;
        currentNode = currentNode.next;
      }
      size++;
      prevNode.setNext(new Node<>(key, value, hashCode));
      return prevNode.value;
    }
  }

  private void rehash() {
    if(checkLoadFactor()) {
      Node<K, V>[] temp = nodes;
      nodes = new Node[(int) (nodes.length * GROWS_FACTOR)];
      size = 0;
      for(Node<K, V> node : temp) {
        while (Objects.nonNull(node)) {
          put(node.key, node.value);
          node = node.next;
        }
      }
    }
  }

  private boolean checkLoadFactor() {
    return (size / (float) nodes.length) >= DEFAULT_LOAD_FACTOR;
  }

  private int getHashCode(K key) {
    return key.toString().hashCode();
  }

  private int getIndex(int hashCode) {
    return hashCode % nodes.length;
  }


  @Override
  public V remove(K key) {
    int hashCode = getHashCode(key);
    int index = getIndex(hashCode);
    Node<K, V> currentNode = nodes[index];
    Node<K, V> prevNode = null;
    while (currentNode != null) {
      if (currentNode.hashCode == hashCode) {
        V existingValue = currentNode.value;
        if(prevNode == null) {
          nodes[index] = currentNode.next;
        } else {
          prevNode.next = currentNode.next;
        }
        size--;
        return existingValue;
      }
      prevNode = currentNode;
      currentNode = currentNode.next;
    }
    return null;
  }

  @Override
  public void clear() {
    Arrays.fill(nodes, null);
    size = 0;
  }

  @Override
  public V get(K key) {
    int hashCode = getHashCode(key);
    int index = getIndex(hashCode);
    Node<K, V> currentNode = nodes[index];
    while (Objects.nonNull(currentNode)) {
      if (currentNode.hashCode == hashCode) {
        return currentNode.value;
      }
      currentNode = currentNode.next;
    }
    return null;
  }

  @Override
  public int size() {
    return size;
  }

  @Setter
  private static class Node<K, V> {

    K key;
    V value;
    int hashCode;
    Node<K, V> next = null;

    public Node(K key, V value, int hashCode) {
      this.key = key;
      this.value = value;
      this.hashCode = hashCode;
    }

  }
}
