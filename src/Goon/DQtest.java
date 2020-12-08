package Goon;

import java.util.ArrayDeque;
import java.util.Arrays;

public class DQtest {

    static int sumLastAndFirst(ArrayDeque<Integer> deque) {
        if (deque.isEmpty())
            return 0;
        int sum = deque.peekLast() + deque.peekFirst();
        return sum;
    }

    public static void main(String[] args) {

        Integer a[] = {889, 19, 22, 19};
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>(Arrays.asList(a));
        int res = sumLastAndFirst(deque);
        System.out.println(sumLastAndFirst(deque));
    }
}



