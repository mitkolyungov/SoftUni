package implementations;

import interfaces.LinkedList;

import java.util.Iterator;

public class SinglyLinkedList<E> implements LinkedList<E> {

    static class Node<E> {
        E key;
        Node<E> next;

        public Node(E key) {
            this.key = key;
        }
    }

    Node<E> head;
    int size;
    public SinglyLinkedList() {

    }

    @Override
    public void addFirst(E element) {
        Node<E> newNode = new Node<> (element);
        if (this.head != null) {
            newNode.next = this.head;
        }
        this.head = newNode;
        size++;
    }

    @Override
    public void addLast(E element) {
        Node<E> newNode = new Node<> (element);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<E> current = this.head;
            while (current.next!=null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public E removeFirst() {
        if (this.head==null){
            throw new IllegalStateException ();
        }
        Node<E> removedNode = this.head;
        this.head = this.head.next;
        size--;
        return removedNode.key;
    }

    @Override
    public E removeLast() {
        if (this.head==null){
            throw new IllegalStateException ();
        }
        Node<E> current = this.head;

        while (current.next.next!=null){
            current = current.next;
        }
        Node<E> lastNode = current.next;
        current.next = null;
        size--;
        return lastNode.key;
    }

    @Override
    public E getFirst() {
        if (this.head==null){
            throw new IllegalStateException ();
        }
        return this.head.key;
    }

    @Override
    public E getLast() {
        if (this.head==null){
            throw new IllegalStateException ();
        }
        Node<E> current = this.head;
        while (current.next!=null){
            current = current.next;
        }
        return current.key;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size<=0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E> () {
            private Node<E> currentNode = head;
            @Override
            public boolean hasNext() {
                return currentNode.next!=null;
            }

            @Override
            public E next() {
                E key = currentNode.key;
                currentNode = currentNode.next;
                return currentNode.key;
            }
        };
    }
}
