package org.example.list;

public class Node<T> {

    T data;
    Node<T> next = null;
    Node<T> prev = null;

    public Node() {}

    public Node(Node<T> node) {
        this.data = node.data;
        this.next = node.next;
        this.prev = node.prev;
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
