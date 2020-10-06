package ru.progwards.java1.lessons.bigints;

public class AbsInteger {
   int num;
   static int sum;

    public AbsInteger(String num) {

        //this.num=num;
    }

    public AbsInteger(int i, int i1) {
    }

    public static void main(String[] args) {

        AbsInteger num = new AbsInteger(2,5);
        System.out.println(num);
    }

    static  AbsInteger add(AbsInteger num1, AbsInteger num2) {
        String a = Integer.valueOf(num1.num).toString();
        String b = Integer.valueOf(num2.num).toString();
       // int res = Integer.sum(a,b);

        return new AbsInteger(a+b);
    }

    private int sum(AbsInteger num1, AbsInteger num2) {
        return 0;
    }


}

    class ByteInteger extends AbsInteger {
        byte value;

        public ByteInteger(String value) {
            super(value);

        }

        @Override
        public String toString() {
            return "" + value;
        }
    }

    class ShortInteger extends AbsInteger {
        short value ;

        public ShortInteger(String value) {
            super(value);
        }

        @Override
        public String toString() {
            return "" + value;

        }
    }

    class IntInteger extends AbsInteger {
        int value ;

        public IntInteger(String value) {
            super(value);
        }

        @Override
        public String toString() {
            return "" + value;
        }
    }


