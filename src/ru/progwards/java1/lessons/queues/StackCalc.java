package ru.progwards.java1.lessons.queues;

import java.util.ArrayDeque;

public class StackCalc {

    private ArrayDeque<Double> queue = new ArrayDeque<Double>();

    public void push(double value) {      // положить value на вершину стека
        queue.offerLast(value);
    }

    public double pop() {              // взять (убрать) значение с вершины стека
        return queue.pollLast();
    }

    public void add() {
        if (queue.size() < 2) return; // сложить 2 верхних значения на стеке, результат положить на стек
        queue.offerLast(queue.pollLast() + queue.pollLast());// В итоге в стеке должно быть на один элемент меньше
    }

    public void sub() {                // вычесть верхнее значение на стеке, из следующего по глубине
        if (queue.size() < 2) return; // результат положить на стек. В итоге в стеке должно быть на один элемент меньше
        queue.offerLast(-queue.pollLast() + queue.pollLast());
    }

    public void mul() {
        if (queue.size() < 2) return;                      // умножить 2 верхних значения на стеке, результат положить на стек.
        queue.offerLast(queue.pollLast() * queue.pollLast());// В итоге в стеке должно быть на один элемент меньше
    }

    public void div() {
        if (queue.size() < 2) return;      // поделить на верхнее значение на стеке, следующее по глубине,
        Double result = queue.pollLast();      // результат положить на стек. В итоге в стеке должно быть на один элемент меньше
        queue.offerLast(queue.pollLast() / result);
    }
}


