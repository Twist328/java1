package ru.progwards.java1.lessons.sets;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

//Укажите,что будет выведено на консоль при выполнении следующего метода:

public class TestTreeSet {
    public static void doTreeSet() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(19);
        treeSet.add(12);
        treeSet.add(15);
        treeSet.add(10);

        String s = "";
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext())
            s += iterator.next();
        System.out.println(s);
    }
    public static void doTreeSet1() {
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
    public static void iSetTest() {
        Set<Integer> iSet = new HashSet<>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                System.out.println(i+"\n");
                //System.out.println("/_______________________________/");
                System.out.println(j);
                iSet.add(i+j);
            }
        System.out.println(iSet);
        System.out.println(iSet.size());
    }
    public static void main(String[] args) {
        doTreeSet();    /*Судя по результату 1 метод складывает числа как строки, но учитывая treeSet результат
                        неожиданный (не по порядку) т.к. встроена сортировка;*/

        doTreeSet1();  /*Второй метод использует descendingIterator(), (обратный итератор) цифры также складываются
                       как строки, только сортировка в обратном порядке.*/
        iSetTest();
    }
}
