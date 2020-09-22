package ru.progwards.java1.lessons.interfaces;

import java.util.Arrays;

public class ArraySort {

    public static void main(String[] args) {

        CompareWeight[] a = {new Duck(55.0), new Animal(49.0), new Cow(300.0),
                new Hamster(3.3)};

        ArraySort.sort(a);

        System.out.println(Arrays.toString(a));
    }
    public static void sort(CompareWeight[] a) {
        for (int i = 0; i < a.length; i++) {
            CompareWeight min = a[i];
            int minId = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j].compareWeight((min)) == CompareWeight.CompareResult.LESS) {
                    min = a[j];
                    minId = j;
                }
            }
            CompareWeight temp = a[i];
            a[i] = min;
            a[minId] = temp;
        }
    }
}


