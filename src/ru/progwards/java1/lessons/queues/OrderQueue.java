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
    Comparator<Order> orDerComparator = new Comparator<Order>() {
        @Override
        public int compare(Order o1, Order o2) {

            int ord1 = ((int) o1.getSum() - 1) / 10000 + 1;

            if (ord1 < 1)
                ord1 = 1;
            else if (ord1 > 3)
                ord1 = 3;

            int ord2 = ((int) o2.getSum() - 1) / 10000 + 1;

            if (ord2 < 1)
                ord2 = 1;
            else if (ord2 > 3)
                ord2 = 3;

            if (ord1 == ord2)
                return o1.getNum() - o2.getNum();
            return ord2 - ord1;
        }
    };


    PriorityQueue<Order> queueP = new PriorityQueue<Order>(20, orDerComparator);

    public void add(Order order) {
        queueP.add(order);
    }

    public Order get() {
        return queueP.poll();
    }

    public Order getNum() {
        return queueP.poll();
    }
};

