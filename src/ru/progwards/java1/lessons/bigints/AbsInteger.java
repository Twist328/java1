package ru.progwards.java1.lessons.bigints;

import static java.lang.Integer.*;

public class AbsInteger {

    public AbsInteger(byte num) {

    }

    public  int intValue(){
        return 0;
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        int a = num1.intValue();
        int b = num2.intValue();
        byte num= (byte) (a+b);

        return new AbsInteger((byte) num);

    }

static class ByteInteger extends AbsInteger {
    byte num;

    public ByteInteger(byte num) {
        super(num);

        this.num = num;
    }

    @Override
    public int intValue() {
        return super.intValue();
    }

    @Override
    public String toString() {
        return "" + num;
    }

}

static class ShortInteger extends AbsInteger {
    short num;

    public ShortInteger(short num) {
        super((byte) num);

        this.num = num;
    }

    @Override
    public int intValue() {
        return super.intValue();
    }

    @Override
    public String toString() {
        return "" + num;

    }
}

static class IntInteger extends AbsInteger {
    int num;

    public IntInteger(int num) {
        super((byte) num);
        this.num = num;

    }

    @Override
    public int intValue() {
        return super.intValue();
    }

    @Override
    public String toString() {
        return "" + num;
    }
}
    public static void main(String[] args) {

        AbsInteger num = new AbsInteger((byte) 6);
        IntInteger num5 = new IntInteger(9);
        ShortInteger num3 = new ShortInteger((short) 8);
        ByteInteger num4 = new ByteInteger((byte) 6);

        System.out.println(num);
        System.out.println(num3);
        System.out.println(num4);
        System.out.println(num5);
    }
}
