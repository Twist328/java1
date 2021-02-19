package ru.progwards.java1.lessons.interfaces2;

import java.io.IOException;
import java.util.*;

public  class Number implements Comparable {

    Number num;

    public Number() {

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

    public static void main(String[] args) throws IOException {
        int[] b = new Random().ints(15, -50, 100).toArray();
        Arrays.sort(b);

        System.out.println(Arrays.toString(b));
    }


    @Override
    public CompareResult compareNumber(Comparable smthHasNumber) {
        return null;
    }

    @Override
    public int compareTo(Number o) {
        return this.num.compareTo(o.num);
    }


}
    /*public int compareTo(Number o) {
        if(this.num == o.num) return 0;
        else
            return (this.num.compareTo( o.num)>0) ? 1 : -1;*/

   /* public int compareTo(Number o) {
        Number num=(Number)o;
        return this.num.compareTo(o.num);*/






