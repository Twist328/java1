package ru.progwards.java1.lessons.interfaces2;



public class Number implements Comparator {

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

    public int toInt() {
        return 0;
    }


    public Number(Number num) {
        this.num=num;
    }

    @Override
    public String toString() {
        return null;
    }


    @Override
    public boolean compare(Object o1, Object o2) {
        return compare(o1,o2);
    }
}






