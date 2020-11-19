package Mama;

import java.util.*;

public class Test121 {
    public static void main(String[] args) {

        Collection<Integer> numbers = new ArrayList();

        for (int i = 0; i < 5; i++)
            numbers.add(i);
        numbers.add(Collections.min(numbers));
        System.out.println(numbers);

        Collection<Integer> numbers1 = new ArrayList();
        for(int i=0; i<5; i++)
            numbers1.add(i);
        numbers1.remove(3);
        System.out.println(numbers1);

        Collection<Integer> numbers2 = new ArrayList();
        for(int i=0; i<5; i++)
            numbers2.add(i);
        ((ArrayList)numbers2).add(3, numbers2.size());
        System.out.println(numbers2);

        Collection<Integer> numbers3 = new ArrayList();
        for(int i=0; i<5; i++)
            numbers3.add(i);
        //numbers3.add(3, 5); компилятор выдаст ошибку*/

        List<Integer> list = new ArrayList<>();

        for (Integer e : new Integer[]{40, 300, 0, 4, 3, 1, 2}) list.add(e);
        ((ArrayList) list).add(3, list.size());
        System.out.println((list));

        List<Integer> list1 = new ArrayList<>();
        for (Integer e : new Integer[]{40, 300, 0, 4, 3, 1, 2}) list1.add(e);

        list1.remove(2);
        System.out.println((list1));

        List<Integer> list2 = new ArrayList<>();
        for (Integer e : new Integer[]{40, 300, 0, 4, 3, 1, 2}) list2.add(e);
        list2.add(Collections.min(list2));
        System.out.println(list2);

        List<Integer> list3 = new ArrayList<>();
        for (Integer e : new Integer[]{40, 300, 0, 4, 3, 1, 2}) list3.add(e);
        list3.add(Collections.max(list3));
        System.out.println(list3);

    }

    private static boolean filter(List<Integer> list) {
        return true;
    }
}
