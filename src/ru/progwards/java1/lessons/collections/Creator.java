package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Creator {
    public static Collection<Integer> fillEven(int n) {

        List<Integer> list = new ArrayList<>(n);
        Integer number = 2;

        for (int i = 0; i < n; i++) {
            list.add(number);

            number += 2;

        }
        return list;
    }

    public static Collection<Integer> fillOdd(int n) {

        List<Integer> list = new ArrayList<>(n);
        Integer number = 1;

        for (int i = 0; i < n; i++) {
            if (number % 2 != 0)

                list.add(number);

            number += 2;

        }
        Collections.reverse(list);
        return list;

    }

    public static Collection<Integer> fill3(int n) {

        List<Integer> list = new ArrayList<>(n * 3);
        int indnum = 0;
        for (int i = 0;i < n; i++){
            list.add(indnum);
            list.add((int) Math.pow(indnum,2));
            list.add((int) Math.pow(indnum,3));
            indnum+= 3;
        }
        return list;
    }
        public static void main (String[]args){
        //Creator creator = new Creator();
        System.out.println(fillEven(5));
        System.out.println(fillOdd(55));
            System.out.println(fill3(5));
    }
    }
