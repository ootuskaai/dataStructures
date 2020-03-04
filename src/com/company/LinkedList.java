package com.company;

import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    public void addFirst(int item) {
        Node node = new Node(item);
        if(isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }

    public void addLast(int item) {
        Node node = new Node(item);
        if(isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public int indexOf(int item) {
        int index = 0;
        Node current = first;
        while (current != null) {
            if(current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public int indexOf2(int item) {
        Node current = first;
        for (int i = 0; i < size; i++) {
            if (current.value == item) return i;
            current = current.next;
        }
        return -1;
    }

    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    public void removeFirst() {
        if (isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            size = 0;
            return;
        }

        Node second = first.next;
        first.next = null;
        first = second;
        size--;
    }

    public void removeLast() {
        if(isEmpty())
            throw new NoSuchElementException();

        if (first == last) {
            first = last = null;
            size = 0;
            return;
        }

        Node previous = getPrevious(last);
        last = previous;
        last.next = null;
        size--;
    }

    private Node getPrevious(Node node) {
        Node current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    public int size() {
        return size;
    }

    private boolean isEmpty() {
        return first == null;
    }
}
