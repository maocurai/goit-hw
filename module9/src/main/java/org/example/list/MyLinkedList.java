package org.example.list;

import java.util.LinkedList;

public class MyLinkedList<T> implements MyList<T> {

    private Node<T> head = null;
    private Node<T> tail = null;
    private int size = 0;

    public MyLinkedList() {}

    @Override
    public void add(T data) {
        Node<T> node = new Node<>(data);
        if(head == null) {
            this.head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        this.tail = node;
        size++;
    }

    @Override
    public T get(int index) {
        return findAt(index).getData();
    }

    private T deleteFirst() {
        T data = head.getData();
        head = head.next;
        return data;
    }

    @Override
    public T remove(int index) {
        if(index == 0) {
            size--;
            return deleteFirst();
        }
        Node<T> node = findAt(index);
        T data = node.getData();
        node.prev.next = node.next;
        size--;
        return data;
    }

    private Node<T> findAt(int index) {
        if(index > size - 1 || index < 0) {
            throw new IndexOutOfBoundsException(index);
        }
        Node current = head;
        int currInd = 0;
//        if(index == 0) { return head; }
        while(currInd < index) {
            current = current.next;
            currInd++;
        }
        return current;
    }

    @Override
    public int size() {
        LinkedList list;
        return size;
    }

    @Override
    public void clear() {
        Node<T> currentNode = head;
        while (currentNode != null) {
            Node<T> nextNode = currentNode.next;
            currentNode.prev = null;
            currentNode.data = null;
            currentNode.next = null;
            currentNode = nextNode;
        }
        size = 0;
    }
}
