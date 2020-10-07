package ru.progwards.java1.lessons.bigints;

public class AbsInteger {
    private static boolean num;

   static int sum;

    public AbsInteger(int sum) {

        //this.num=num;
    }


    public static void main(String[] args) {

        AbsInteger num = new AbsInteger(3);
        System.out.println(AbsInteger.add(9,5));
    }

    private static byte add(int i, int i1) {
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        int a = Integer.parseInt(String.valueOf(0));
        int b = Integer.parseInt(String.valueOf(0));

        a= Integer.parseInt(Integer.valueOf(String.valueOf(num1)).toString());
        b= Integer.parseInt(Integer.valueOf(String.valueOf(num2)).toString());
        //int res = Integer.sum(a,b);

        return  new AbsInteger(Integer.sum(a,b));
    }

    //private int sum(AbsInteger num1, AbsInteger num2) {
       // return 0;
    }




    class ByteInteger extends AbsInteger {
        byte num;

        public ByteInteger(int num) {
            super(Integer.sum(a, b));

        }

        @Override
        public String toString() {
            return "" + num;
        }
    }

    class ShortInteger extends AbsInteger {
        short num ;

        public ShortInteger(int num) {
            super(Integer.sum(a, b));
        }

        @Override
        public String toString() {
            return "" + num;

        }
    }

    class IntInteger extends AbsInteger {
        int num ;

        public IntInteger(int num) {
            super(Integer.sum(a, b));
        }

        @Override
        public String toString() {
            return "" + num;
        }
    }


