package ru.progwards.java1.lessons.interfaces2;

public interface Comparator <newNumber> {

    public default boolean compareTo(newNumber o1, newNumber o2) {
        return compareTo(o1, o2);
    }
}
