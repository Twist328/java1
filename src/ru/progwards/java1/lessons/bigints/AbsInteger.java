package ru.progwards.java1.lessons.bigints;

public class AbsInteger {

    private int num;

    public static void main(String[] args) {

        //AbsInteger absInteger = new ByteInteger((byte) 127);
        // AbsInteger absInteger2 = new IntInteger((int) 127);
        //AbsInteger absInteger1= new ShortInteger((short) 889);
        // IntInteger num5 = new IntInteger(9);
        // ShortInteger num3 = new ShortInteger((short) 8);
        // ByteInteger num4 = new ByteInteger((byte) 6);
        AbsInteger num6 = new ByteInteger((byte) 9);
        AbsInteger num7 = new ByteInteger((byte) 10);
        //System.out.println(absInteger1);
        //System.out.println(absInteger2);
        //System.out.println(absInteger);
        //System.out.println(num3);
        //System.out.println(num4);
        //System.out.println(num5);

        int a = num6.intValue();
        int b = num7.intValue();
        int sum = (a + b) / 2;
        System.out.println(sum);
    }

    public AbsInteger(int num) {
    }

    public int intValue() {
        return num + num;
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        num1 = new ByteInteger((byte) 0);
        num2 = new ByteInteger((byte) 0);
        int a = num1.intValue();
        int b = num2.intValue();
        int sum = (a + b)/2;
        return new ByteInteger((byte) sum);

    }
}

class ByteInteger extends AbsInteger {
    byte num;

    public ByteInteger(byte num) {
        super(num);

        this.num = num;
    }

    @Override
    public int intValue() {

        return num + num;
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
        this.num = num;
    }

    @Override
    public int intValue() {
        return num + num;
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
        this.num = num;
    }

    @Override
    public int intValue() {
        return num + num;
    }

    @Override
    public String toString() {
        return "" + num;
    }
}
