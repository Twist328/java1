package ru.progwards.java1.lessons.interfaces2;

import java.io.IOException;

import java.util.*;

public  class Number implements Comparable<Number> {

    Number num;
    protected Number num2;

    public Number() {

        this.num = num2;
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


        long a[] = {89, 58, 34};
        Arrays.sort(((long[]) a));
        System.out.println(Arrays.toString(((long[]) a)));
    }

    @Override
    public int compareTo(Number num2) {
        int s = this.num.compareTo(num2.num);
        if (s != 0) {
            return s;
        }else
        return 0;
    }
}

/*  @Override
    public int compareTo(Number o) {

       // return this.num-o.strNum ;

    //}
//}*/










