package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Set;
//Укажите результат выполнения метода
public class FiboSet {
    public static void cset() {
        Set<Integer>  fiboSet1000 =
                Set.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987);
        int sum = 0;
        for (int i = 2; i < 10; i++)
           // System.out.println(i);
            sum += fiboSet1000.contains(i) ? 1 : 0;
        System.out.println(sum);
        System.out.println("/___________________________________________________________________________________/\n");
    }

    //Реализуйте метод,с сигнатурой public Set<Integer> a2set(int[] a), который преобразует массив в множество
    public Set<Integer> a2set(int[] a) {
        Set<Integer> set = new HashSet<>();
        for (int i : a) set.add(i);
        return set;
    }
    public static void main(String[] args) {
        cset();


        int[] a = new int[]{2, 3, 1, 2, 3, 0, 111};
        System.out.println(new FiboSet().a2set(a));
    }
}
