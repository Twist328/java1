package Goon;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Test43 {
    public static void iSetTest() {
    }

    public static void wSetTest() {
    }

    public static void cset() {

    }

    public static void main(String[] args) {

        Set<Integer> iSet = new HashSet<>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                iSet.add(i + j);
            }
        System.out.println(iSet.size());
//__________________________________________________________________________________________//
        String TEXT = "на дворе трава на траве дрова не руби дрова на траве двора";
        Set<String> wordSet = new HashSet<>(Arrays.asList(TEXT.split(" ")));
        Iterator<String> iter = wordSet.iterator();
        while (iter.hasNext())
            if (iter.next().contains("ра"))
                iter.remove();
        System.out.println(TEXT);
        System.out.println(wordSet);
        System.out.println(wordSet.size());
        //__________________________________________________________________________________________//
        Set<Integer> fiboSet1000 = Set.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987);
        int sum = 0;
        for (int i = 2; i < 10; i++)
            sum += fiboSet1000.contains(i) ? 1 : 0;
        System.out.println(sum);
//__________________________________________________________________________________________//
        Set<Integer> fiboSet1000a = Set.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987);
        System.out.println(fiboSet1000a);
        for (int i = 0; i < 1000; i++) {
            System.out.print(i + " " + (fiboSet1000a.contains(i) ? "ДА!!!!" : ""));

        }
    }
}


