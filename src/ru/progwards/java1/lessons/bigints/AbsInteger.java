package ru.progwards.java1.lessons.bigints;

public class AbsInteger {
    private static AbsInteger num1;
    private static AbsInteger num2;

    public AbsInteger(byte value) {
    }

    public AbsInteger(short value) {
    }

    public AbsInteger(int value) {
    }

    public AbsInteger(AbsInteger num1) {
    }


    public static void main(String[] args) {

        AbsInteger num = new AbsInteger(2);
        System.out.println(num);
    }

    static byte add(AbsInteger num1, AbsInteger num2) {
        byte sum, a = 0, b = 0;
        num1 = new AbsInteger(Byte.parseByte(String.valueOf(num1)));
        num2 = new AbsInteger(Byte.parseByte(String.valueOf(num2)));

        sum = (byte) (a + b);

        return sum;
    }

    //private AbsInteger add(AbsInteger b) {
    // return this;
}

class ByteInteger extends AbsInteger {
    byte value = 0;

    public ByteInteger(byte value) {
        super(value);

    }

    @Override
    public String toString() {
        return "" + value;
    }
}

class ShortInteger extends AbsInteger {
    short value = 0;

    public ShortInteger(short value) {
        super(value);
    }

    @Override
    public String toString() {
        return "" + value;

    }
}

class IntInteger extends AbsInteger {
    int value = 0;

    public IntInteger(int value) {
        super(value);
    }

    @Override
    public String toString() {
        return "" + value;
    }
}


