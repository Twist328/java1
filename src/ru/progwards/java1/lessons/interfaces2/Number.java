package ru.progwards.java1.lessons.interfaces2;

import java.util.Comparator;

public abstract class Number implements Comparator<Number> {


    public Number() {
    }


    @Override
    public int compare(Number o1, Number o2) {
        return 0;
    }
}


