package ru.progwards.java1.lessons.interfaces2;

import java.io.IOException;
import java.util.*;


public class ArraySort extends Number {

    private static Number num;


    //public ArraySort() {
    //super();
    //}

    public static void sort(Comparable<Number>[] a) {


        Comparable<Number> tmpValue;
        for (int i = a.length - 1; i >= 0; i--) {
            // найдем в остатках максимальный
            for (int j = 0; j < i; j++) {
                if (a[j].compareNumber(a[i])==(CompareResult.GREATER)) {
                    tmpValue = a[i];
                    a[i] = a[j];
                    a[j] = tmpValue;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {


        Comparable<Number>[] a = new Comparable[2];
       // a[0] = new Comparable(11);
       // a[1] = new Comparable(22);
       // new ArraySort().sort(a);
        // Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }

    @Override
    public int compareTo(Number o) {
        return this.compareTo(o);



    }

}






