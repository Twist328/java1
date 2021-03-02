package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;

public class Test2 {
    static int addAsStrings(int n1, int n2) {
        String str = String.valueOf(n1);
        String str1 = String.valueOf(n2);
        return Integer.parseInt((str + str1));
    }

    public static void main(String[] args) {
        System.out.println(addAsStrings(1, 2));
        System.out.println(addAsStrings(100, 333));
        System.out.println(addAsStrings(10000000, 55));

        int i = 1;

        switch (i) {
            case 1:
                System.out.print("1");
            case 2:
                System.out.print("2");
                break;
            default:
                System.out.print("3");
        }
    }
}






