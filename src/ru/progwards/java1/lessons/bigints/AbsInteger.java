package ru.progwards.java1.lessons.bigints;

public abstract class AbsInteger {

    int num;

    public static void main(String[] args) {

        AbsInteger num1 = new IntInteger((int) 258);
        AbsInteger num2 = new ShortInteger((short) 10);

        int a = num1.intValue();
        int b = num2.intValue();
        int sum = (a + b);
        System.out.println(sum);
    }
    public AbsInteger() {
    }
    public  int intValue() {
        return num;
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        int a = num1.intValue();
        int b = num2.intValue();
        return new IntInteger((int)a+b);
    }
    public short shortValue(){
        return (short) num;
    }

    public byte byteValue(){
        return (byte) num;
    }
}

    class ByteInteger extends AbsInteger {
        byte num;

        public ByteInteger(byte num) {
            super();

            this.num = num;
        }
        public ByteInteger(short num) {
        }
        @Override
        public byte byteValue() {
            return num;
        }
        @Override
        public int intValue() {
            return num;
        }
        @Override
        public String toString() {
            return "" + num;
        }

        static AbsInteger add(AbsInteger num1, AbsInteger num2) {
            num1 = num1;
            num2 = num2;
            int a = num1.byteValue();
            int b = num2.byteValue();

            return new ByteInteger((byte)(a + b));
        }
    }
    class ShortInteger extends AbsInteger {
        short num;

        public ShortInteger(short num) {
            super();
            this.num = num;
        }
        @Override
        public short shortValue() {
            return num;
        }
        @Override
        public int intValue() {
            return num;
        }
        @Override
        public String toString() {
            return "" + num;
        }
        static AbsInteger add(AbsInteger num1, AbsInteger num2) {
            num1 = num1;
            num2 = num2;
            int a = num1.shortValue();
            int b = num2.shortValue();

            return new ShortInteger((short)(a + b));
        }
    }

    class IntInteger extends AbsInteger {
        int num;

        public IntInteger(int num) {
            super();
            this.num = num;
        }
        @Override
        public int intValue() {
            return num;
        }

        @Override
        public String toString() {
            return "" + num;
        }

        static AbsInteger add(AbsInteger num1, AbsInteger num2) {
            num1 = num1;
            num2 = num2;
            int a = num1.intValue();
            int b = num2.intValue();

            return new IntInteger(a + b);

        }
    }
//length
// if(res<= -128|res<=127) {
//return new ByteInteger((byte) res);
//}else                                                       //for (int i = res; i > 127 ; i++) {
// if (res<= -128|res <=-32768|res >127|res <=32767){
// return new ShortInteger((short) res);
// }else
//return new IntInteger(res);
