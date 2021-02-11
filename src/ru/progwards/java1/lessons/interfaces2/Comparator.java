package ru.progwards.java1.lessons.interfaces2;

public interface Comparator <newNumber> {

    public default boolean compare(newNumber o1, newNumber o2) {
        return compare(o1, o2);
    }
}
