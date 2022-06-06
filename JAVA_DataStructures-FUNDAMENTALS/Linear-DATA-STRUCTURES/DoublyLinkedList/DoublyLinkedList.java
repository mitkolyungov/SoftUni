package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class DoublyLinkedList<E> implements LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> previous;

        public Node(E value) {
            this.element = value;
        }
    }

    public DoublyLinkedList() {
    }

    public void addFirst(E element) {
        Node<E> newNode = new Node<> (element);
        if (this.head == null) {
            this.tail = newNode;
        } else {
            newNode.next = this.head;
            this.head.previous = newNode;
        }
        this.head = newNode;
        this.size++;
    }

    public void addLast(E element) {
        Node<E> newNode = new Node<> (element);
        if (this.head == null) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
            newNode.previous = this.tail;
        }
        this.tail = newNode;
        this.size++;
    }

    public E removeFirst() {
        ensureNotEmpty ();
        E element = this.head.element;
        if (this.size == 1) {
            this.head = null;
        } else {
            Node<E> newHead = this.head.next;
            newHead.previous = null;
            this.head = newHead;
        }
        this.size--;
        return element;
    }

    private void ensureNotEmpty() {
        if (this.size == 0) {
            throw new IllegalStateException ("Illegal remove for empty LinkedList");
        }
    }

    public E removeLast() {
        ensureNotEmpty ();
        E element = this.tail.element;
        if (this.size == 1) {
            return removeFirst ();
        } else {
            Node<E> newTail = this.tail.previous;
            newTail.next = null;
            this.tail = newTail;
        }
        this.size--;

        return element;
    }

    public E getFirst() {
        ensureNotEmpty ();
        return this.head.element;
    }

    public E getLast() {
        ensureNotEmpty ();
        return this.tail.element;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<E> () {
            private Node<E> currentStart = head;

            @Override
            public boolean hasNext() {
                return currentStart != null;
            }


            @Override
            public E next() {
                E element = currentStart.element;
                currentStart = currentStart.next;
                return element;
            }
        };
    }
}
