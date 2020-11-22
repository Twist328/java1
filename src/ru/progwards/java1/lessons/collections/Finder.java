package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Finder {


    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        ArrayList<Integer> list = (ArrayList<Integer>) numbers;
        List<Integer> res = new ArrayList<>();
        res.add(list.get(0));
        res.add(list.get(1));
        Integer sum = list.get(0) + list.get(1);
        int indnum1 = 0;
        int indnum2 = 1;
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) + list.get(i + 1) < sum) {
                sum = list.get(i) + list.get(i + 1);
                res.set(0, list.get(i));
                res.set(1, list.get(i + 1));
                indnum1 = i;
                indnum2 = i + 1;
            }
        }
        res.set(0, indnum1);
        res.set(1, indnum2);
        return res;
    }

    public static Collection<Integer> findLocalMax(Collection<Integer> numbers) {
        ArrayList<Integer> list = (ArrayList<Integer>) numbers;
        List<Integer> result = new ArrayList();
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i - 1) && list.get(i) > list.get(i + 1)) {
                result.add(list.get(i));
            }
        }
        return result;
    }

    public static void main(String[] args) throws ClassCastException {
        Finder numbers = new Finder();
        List<Integer> res = new ArrayList<>();
        int index1 = 0;
        int index2 = 1;
        for (int i = 0; i < 2; i++)
            res.add((index1 + index2));
        res.set(0, index1);
        res.set(1, index2);

        System.out.println(res);

        List<Integer> list= new ArrayList();
        List<Integer> result = new ArrayList();
        for (Integer e : new Integer[]{90, 300, 12, 6, 3, 9, 21}) list.add(e);
        new Finder().findLocalMax(list);
        System.out.println(list);

            }
        }

