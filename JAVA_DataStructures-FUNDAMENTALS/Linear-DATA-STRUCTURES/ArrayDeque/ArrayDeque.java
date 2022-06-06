package implementations;

import interfaces.Deque;

import java.util.Iterator;

public class ArrayDeque<E> implements Deque<E> {
    private final static int INITIAL_CAPACITY = 7;
    private int size;
    private int head;
    private int tail;

    private Object[] elements;

    public ArrayDeque() {
        this.elements = new Object[INITIAL_CAPACITY];
        int middle = INITIAL_CAPACITY / 2;
        head = tail = middle;
        this.size = 0;
    }

    @Override
    public void add(E element) {
        this.addLast (element);
    }

    @Override
    public void offer(E element) {
        this.addLast (element);
    }

    @Override
    public void addFirst(E element) {
        if (isEmpty ()) {
            this.addLast (element);
        } else {
            if (this.head == 0) {
                this.elements = grow ();
            }
            this.elements[--this.head] = element;
            this.size++;
        }
    }

    @Override
    public void addLast(E element) {
        if (isEmpty ()) {
            this.elements[this.tail] = element;
        } else {
            if (this.tail == this.elements.length - 1) {
                this.elements = grow ();
            }
            this.elements[++this.tail] = element;
        }
        this.size++;
    }

    @Override
    public void push(E element) {
        this.addFirst (element);
    }

    @Override
    public void insert(int index, E element) {
        int realIndex = this.head + index;
        this.ensureIndex (realIndex);

        if (realIndex - this.head < this.tail - realIndex) {
            insertAndShiftLeft (realIndex - 1, element);
        } else {
            insertAndShiftRight (realIndex, element);
        }
    }

    @Override
    public void set(int index, E element) {
        int realIndex = this.head + index;
        this.ensureIndex (realIndex);
        this.elements[realIndex] = element;
    }

    @Override
    public E peek() {
        if (!isEmpty ()) {
            return this.getAt (this.head);
        }
        return null;
    }

    @Override
    public E poll() {
        return this.removeFirst ();
    }

    @Override
    public E pop() {
        return this.removeFirst ();
    }

    @Override
    public E get(int index) {
        int realIndex = this.head + index;
        this.ensureIndex (realIndex);
        return this.getAt (realIndex);
    }

    @Override
    public E get(Object object) {
        if (isEmpty ()) {
            return null;
        }
        for (int i = this.head; i <= this.tail; i++) {
            if (this.elements[i].equals (object)) {
                return this.getAt (i);
            }
        }
        return null;
    }

    @Override
    public E remove(int index) {
        int realIndex = this.head + index;
        this.ensureIndex (realIndex);
        E element = this.getAt (realIndex);

        for (int i = realIndex; i < this.tail; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.removeLast ();
        return element;
    }

    @Override
    public E remove(Object object) {
        if (isEmpty ()) {
            return null;
        }
        for (int i = this.head; i <= this.tail; i++) {
            if (this.elements[i].equals (object)) {
                E element = this.getAt (i);
                this.elements[i] = null;

                for (int j = i; j < this.tail; j++) {
                    this.elements[j] = this.elements[j + 1];
                }
                this.removeLast ();
                return element;
            }
        }
        return null;
    }

    @Override
    public E removeFirst() {
        if (!isEmpty ()) {
            E element = this.getAt (this.head);
            this.elements[this.head] = null;
            this.head++;
            this.size--;
            return element;
        }
        return null;
    }

    @Override
    public E removeLast() {
        if (!isEmpty ()) {
            E element = this.getAt (this.tail);
            this.elements[this.tail] = null;
            this.tail--;
            this.size--;
            return element;
        }
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int capacity() {
        return this.elements.length;
    }

    @Override
    public void trimToSize() {
        Object[] newElements = new Object[this.size];
        int index = 0;
        for (int i = this.head; i <= this.tail; i++) {
            newElements[index++] = this.elements[i];
        }
        this.elements = newElements;
    }

    @Override
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E> () {
            private int index = head;

            @Override
            public boolean hasNext() {
                return index <= tail;
            }

            @Override
            public E next() {
                return getAt (index++);
            }
        };
    }

    private Object[] grow() {
        int newCapacity = this.elements.length * 2 + 1;
        Object[] newElements = new Object[newCapacity];
        int middle = newCapacity / 2;
        int begin = middle - this.size / 2;
        int index = this.head;
        for (int i = begin; index <= this.tail; i++) {
            newElements[i] = this.elements[index++];
        }
        this.head = begin;
        this.tail = this.head + this.size - 1;
        return newElements;
    }

    @SuppressWarnings("unchecked")
    private E getAt(int index) {
        return (E) this.elements[index];
    }

    private void ensureIndex(int realIndex) {
        if (realIndex < this.head || realIndex > this.tail) {
            throw new IndexOutOfBoundsException ("Index out of bound for index: "
                    + (realIndex - this.head));
        }
    }

    private void insertAndShiftRight(int index, E element) {
        E lastElement = this.getAt (this.tail);
        for (int i = this.tail; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[index] = element;
        this.addLast (lastElement);
    }

    private void insertAndShiftLeft(int index, E element) {
        E firstElement = this.getAt (this.head);
        for (int i = this.head; i < index; i++) {
            this.elements[i] = this.elements[i + 1];
        }
        this.elements[index] = element;
        this.addFirst (firstElement);
    }
}