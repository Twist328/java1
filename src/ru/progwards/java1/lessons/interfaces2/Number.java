package ru.progwards.java1.lessons.interfaces2;

import ru.progwards.java1.lessons.arrays.ArraySort;

import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.Random;

public class Number implements Comparable<Number> {

    Number num;



    public Number() {

    }

    public Number(int i) {
    }


    public Number mul(Number num) {//, который будет возвращать произведение содержимого класса на num.
        return null;
    }

    public Number div(Number num) {//, который будет возвращать частное от деления содержимого класса на num.
        return null;
    }

    public Number newNumber(String strNum) {//, который будет возвращать новый экземпляр класса с указанным значением.
        return null;
    }

    public Number(Number num) {
        this.num = num;
    }

    /*void sorted(int[] strNum) {
        strNum = new Random().ints(10, -10, 100).sorted().toArray();
        System.out.println(Arrays.toString(strNum));
    }*/

   /* @Override
    public int compareTo(Number num) {
        return ((num.num - this.num));*/


    public static void main(String[] args) {
        int[] b = new Random().ints(10, -50, 100).toArray();
        Arrays.sort(b);
        //for (int i : b) {
            System.out.println(Arrays.toString(b));
        }



    @Override
    public int compareTo(Number o) {
        Number num=(Number)o;
        return this.num.compareTo(o.num);

    }

    @Override
    public String toString() {
        return "Number{" +
                "num=" + num +
                '}';
    }
}

