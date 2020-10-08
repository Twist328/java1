package ru.progwards.java1.lessons.bigints;

import static java.lang.Integer.*;

public class AbsInteger {

    public int intValue(){
        return 0;
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        int sum;
        AbsInteger a = new AbsInteger();
        AbsInteger b = new AbsInteger();
        AbsInteger result = a.add(b);
        return result;

    }

    private AbsInteger add(AbsInteger b) {
        return null;
    }
}

class ByteInteger extends AbsInteger {
    byte num;

    public ByteInteger(byte num) {

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

class ShortInteger extends AbsInteger {
    short num;

    public ShortInteger(short num) {

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

class IntInteger extends AbsInteger {
    int num;

    public IntInteger(int num) {

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

    public static void main(String[] args) {
        AbsInteger res = new AbsInteger();
        IntInteger num = new IntInteger(9);
        ShortInteger num3 = new ShortInteger((short) 8);
        ByteInteger num4 = new ByteInteger((byte) 6);
        System.out.println(num3);
        System.out.println(num);
        System.out.println(num4);
        System.out.println(res);
    }
}
