package ru.progwards.java1.lessons.collections;

import java.util.*;


public class ArrayIterator<T> implements Iterator<T> {
    private T[] array;
    private int pos = 0;

    ArrayIterator(T[] array) {
        this.array = array;
    }

    public boolean hasNext() {
        return pos < array.length;
    }

    public T next() throws NoSuchElementException {
        if (hasNext())
            return array[pos++];
        else
            throw new NoSuchElementException();
    }

    public void remove() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (Integer e : new Integer[]{90, 300, 12, 6, 3, 9, 21}) list.add(e);
        list.iterator();
        System.out.println(list);
    }
}
