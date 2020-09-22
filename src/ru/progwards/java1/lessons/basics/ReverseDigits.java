package ru.progwards.java1.lessons.basics;

public class ReverseDigits {

    public static int reverseDigits(int number) {
        int a, b;
        a = (number % 10) * 100;
        number /= 10;
        b = number % 10 * 10;
        number /= 10;
        return a + b + number;

    }

    public static void main(String[] args) {
        System.out.println(reverseDigits(345));
    }
}
