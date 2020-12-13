package ru.progwards.java1.lessons.queues;

public class Order {

    private double sum; // сумма заказа
    private int num; // номер по порядку
    static int bestNum = 1;//порядковый N

    public Order(double sum) {
        this.sum = sum;
        this.num = bestNum++;
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


