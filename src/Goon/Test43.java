package Goon;

import java.sql.Array;
import java.util.*;

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
            if (iter.next().contains("на"))
                iter.remove();
        System.out.println(TEXT);
        System.out.println(wordSet);
        System.out.println(wordSet.size());
        //__________________________________________________________________________________________//
        Set<Integer> fiboTreeSet1000 = new TreeSet<>();

        fiboTreeSet1000.add(0);
        fiboTreeSet1000.add(987);
        fiboTreeSet1000.add(1);
        fiboTreeSet1000.add(5);
        fiboTreeSet1000.add(3);
        fiboTreeSet1000.add(8);
        fiboTreeSet1000.add(21);
        fiboTreeSet1000.add(13);
        fiboTreeSet1000.add(55);
        fiboTreeSet1000.add(34);

        for (int num : fiboTreeSet1000)

            System.out.println(num + " " + (fiboTreeSet1000.contains(num) ? "Фибо" : ""+"\n"));
//__________________________________________________________________________________________//
        Set<Integer> fiboSet1000a = new TreeSet<Integer>();

        fiboSet1000a.add(0);
        fiboSet1000a.add(987);
        fiboSet1000a.add(1);
        fiboSet1000a.add(5);
        fiboSet1000a.add(3);
        fiboSet1000a.add(8);
        fiboSet1000a.add(21);
        fiboSet1000a.add(13);
        fiboSet1000a.add(55);
        fiboSet1000a.add(34);
        fiboSet1000a.add(144);
        fiboSet1000a.add(89);
        fiboSet1000a.add(377);
        fiboSet1000a.add(233);
        fiboSet1000a.add(2);
        fiboSet1000a.add(610);

        System.out.println(fiboSet1000a);

        for (int i = 0; i < 1000; i++) {

            System.out.println(i+"  "+ (fiboSet1000a.contains(i) ? "ДА!!!!" : ""));


        }
    }
}
