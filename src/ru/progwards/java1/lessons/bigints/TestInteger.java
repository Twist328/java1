package ru.progwards.java1.lessons.bigints;

import static ru.progwards.java1.lessons.bigints.AbsInteger.add;

public class TestInteger {
    public static void main(String[] args) {

        AbsInteger num1 = new IntInteger( 33000);
        AbsInteger num2 = new ShortInteger((short) 32700);
        AbsInteger num3 = new ShortInteger((short) 20588);
        AbsInteger num4 = new ByteInteger((byte) -126);
        AbsInteger num5 = new ByteInteger((byte) -126);
        AbsInteger num6 = new IntInteger( 100000);


        int a = num1.intValue();
        int b = num2.intValue();
        int a1 = num3.intValue();
        int b1 = num4.intValue();
        int a2 = num5.intValue();
        int b2 = num6.intValue();

        AbsInteger result  =  add(num1,num2);


        int sum = (a + b);
        int sum1 = (a1 + b1);
        int sum2 = (a2 + b2);

        System.out.println(result);
        System.out.println(sum);
        System.out.println(sum1);
        System.out.println(sum2);
    }
}


