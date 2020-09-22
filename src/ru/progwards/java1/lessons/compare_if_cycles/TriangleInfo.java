package ru.progwards.java1.lessons.compare_if_cycles;

public class TriangleInfo {
    public static void main(String[] args) {
        System.out.println(isTriangle(15, 20, 30));
        System.out.println(isRightTriangle(4, 1, 5));
        System.out.println(isIsoscelesTriangle(50, 50, 50));
    }

    public static boolean isTriangle(int a, int b, int c) {


        if ((a < b + c) && (b < a + c) && (c < a + b)) return Boolean.parseBoolean("true");
        else
            return Boolean.parseBoolean("false");


    }

    public static boolean isRightTriangle(int a, int b, int c) {
        if (a <= 0) return Boolean.parseBoolean("false");
        if (b <= 0) return Boolean.parseBoolean("false");
        if (c <= 0) return Boolean.parseBoolean("false");
        if (a * a == (b * b) + (c * c)) return Boolean.parseBoolean("true");
        if (b * b == (a * a) + (c * c)) return Boolean.parseBoolean("true");
        if (c * c == (b * b) + (a * a)) return Boolean.parseBoolean("true");

        return Boolean.parseBoolean(String.valueOf(0));
    }

    public static boolean isIsoscelesTriangle(int a, int b, int c) {
        if (a <= 0) return Boolean.parseBoolean("false");
        if (b <= 0) return Boolean.parseBoolean("false");
        if (c <= 0) return Boolean.parseBoolean("false");
        if (a == b) return Boolean.parseBoolean("true");
        if (b == c) return Boolean.parseBoolean("true");
        if (c == a) return Boolean.parseBoolean("true");

        return Boolean.parseBoolean(String.valueOf(0));
    }


}


