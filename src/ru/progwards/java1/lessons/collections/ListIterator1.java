package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/*Напишите метод с сигнатурой public void iterator3(ListIterator<Integer>
iterator) который заменяет значение каждого элемента, которое кратно 3 на значение его индекса.
 */

public class ListIterator1 {
    public static void iterator3(ListIterator<Integer> iterator) {
        while (iterator.hasNext()) {
            int x = iterator.next();
            if (x % 3 == 0) {
                iterator.set(iterator.nextIndex() - 1);
            }
        }
    }
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(new Integer[]{40, 300, 0, 6, 3, 1, 2}));
        iterator3(list.listIterator());
        System.out.println(list);
    }
}
