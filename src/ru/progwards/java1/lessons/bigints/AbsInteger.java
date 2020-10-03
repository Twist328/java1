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

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        AbsInteger sum;
        AbsInteger a = null;
        AbsInteger b = null;
        a = new AbsInteger(num1);
        b = new AbsInteger(num2);
        sum = a.add(b);

        return sum;
    }

    private AbsInteger add(AbsInteger b) {
        return this;
    }

    class ByteInteger extends AbsInteger {
        byte value;

        public ByteInteger(byte value) {
            super(value);

        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    class ShortInteger extends AbsInteger {
        short value ;

        public ShortInteger(short value) {
            super(value);
        }

        @Override
        public String toString() {
            return "" + value;

        }
    }

    class IntInteger extends AbsInteger {
        int value ;

        public IntInteger(int value) {
            super(value);
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }
}

