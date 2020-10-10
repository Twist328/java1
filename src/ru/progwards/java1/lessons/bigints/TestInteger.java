package ru.progwards.java1.lessons.bigints;

public class TestInteger {
    public static void main(String[] args) {

        AbsInteger num1 = new IntInteger( 258);
        AbsInteger num2 = new ShortInteger((short) 258);

        int a = num1.intValue();
        int b = num2.intValue();
        int sum = (a + b);
        System.out.println(sum);
    }
}


