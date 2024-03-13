package org.academy2024.LinkedListImplementation;

public class LinkedList {
    private Node first;

    private static class Node {
        private int num;
        private Node next;

        Node(int num) {
            this.num = num;
            next = null;
        }
    }

    public void add(int number) {
        new Node(number);
    }

}

