package ru.progwards.java1.lessons.bigints;

public class TestInteger {
    public static void main(String[] args) {

        AbsInteger num1 = new IntInteger( 33000);
        AbsInteger num2 = new ShortInteger((short) 32000);
        AbsInteger num3 = new ShortInteger((short) 20588);
        AbsInteger num4 = new ByteInteger((byte) -126);
        int a = num1.intValue();
        int b = num2.intValue();
        int a1 = num3.intValue();
        int b1 = num4.intValue();
        int sum = (a + b);
        int sum1 = (a1 + b1);
        System.out.println(sum);
        System.out.println(sum1);
    }
}


