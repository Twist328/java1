package ru.progwards.java1.lessons.interfaces2;

import java.io.IOException;

import java.util.*;

public class ArraySort extends Number {

    private static Number num;

    public ArraySort(Number num) {
        super(num);
    }


    public static void sort(Comparable<Number>[] a) {

        Comparable<Number> tmpValue = null;
        for (int i = a.length - 1; i >= 0; i--) {
            // найдем в остатках максимальный
            for (int j = 0; j < i; j++) {
                if (a[j]!=(a[i])) {
                    ((tmpValue)) = a[i];
                    a[i] = a[j];
                    a[j] = tmpValue;
                }
                Arrays.sort(a);
            }
        }
    }

    public static void main(String[] args) throws IOException {


        Comparable<Number>[] a = new Comparable[]{Long.valueOf(89),Long.valueOf(58),Long.valueOf(34)};
        sort(a);
        System.out.println(Arrays.toString( a));
    }



    @Override
    public int compareTo(Number o) {
        return super.compareTo(o);
    }
}
















