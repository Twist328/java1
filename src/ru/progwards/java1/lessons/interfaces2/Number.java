package ru.progwards.java1.lessons.interfaces2;


import java.util.Arrays;
import java.util.Random;

public class Number<NewNumber> implements Comparable<NewNumber> {

    Number num;
    NewNumber strNum;

    @Override
    public String toString() {
        return "Number{" +
                "strNum=" + strNum +
                '}';
    }

    public Number(NewNumber strNum) {
        this.strNum = strNum;
    }



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

    void sorted(int[] strNum){
        strNum = new Random().ints(10, -10, 100).sorted().toArray();
       // System.out.println(Arrays.toString(strNum));
    }


    public static void main(String[] args) {
        int[] b = new Random().ints(10, -10, 100).toArray();
        new Number().sorted(b);
        System.out.println(Arrays.toString(b));
    }


    @Override
    public int compareTo(NewNumber o) {
        return 0;
    }
}
