package ru.progwards.java1.lessons.bigints;

public class AbsInteger {

    private int num;

    public AbsInteger(byte num) {
        this.num=num;

    }

    public static void main(String[] args) {

        AbsInteger num3 = new ByteInteger((byte) 456);
        AbsInteger num4 = new ByteInteger((byte) 564);

        int b = num3.byteValue();
        int b1 = num4.byteValue();
        int sum1 = (b + b1);

        System.out.println(sum1);

    }

    public byte byteValue() {
        return (byte) num;
    }

        static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        num1 = num1;
        num2 = num2;

        int a = num1.byteValue();
        int b = num2.byteValue();
        int sum = (a + b);

       return new ByteInteger((byte) sum);

        }
    }

    class ByteInteger extends AbsInteger {
        byte num;

        @Override
        public byte byteValue() {
            return super.byteValue();
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
            byte num;

        @Override
        public byte byteValue() {
            return super.byteValue();
        }

        public ShortInteger(byte num) {
            super((byte) num);

            this.num = (byte) num;
        }

        @Override
        public String toString() {
            return "" + num;
        }
    }

    class IntInteger extends AbsInteger {
        byte num;

        @Override
        public byte byteValue() {
            return super.byteValue();
        }

        public IntInteger(byte num) {
            super((byte) num);

            this.num = num;
        }

        @Override
        public String toString() {
            return "" + num;
        }
    }
