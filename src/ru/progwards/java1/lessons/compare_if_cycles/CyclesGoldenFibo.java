package ru.progwards.java1.lessons.compare_if_cycles;

public class CyclesGoldenFibo {


    public static void main(String[] args) {
        System.out.println(containsDigit(0, 0));

        System.out.println(fiboNumber(1));
        System.out.println(fiboNumber(2));
        System.out.println(fiboNumber(3));
        System.out.println(fiboNumber(4));
        System.out.println(fiboNumber(5));
        System.out.println(fiboNumber(6));
        System.out.println(fiboNumber(7));
        System.out.println(fiboNumber(8));
        System.out.println(fiboNumber(9));
        System.out.println(fiboNumber(10));
        System.out.println(fiboNumber(11));
        System.out.println(fiboNumber(12));
        System.out.println(fiboNumber(13));
        System.out.println(fiboNumber(14));
        System.out.println(fiboNumber(15));

        System.out.println(isGoldenTriangle(3, 3, 2));
        System.out.println(isGoldenTriangle(3, 3, 2));
        System.out.println(isGoldenTriangle(5, 5, 3));
        System.out.println(isGoldenTriangle(8, 8, 5));
        System.out.println(isGoldenTriangle(21, 13, 13));
        System.out.println(isGoldenTriangle(21, 21, 13));
        System.out.println(isGoldenTriangle(21, 21, 34));
        System.out.println(isGoldenTriangle(55, 89, 55));
        System.out.println(isGoldenTriangle(89, 89, 55));

    }

    public static boolean containsDigit(int number, int digit) {
        if (number == 0 && digit == 0) {
            return true;
        }
        while (number > 0) {
            if (number % 10 == digit) {
                return true;

            }
            number /= 10;
        }
        return false;
    }


    public static int fiboNumber(int n) {

        if (n == 0) return 0;
        else if (n == 1) return 1;
        else
            return fiboNumber(n - 1) + fiboNumber(n - 2);
    }

    public static boolean isGoldenTriangle(int a, int b, int c) {

        while (a == (c) / 1.61803 && a < c && a < b) {
            while (b == (c) / 1.61803 && b < c && a > b) {
                while (c == (a) / 1.61803 && c < a && b > c) {
                }
            }
        }
        if (b == c && a < c && a < b) return Boolean.parseBoolean("true");
        if (a == c && b < c && a > b) return Boolean.parseBoolean("true");
        if (a == b && c < a && b > c) return Boolean.parseBoolean("true");
        else

            return Boolean.parseBoolean("false");


    }

}







