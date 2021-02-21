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


    public static void main(String[] args) throws IOException {


        long a []= {89,58,34};
        Arrays.sort(((long[]) a));
        System.out.println(Arrays.toString(((long[]) a)));
    }

    @Override
    public int compareTo(Number o) {
        int result=this.num.compareTo(o);
        if (result==0)return 0;
        else
        return result;
    }

    }










