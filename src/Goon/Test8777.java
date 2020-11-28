package Goon;

import java.util.Iterator;
import java.util.TreeSet;

public class Test8777 {

    public static void doTreeSet() {
        TreeSet<Integer> treeSet = new TreeSet<>();
    }

    public static void main(String[] args) {

        Test8777 test8777 = new Test8777();
        TreeSet<Integer> treeSet = new TreeSet<>();

        treeSet.add(9);
        treeSet.add(1);
        treeSet.add(5);
        treeSet.add(2);
        treeSet.add(4);
        treeSet.add(8);

        String s = "";
        Iterator<Integer> iterator = treeSet.descendingIterator();

        while (iterator.hasNext())
            s += iterator.next();

            System.out.println(s);

        }
    }




