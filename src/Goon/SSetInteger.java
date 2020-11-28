package Goon;

import java.util.*;

/*Реализуйте метод,с сигнатурой public Set<Integer> a2set(int[] a), который преобразует массив в множество*/
public class SSetInteger {
    public static Set<Integer> a2set(int[] a) {

        Set<Integer> set = new HashSet<>();
        for (int i : a) set.add(i);
        return set;

    }



    public static void main(String[] args) {

        int[] a = new int[]{0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987};
        System.out.println(Arrays.toString(a));
        Set<Integer> set = new SSetInteger().a2set(a);
        System.out.println(a2set(a));
    }
    //_____________________________________________________________________________________//

    }




