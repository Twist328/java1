package ru.progwards.java1.lessons.io1;

import java.io.IOException;

public class Test37 {
    public Integer sqr(Integer n) {
        try {
            int x = n;
            int result = 0;
            result =  x * x;
            return result;

        } catch (NullPointerException e) {

        } finally {
            if (n == null)
            return -1;
        }
        return n;
    }

    public static String test(String filename) throws IOException {
        if (filename == null) {
            return "java.io.IOException File not found\n";
        } else {
            return "File processing";

        }

    }

    public static void main(String[] args) throws IOException {

        System.out.println(new Test37().test(null));
        System.out.println(new Test37().sqr(null));
    }
}

