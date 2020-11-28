package Goon;

import java.util.Iterator;
import java.util.TreeSet;

public class Test8777 {

    public static void doTreeSet() {
        TreeSet<Integer> treeSet = new TreeSet<>();
    }

    public static void main(String[] args) {

        Test8777 test8777 = new Test8777(); // Обратная итерация множества
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
        //______________________________________________________//
        TreeSet<Integer> treeSet1 = new TreeSet<>();// итерирование трисет по возрастающей
        treeSet1.add(19);
        treeSet1.add(12);
        treeSet1.add(15);
        treeSet1.add(10);

        String s1 = "";
        Iterator<Integer> iterator1 = treeSet1.iterator();
        while (iterator1.hasNext())
            s1 += iterator1.next();
        System.out.println(s1);
    }
}





