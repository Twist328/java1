package Tvist328;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Lesson12 {
    public static void iterator3(ListIterator<Integer> iterator) {
/*Напишите метод с сигнатурой public void iterator3(ListIterator<Integer> iterator)
который заменяет значение каждого элемента, которое кратно 3 на значение его индекса.
*/
        while (iterator.hasNext()) {
            int n = iterator.next();
            if (n % 3 == 0) {
                iterator.set(iterator.nextIndex() - 1);
            }
        }
    }

    public Lesson12() {

    }

    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        for (Integer e : new Integer[]{90, 300, 12, 6, 3, 9, 21}) list.add(e);
        iterator3(list.listIterator());
        System.out.println(list);

        List<Integer> linkedList = new LinkedList();
        for (int i = 0; i < 5; i++)
            linkedList.add(i);

        Lesson12 lesson12 = new Lesson12();

        /*for (ListIterator<Integer> listIterator = linkedList.listIterator(); listIterator.hasNext(); ) {   ЭТО ВАРИАНТ РАБОЧИЙ ИЗ ТЕСТА 12 LESSON
            Integer n = listIterator.next();
            if (n % 2 != 0)
                listIterator.remove();
            else
                listIterator.add(n * 2);

            System.out.print(linkedList);*/

            for (ListIterator<Integer> listIterator = linkedList.listIterator(); listIterator.hasNext(); ) {
                Integer n = listIterator.next();
                if (n % 2 != 0)
                    listIterator.set(n * 2);
                //return n;
                System.out.print(linkedList);

            }
        }
    }
