package ru.progwards.java1.lessons.queues;

public class Order {
    static int num1 = 1; // номер по порядку
    private double sum; // сумма заказа
    private int num; // номер по порядку

    public Order(double sum) {
        this.sum = sum;
        this.num = num1++;
    }

    public double getSum() {
        return sum;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return sum + "(" + num + ")";
    }
}


