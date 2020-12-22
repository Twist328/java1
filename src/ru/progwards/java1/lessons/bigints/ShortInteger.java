package ru.progwards.java1.lessons.bigints;

public class ShortInteger extends AbsInteger {
    short num;

    public ShortInteger(short num) {
        super();
        this.num = num;
    }

    @Override
    public int intValue() {
        return (int) num;
    }

    @Override
    public String toString() {
        return "" + num;
    }
}
