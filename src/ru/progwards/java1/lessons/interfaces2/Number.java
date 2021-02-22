package ru.progwards.java1.lessons.interfaces2;

import java.io.IOException;

import java.util.*;

public  class Number implements Comparable {

    Number num;
    protected Number num2;

    public Number() {

        this.num = num2;
    }

    @Override
    public int compareTo(Object obj) {
        Number entry = (Number) obj;

        int result = this.num.compareTo(entry.num);
        if(result != 0) {
            return result;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "[num=" + this.num + "]";
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


    public static void main(String[] args) throws IOException {


        long[] a = new Random().longs(10, -10, 10).toArray();
        Arrays.sort(((long[]) a));
        System.out.println(Arrays.toString(((long[]) a)));
    }


}
   /* @Override
    public int compareTo(Number o) {
        this.num  -(Number)o;
        return this.num.compareTo(o);
    }
}*/

/*  @Override
    public int compareTo(Number o) {

       // @Override
       //    public int compareTo(Number o) {
       //        o = (Number) num;
       //        return this.num.compareTo(o.num);

    //}
//}*/










