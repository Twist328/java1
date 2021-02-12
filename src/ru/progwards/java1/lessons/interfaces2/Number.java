package ru.progwards.java1.lessons.interfaces2;

public class Number implements Comparable<Number> {

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

    @Override
    public String toString() {

        return null;
    }

    @Override
    public int compareTo(Number o) {
        if (this.num.compareTo(o.num) == 0) {
            return 0;
        } else if (this.num.compareTo(o.num) > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}