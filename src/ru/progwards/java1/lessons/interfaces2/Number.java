package ru.progwards.java1.lessons.interfaces2;


import java.util.Comparator;

public class Number implements Comparator<Number> {

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
        this.num=num;
    }

    @Override
    public String toString() {
        return null;
    }


    @Override
    public int compare(Number o1, Number o2) {
        return 0;
    }
}








