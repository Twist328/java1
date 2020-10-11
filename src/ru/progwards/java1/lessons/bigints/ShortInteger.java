package ru.progwards.java1.lessons.bigints;

class ShortInteger extends AbsInteger {
    short num;

    public ShortInteger(short num) {
        super();
        this.num = num;
    }

    @Override
    public short shortValue() {
        return num;
    }

    @Override
    public byte byteValue() {
        return (byte) num;
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
