package ru.progwards.java1.lessons.interfaces2;

import java.util.Comparator;

public class Number {


    public Number mul(Number num) {//, который будет возвращать произведение содержимого класса на num.
        return null;
    }

    public Number div(Number num) {//, который будет возвращать частное от деления содержимого класса на num.
        return null;
    }

    public Number newNumber(String strNum) {//, который будет возвращать новый экземпляр класса с указанным значением.
        return null;
    }

    public int toInt() {
        return 0;
    }


    @Override
    public String toString() {
        return null;
    }


    Comparator<Number> comparator = new Comparator<Number>() {
        @Override
        public int compare(Number o1, Number o2) {
            return 0;
        }

    };

}


