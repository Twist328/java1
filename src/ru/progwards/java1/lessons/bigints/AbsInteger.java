package ru.progwards.java1.lessons.bigints;

public class AbsInteger {

     int num;

    public AbsInteger(int num) {
        this.num=num;
    }
    public static void main(String[] args) {
        AbsInteger num3 = new ByteInteger((byte) 4);
        AbsInteger num4 = new ByteInteger((byte) 7);
        int b = num3.byteValue();
        int b1 = num4.byteValue();
        int sum1 = (b + b1);
        System.out.println(sum1);
    }
    public byte byteValue() {
        return (byte) num;
    }
    public int intValue(){
        return  num;
    }
    public short shortValue(){
        return (short) num;
    }
    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        num1 = num1;
        num2 = num2;
        int result = 0;
        int a = num1.intValue();
        int a1 = num2.intValue();
        int sum = (a + a1);

        int b = num1.byteValue();
        int b1 = num2.byteValue();
        byte sum1 = (byte) (b + b1);

        int c = num1.shortValue();
        int c1 = num2.shortValue();
        short sum2 = (short) (c + c1);

        if (result == sum) {
        } else
            return new IntInteger(sum);
        if (result == sum1) {
        } else
            return new ByteInteger(sum1);
        if (result == sum2) {

        } else {


        }
        return new ShortInteger(sum2);
    }

}
     class ByteInteger extends AbsInteger {
        byte num;
        @Override
        public int intValue(){
            return num;
        }
        @Override
        public byte byteValue() {
            return num;
        }
        @Override
        public short shortValue(){
                return num;
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
        public int intValue(){
            return  num;
        }
        @Override
        public byte byteValue() {
            return (byte) num;
        }
        @Override
        public short shortValue(){
            return num;
        }
        public ShortInteger(short num) {
            super( num);
            this.num =  num;
        }
        @Override
        public String toString() {
            return "" + num;
        }
    }
    class IntInteger extends AbsInteger {
        int num;
        @Override
        public int intValue(){
            return  num;
        }
        @Override
        public byte byteValue() {
            return (byte) num;
        }
        @Override
        public short shortValue(){
            return (short) num;
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
