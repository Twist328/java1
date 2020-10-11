package ru.progwards.java1.lessons.bigints;

class IntInteger extends AbsInteger {
    int num;

    public IntInteger(int num) {
        super();
        this.num = num;
    }

    @Override
    public int intValue() {
        return num;
    }

    @Override
    public String toString() {
        return "" + num;
    }
}
