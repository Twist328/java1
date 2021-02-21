package ru.progwards.java1.lessons.interfaces2;

import java.io.IOException;

import java.util.*;

public class Number implements Comparable<Number> {

    Number num;

    public Number() {
        this.num = num;
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


    @Override
    public int compareTo(Number o) {
        if (this.num.compareTo(o.num) == -1) {
            return -1;
        }else if (this.num.compareTo(o.num) == 1) {
            return 1;
        }else
            return 0;
    }


    public static void main(String[] args) throws IOException {


        long a []= {89,58,34};
        Arrays.sort(((long[]) a));
        System.out.println(Arrays.toString(((long[]) a)));
    }
}









