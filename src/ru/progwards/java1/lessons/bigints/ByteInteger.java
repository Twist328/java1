package ru.progwards.java1.lessons.bigints;

class ByteInteger extends AbsInteger {
    byte num;

    public ByteInteger(byte num) {
        super();

        this.num = num;
    }

    public ByteInteger(short num) {
    }

    @Override
    public byte byteValue() {
        return num;
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
