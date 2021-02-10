package ru.progwards.java1.lessons.interfaces2;



public class Number implements Comparator {


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


    public Number() {
        super();
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public int compare(Object o1, Object o2) {
        return compare(newNumber((String) o1).newNumber((String) o2));
    }

    private int compare(Number newNumber) {
        return 0;
    }

}



