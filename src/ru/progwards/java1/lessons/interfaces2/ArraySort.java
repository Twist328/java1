package ru.progwards.java1.lessons.interfaces2;

import java.io.IOException;

import java.util.*;

public class ArraySort extends Number {

    private static Number num;

    public ArraySort(Number num) {

    }


    public static void sort(Comparable<Number>[] a) {
                Arrays.sort(a);
            }

    @Override
    public int compareTo(Number obj) {
        return super.compareTo(obj);
    }

    public static void main(String[] args) throws IOException {


        Comparable<Number>[] a = new Comparable[]{Long.valueOf(89),Long.valueOf(58),Long.valueOf(34)};
        sort(a);
        System.out.println(Arrays.toString( a));
    }
    }

















