package Goon;

import java.util.ArrayDeque;

public class TestDeque {
    static ArrayDeque<Integer> array2queue(int[] a) {

        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

        if (a == null) return deque;

        for (int e : a) {

            deque.offer(e);

        }

        return deque;

    }

    public static void main(String[] args) {
        int a[] = {49, 47, 45, 43, 41, 39, 37, 35, 33, 31, 29, 27, 25, 23, 21, 19, 17, 15, 13, 11, 9, 7, 5, 3, 1};
        ArrayDeque<Integer> deque = array2queue(a);
        int a1[] = {0, 0, 0, 3, 9, 27, 6, 36, 216, 9, 81, 729, 12, 144, 1728, 15, 225, 3375, 18, 324, 5832, 21, 441, 9261, 24, 576, 13824, 27, 729, 19683};
        ArrayDeque<Integer> deque1 = array2queue(a1);

        System.out.println(array2queue(a));
        System.out.println(array2queue(a1));
//_____________________________________________________//
        ArrayDeque deque2 = new ArrayDeque<>();

        for (int i = 0; i <= 10; i++) {
            deque2.offer(i);
            if (i % 2 == 0)
                deque2.poll();
        }
        System.out.println(deque2);

    }
}