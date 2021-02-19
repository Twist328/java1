package ru.progwards.java1.lessons.interfaces2;



public interface Comparable<Number> {
    public CompareResult compareNumber(Comparable<Number> smthHasNumber);

    int compareTo(ru.progwards.java1.lessons.interfaces2.Number o);

    public enum CompareResult {
        LESS,
        EQUAL,
        GREATER;
    }
}