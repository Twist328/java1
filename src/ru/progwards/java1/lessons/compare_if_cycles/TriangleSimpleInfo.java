package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleSimpleInfo {

    public static int maxSide(int a, int b, int c) {
        if (a == b & a > c) return a;
        if (a == c & c > b) return c;
        if (b == c & b > a) return b;
        if (a == b & b == c) return a;
        if (a > b & a > c) return a;
        if (b > a & b > c) return b;
        if (c > a & c > b) return c;
        return 0;

    }

    public static int minSide(int a, int b, int c) {

        if (a < b & a < c) return a;
        if (b < a & b < c) return b;
        if (c < a & c < b) return c;
        if (a == b & a < c) return a;
        if (a == c & c < b) return c;
        if (b == c & b < a) return b;
        if (a == b & b == c) return a;
        return 0;

    }

    public static boolean isEquilateralTriangle(int a, int b, int c) {

        if (a == b & b == c & a == c) return Boolean.parseBoolean("true");
        if (a < b && a < c && a > b && a > c) return Boolean.parseBoolean("false");
        if (b < c && c < b) return Boolean.parseBoolean("false");

        return Boolean.parseBoolean("0");
    }

    public static void main(String[] args) {
        System.out.println(maxSide(10, 2581, 2581));
        System.out.println(minSide(277, 277, 277));
        System.out.println(isEquilateralTriangle(10, 10, 10));
    }

}
