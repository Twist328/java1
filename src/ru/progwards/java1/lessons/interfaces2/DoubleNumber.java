package ru.progwards.java1.lessons.interfaces2;

import java.util.Comparator;

public class DoubleNumber extends Number{

    public DoubleNumber() {
    }

    @Override
    public Comparator<Number> thenComparing(Comparator<? super Number> other) {
        return null;
    }
}
