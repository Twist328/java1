package ru.progwards.java1.lessons.interfaces2;

import java.io.IOException;

import java.util.*;
import java.util.stream.IntStream;


public class ArraySort extends Number {

    private static Number num;

    public ArraySort(int[] a) {
    }


    //public ArraySort() {
    //super();
    //}

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
               // Arrays.sort(a);
            }
        }
    }

    public static void main(String[] args) throws IOException {


        // int[] a=(new int[0]);
        Comparable<Number>[] a = new Comparable[]{5,258,8,0};



            sort(a);
            System.out.println(Arrays.toString(a));
        }


    @Override
    public int compareTo(Number o) {
        o = (Number) num;
        return this.num.compareTo(o.num);
    }
}
















