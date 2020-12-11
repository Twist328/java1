package ru.progwards.java1.lessons.queues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderQueue {
/*
2.5 Создать класс OrderQueue
2.6 Разместить в нем очередь с приоритетом
2.7 Создать метод, public void add(Order order), размещающий заказы в очередь с приоритетом, разбивая их по 3-м классам
3 - заказы до 10000 руб включительно
2 - заказы от 10000 до 20000 руб включительно
1 - заказы от 20000 руб
2.8 Создать метод, public Order get(), возвращающий первый заказ в очереди для обслуживания.
В начале обслуживаются заказы класса 1, потом 2, потом 3. Внутри каждого класса заказы должны
обслуживаться в порядке поступления. Метод не выбрасывает исключения, возвращает null в случае пустой очереди.
Продумать, и, при необходимости, добавить в классы нужные методы, для того, чтобы реализовать эту задачу.
*/

    Comparator<Order> orderComparator = new Comparator<Order>() {
        @Override
        public int compare(Order c1, Order c2) {
            int cl1 = ((int) c1.getSum() - 1) / 10000 + 1;
            if (cl1 < 1) cl1 = 1;
            else if (cl1 > 3) cl1 = 3;
            int cl2 = ((int) c2.getSum() - 1) / 10000 + 1;
            if (cl2 < 1) cl2 = 1;
            else if (cl2 > 3) cl2 = 3;
            if (cl1 == cl2) return c1.getNum() - c2.getNum();
            return cl2 - cl1;
        }
    };

    PriorityQueue<Order> queue = new PriorityQueue<Order>(16, orderComparator);

    public void add(Order order) {
        queue.add(order);
    }

    public Order get() {
        return queue.poll();
    }

    public Order getNum() {
        return queue.poll();
    }
}