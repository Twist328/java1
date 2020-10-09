package ru.progwards.java1.lessons.bigints;

public class AbsInteger {

    private int num;

    public AbsInteger(int num) {
        this.num = num;
    }

    public static void main(String[] args) {

        AbsInteger num1 = new IntInteger(258);
        AbsInteger num2 = new IntInteger(258);
        AbsInteger num3 = new ByteInteger((byte) 456);
        AbsInteger num4 = new ByteInteger((byte) 564);
        AbsInteger num5 = new ShortInteger((short) 345);
        AbsInteger num6 = new ShortInteger((short) 543);

        int a = num1.intValue();
        int a1 = num2.intValue();
        int sum = (a + a1);

        int b = num3.byteValue();
        int b1 = num4.byteValue();
        int sum1 = (b + b1);

        int c = num5.shortValue();
        int c1 = num6.shortValue();
        int sum2 = (c + c1);

        System.out.println(sum);
        System.out.println(sum1);
        System.out.println(sum2);
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
        int res = 0;
        int a = num1.intValue();
        int a1 = num2.intValue();
        int sum = (a + a1);

        int b = num1.byteValue();
        int b1 = num2.byteValue();
        int sum1 = (b + b1);

        int c = num1.shortValue();
        int c1 = num2.shortValue();
        int sum2 = (c + c1);

        int d = num1.intValue();
        int d1 = num2.byteValue();
        int sum3 = (d + d1);

        int g = num1.byteValue();
        int g1 = num2.shortValue();
        int sum4 = (g + g1);

        switch (res) {
            case 1:
                return new IntInteger(sum);
            case 2:
                return new ByteInteger((byte) sum1);
            case 3:
                return new ShortInteger((short) sum2);
            case 4:
                return new IntInteger(sum3);
            case 5:
            default:
                return new ShortInteger((short) sum4);


        }

    }

    static class ByteInteger extends AbsInteger {
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

    static class ShortInteger extends AbsInteger {
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

    static class IntInteger extends AbsInteger {
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
}