package ru.progwards.java1.lessons.interfaces2;

import java.util.Comparator;

public class IntNumber extends Number {


    public IntNumber() {
    }

    @Override
    public Comparator<Number> thenComparing(Comparator<? super Number> other) {
        return null;
    }
}

