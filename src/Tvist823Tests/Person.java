package Tvist823Tests;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

class Person {
    static class Child1 {                     //Создайте класс Tvist823Tests.Person, а внутри него 2 класса

        String hello() {                       // вложенный класс Child1
            return "привет";                   //  внутренний класс Child2
        }
    }                                          //  У каждого класса, Child1 и Child2 создайте метод String hello()

    //  У Child1 String hello() должен вернуть "привет"
    // У Child2 String hello() должен вернуть "servus"

    class Child2 {
        String hello() {
            return "servus";
        }
    }
    void dequeueTest () {
        ArrayDeque deque = new ArrayDeque<>();
    }
    void pqTest() {
        PriorityQueue pQueue = new PriorityQueue<>();
    }
    public static void main(String[] args) {
       /* ArrayDeque deque = new ArrayDeque<>();

            for (int i = 0; i <= 10; i++) {
                deque.offer(i);
                if (i % 2 == 0)
                    deque.poll();*/

                PriorityQueue pQueue = new PriorityQueue<>();
                pQueue.offer(10);
                pQueue.offer(1);
                pQueue.offer(9);
                pQueue.offer(3);
                System.out.println(pQueue);
            }


            //System.out.println(deque);
        }
   // }
