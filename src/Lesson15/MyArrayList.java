package Lesson15;

import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public MyArrayList() {
        this.elements = new Object[DEFAULT_CAPACITY];
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity >= 0) {
            this.elements = new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Capacity cannot be negative: " + initialCapacity);
        }
    }

    private void grow() {
        int newCapacity = (elements.length == 0) ? DEFAULT_CAPACITY : elements.length * 2;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public void add(T element) {
        if (size == elements.length) {
            grow();
        }
        elements[size++] = element;
    }

    @SuppressWarnings("unchecked")
    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) elements[index];

        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return removedElement;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (element == null) {
                if (elements[i] == null) return true;
            } else if (element.equals(elements[i])) {
                return true;
            }
        }
        return false;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }
}
