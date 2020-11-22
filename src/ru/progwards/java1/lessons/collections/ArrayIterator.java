package ru.progwards.java1.lessons.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

    private T[] array;

    ArrayIterator(T[] array) {
        this.array = array;
    }

    @Override
    public boolean hasNext() {

        return false;
    }

    @Override
    public T next() {
        if (next().equals(0))
            throw new NoSuchElementException();

        return (T) this;
    }
}
