package ru.progwards.java1.lessons.bigints;

public class AbsInteger {

     int num;


    public static void main(String[] args) {

        AbsInteger num1 = new IntInteger((int) 258);
        AbsInteger num2 = new ShortInteger((short) 10);

        int a = num1.intValue();
        int b = num2.intValue();
        int sum = (a + b) ;
        System.out.println(sum);
    }

    public AbsInteger() {
    }

    public int intValue() {
        return num;
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        num1 = num1;
        num1=num1;
        num2 = num2;
        int a = num1.intValue();
        int b = num2.intValue();
        int res = (a + b) ;
        return new ByteInteger((byte) res);

    }
}

class ByteInteger extends AbsInteger {
    byte num;

    public ByteInteger(byte num) {
        super();

        this.num = num;
    }

    public ByteInteger() {

    }

    public ByteInteger(short num) {

    }

    @Override
    public int intValue() {

        return num ;
    }

    @Override
    public String toString() {
        return "" + num;
    }
}

class ShortInteger extends AbsInteger {
    short num;

    public ShortInteger(short num) {
        super();
        this.num = num;
    }

    public ShortInteger() {

    }

    @Override
    public int intValue() {
        return num ;
    }

    @Override
    public String toString() {
        return "" + num;
    }
}

class IntInteger extends AbsInteger {
    int num;

    public IntInteger(int num) {
        super();
        this.num = num;
    }
    public IntInteger(){

    }
    @Override
    public int intValue() {
        return num ;
    }

    @Override
    public String toString() {
        return "" + num;
    }
}

