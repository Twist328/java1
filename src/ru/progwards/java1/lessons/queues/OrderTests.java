package ru.progwards.java1.lessons.queues;

import java.util.Collections;
import java.util.TreeSet;
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

public class OrderTests {

    public static void main(String[] args) {

        OrderQueue orderQ = new OrderQueue();
        orderQ.add(new Order(10200.0));
        orderQ.add(new Order(34800.0));
        orderQ.add(new Order(10275.0));
        orderQ.add(new Order(5890.0));
        orderQ.add(new Order(25531.0));
        orderQ.add(new Order(7800.0));
        orderQ.add(new Order(1299.0));
        orderQ.add(new Order(18400.0));
        orderQ.add(new Order(21200.0));
        orderQ.add(new Order(15400.0));
        orderQ.add(new Order(5590.0));
        orderQ.add(new Order(1297.0));
        orderQ.add(new Order(9999.99));

        Order order = orderQ.getNum();

        while (order != null) {

            System.out.println(order);
            order = orderQ.get();

        }
    }
}
