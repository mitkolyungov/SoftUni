package implementations;

import interfaces.List;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<E> implements List<E> {

    private static final int DEFAULT_CAPACITY = 4;
    int size = 0;
    Object[] elements;

    public ArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public boolean add(E element) {
        if (this.size == this.elements.length) {
            this.elements = grow ();
        }

        this.elements[this.size++] = element;
        return true;
    }

    private Object[] grow() {
        return Arrays.copyOf (this.elements, this.elements.length * 2);
    }

    @Override
    public boolean add(int index, E element) {
        checkIndex (index);
        insert (index, element);
        return true;
    }

    private void insert(int index, E element) {
        if (this.size == this.elements.length) {
            this.elements = grow ();
        }
        E lastElement = (E) this.elements[size - 1];
        for (int i = this.size - 1; i > index; i--) {
            this.elements[i] = this.elements[i - 1];
        }
        this.elements[size] = lastElement;
        this.elements[index] = element;
        this.size++;
    }

    @Override
    public E get(int index) {
        checkIndex (index);
        return (E) this.elements[index];
    }

    private void checkIndex(int index) {
        if (index<0 || index>=this.size) {
            throw new IndexOutOfBoundsException ("Index out of bounds");
        }
    }

    @Override
    public E set(int index, E element) {
        checkIndex (index);
        E oldElement = this.get (index);
        this.elements[index] = element;
        return oldElement;
    }

    @Override
    public E remove(int index) {
        this.checkIndex (index);
        E removedElement = this.get (index);
        this.elements[index] = null;
        size--;
        shift (index);
        ensureCapacity ();
        return removedElement;
    }

    private void shift(int index) {
        for (int i = index; i < this.size; i++) {
            this.elements[i] = this.elements[i + 1];
        }
    }

    private void ensureCapacity() {
        if (this.size < this.elements.length / 3) {
            this.elements =  shrink ();
        }
    }

    private Object[] shrink() {
        return Arrays.copyOf (this.elements, this.elements.length / 2);
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int indexOf(E element) {
        for (int i = 0; i < this.size; i++) {
            if (this.elements[i].equals (element)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public boolean contains(E element) {
        return indexOf (element) >= 0;
    }

    @Override
    public boolean isEmpty() {
        return this.size <= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E> () {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public E next() {
                return get (index++);
            }
        };
    }
}
