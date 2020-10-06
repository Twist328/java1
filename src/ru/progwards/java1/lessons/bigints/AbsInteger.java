package ru.progwards.java1.lessons.bigints;

public class AbsInteger {
    private static boolean num;

   static int sum;

    public AbsInteger(String num) {

        //this.num=num;
    }





    public static void main(String[] args) {


        System.out.println(num);
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        String a = String.valueOf(0);
        String b = String.valueOf(0);
       // int res = Integer.sum(a,b);
        a=Integer.valueOf(String.valueOf(num1)).toString();
        b=Integer.valueOf(String.valueOf(num2)).toString();
        return new AbsInteger(a+b);
    }

    private int sum(AbsInteger num1, AbsInteger num2) {
        return 0;
    }


}

    class ByteInteger extends AbsInteger {
        byte num;

        public ByteInteger(String num) {
            super(num);

        }

        @Override
        public String toString() {
            return "" + num;
        }
    }

    class ShortInteger extends AbsInteger {
        short num ;

        public ShortInteger(String num) {
            super(num);
        }

        @Override
        public String toString() {
            return "" + num;

        }
    }

    class IntInteger extends AbsInteger {
        int num ;

        public IntInteger(String num) {
            super(num);
        }

        @Override
        public String toString() {
            return "" + num;
        }
    }


