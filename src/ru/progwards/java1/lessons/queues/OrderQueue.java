package ru.progwards.java1.lessons.queues;

import java.util.Comparator;
import java.util.PriorityQueue;

public class OrderQueue {

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

