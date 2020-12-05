package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Creator {
    public static Collection<Integer> fillEven(int n) { //создать коллекцию и заполнить последовательностью четных возрастающих чисел начиная с 2, количество элементов в коллекции n

        List<Integer> list = new ArrayList<Integer>(n);
        Integer number = 2;
        for (int i = 0; i < n; i++) {
            list.add(number);
            number += 2;
        }

        return list;
    }

    public static Collection<Integer> fillOdd(int n) {  //создать коллекцию и заполнить последовательностью нечетных убывающих чисел, минимальное число в коллекции

        List<Integer> list = new ArrayList<Integer>(n);
        Integer number = 1;
        for (int i = 0; i < n; i++) {
            if (number % 2 != 0)
                list.add(number);
            number += 2;

        }
        Collections.reverse(list);
        return list;
    }

    public static Collection<Integer> fill3(int n) {  //создать коллекцию и заполнить ее тройками чисел. Каждая тройка создается по алгоритму:

        List<Integer>list=new ArrayList<Integer>(n*3);
        int indexnum=0;
        for (int i = 0; i < n; i++) {
            list.add(indexnum);
            list.add((int) Math.pow(indexnum,2));
            list.add((int) (indexnum*indexnum*indexnum));
            indexnum+=3;

        }
        return list;
    }

    public static void main(String[] args) {

        Creator creator = new Creator();
        System.out.println(fillEven(10));
        System.out.println(fillOdd(25));
        System.out.println(fill3(10));
    }
}
