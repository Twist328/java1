package ru.progwards.java1.lessons.sets;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
//Укажите, что будет выведено в результате выполнения метода
public class SetsTestIterator {
    public static void wSetTest() {
        String TEXT = "на дворе трава на траве дрова не руби дрова на траве двора";
        Set<String> wordSet = new HashSet<>(Arrays.asList(TEXT.split(" ")));

        Iterator<String> iter = wordSet.iterator();
        while (iter.hasNext())
            if (iter.next().contains("ра"))
                iter.remove();

        System.out.println(wordSet/*.size()*/); //можно и кол-во элементов узнать
    }

    public static void main(String[] args) {
        wSetTest();
       // System.out.println();

    }

}
