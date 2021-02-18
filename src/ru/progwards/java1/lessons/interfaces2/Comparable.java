package ru.progwards.java1.lessons.interfaces2;



public interface Comparable<Number> {
    public CompareResult compareNumber(Comparable<Number> smthHasNumber);
    public enum CompareResult {
        LESS,
        EQUAL,
        GREATER;
    }
}