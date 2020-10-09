package ru.progwards.java1.lessons.bigints;

public class AbsInteger {

    private int num;

    public AbsInteger(int num) {
        this.intValue();
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

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        num1 = num1;
        num2 = num2;
        int a = num1.intValue();
        int b = num2.intValue();
        int res = (a + b);
        return new ShortInteger((short) res);

    }
}

class ByteInteger extends AbsInteger {
    byte num;

    public ByteInteger(byte num) {
        super(num);

        this.num=num;
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

class ShortInteger extends AbsInteger {
    short num;

    public ShortInteger(short num) {
        super(num);
        this.num=num;
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

class IntInteger extends AbsInteger {
    int num;

    public IntInteger(int num) {
        super(num);
        this.num=num;
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
