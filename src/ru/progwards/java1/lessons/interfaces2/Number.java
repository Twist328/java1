package ru.progwards.java1.lessons.interfaces2;

import java.util.*;

public class Number implements Comparable<Number> {

    Number num;

    public Number() {

    }

    public Number(int i, int i1, int i2, int i3, int i4, int i5, int i6) {
    }

    public Number(Object o1, Object o2) {
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

    public static void main(String[] args) {
        int[] b = new Random().ints(15, -50, 100).toArray();
        Arrays.sort(b);

        System.out.println(Arrays.toString(b));
    }


    @Override
    public CompareResult compareNumber(Comparable<Number> smthHasNumber) {
        List<Number> num = (List<Number>) new Number();
        Collections.sort(num, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return 0;
            }
        });
        return null;
    }

}
    /*public int compareTo(Number o) {
        if(this.num == o.num) return 0;
        else
            return (this.num.compareTo( o.num)>0) ? 1 : -1;*/

   /* public int compareTo(Number o) {
        Number num=(Number)o;
        return this.num.compareTo(o.num);*/






