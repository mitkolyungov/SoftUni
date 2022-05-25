package implementations;

import interfaces.AbstractQueue;

import java.util.Iterator;
import java.util.LinkedList;

public class Queue<E> implements AbstractQueue<E> {
    static class Node<E> {
        E element;
        Node<E> next;

        public Node(E element) {
            this.element = element;
        }

    }

    Node<E> head;
    int size = 0;

    LinkedList<E> queue = new LinkedList<> ();

    @Override
    public void offer(E element) {
        Node<E> newNode = new Node<> (element);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<E> current = this.head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        this.size++;
    }

    @Override
    public E poll() {

        if (isEmpty ()){
            throw new IllegalStateException ();
        }
        E element = this.head.element;
        if (this.size == 1) {
            this.head = null;
        } else {
            Node<E> temp = this.head.next;
            this.head.next = null;
            this.head = temp;
        }
        this.size--;
        return element;
    }

    @Override
    public E peek() {
        if (isEmpty ()){
            throw new IllegalStateException ();
        }
        return this.head.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size <= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E> () {
            private Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public E next() {
                E element = current.element;
                this.current = this.current.next;
                return element;
            }
        };
    }
}
