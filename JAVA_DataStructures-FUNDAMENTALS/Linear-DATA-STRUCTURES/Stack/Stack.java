package implementations;

import interfaces.AbstractStack;

import java.util.Iterator;
import java.util.LinkedList;

public class Stack<E> implements AbstractStack<E> {
    static class Node<E>{
        E element;
        Node<E> previous;

        public Node(E element) {
            this.element = element;
        }
    }

    Node<E> top;
    int size = 0;

    @Override
    public void push(E element) {
        Node<E> newNode = new Node<> (element);
        newNode.previous = top;
        top = newNode;
        this.size++;
    }

    @Override
    public E pop() {
        if (isEmpty ()){
            throw new IllegalStateException ();
        }
        E element = this.top.element;
        Node<E> temp = top.previous;
        this.top.previous = null;
        this.top = temp;
        this.size--;

        return element;
    }


    @Override
    public E peek() {
        if (isEmpty ()){
            throw new IllegalStateException ();
        }
        return this.top.element;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size<=0;
    }


    @Override
    public Iterator<E> iterator() {
        return new Iterator<> () {
            private Node<E> current = top;
            @Override
            public boolean hasNext() {
                return current !=null;
            }

            @Override
            public E next() {
                E element = current.element;
                this.current = this.current.previous;
                return element;
            }
        };
    }
}
