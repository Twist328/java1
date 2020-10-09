package ru.progwards.java1.lessons.bigints;

public class AbsInteger {

    private int num;

    public AbsInteger(int num) {
        this.num = num;
    }

    public static void main(String[] args) {

        AbsInteger num1 = new IntInteger((int) 258);
        AbsInteger num2 = new ShortInteger((short) 10);

        int a = num1.intValue();
        int b = num2.intValue();
        int sum = (a + b);
        System.out.println(sum);
    }

    public int intValue() {
        return num;
    }

    public byte byteValue() {
        return (byte) num;
    }

    public short shortValue() {
        return (short) num;
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        num1 = num1;
        num2 = num2;
        int a = num1.intValue();
        int b = num2.intValue();
        int sum = (a + b);
        return new AbsInteger(sum);

    }
}

class ByteInteger extends AbsInteger {
    byte num;

    @Override
    public int intValue() {
        return super.intValue();
    }

    @Override
    public byte byteValue() {
        return super.byteValue();
    }

    @Override
    public short shortValue() {
        return super.shortValue();
    }

    public ByteInteger(byte num) {
        super(num);

        this.num = num;
    }

    @Override
    public String toString() {
        return "" + num;
    }
}

class ShortInteger extends AbsInteger {
    short num;

    @Override
    public int intValue() {
        return super.intValue();
    }

    @Override
    public byte byteValue() {
        return super.byteValue();
    }

    @Override
    public short shortValue() {
        return super.shortValue();
    }

    public ShortInteger(short num) {
        super(num);
        this.num = num;
    }

    @Override
    public String toString() {
        return "" + num;
    }
}

class IntInteger extends AbsInteger {
    int num;

    @Override
    public int intValue() {
        return super.intValue();
    }

    @Override
    public byte byteValue() {
        return super.byteValue();
    }

    @Override
    public short shortValue() {
        return super.shortValue();
    }

    public IntInteger(int num) {
        super(num);
        this.num = num;
    }

    @Override
    public String toString() {
        return "" + num;
    }
}
