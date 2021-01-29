package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*Напишите метод, с сигнатурой public List<Integer> filter(List<Integer> list) который работает по следующему алгоритму
        -суммирует значения всех элементов списка
        -удаляет из списка элементы, значение которых меньше суммы, деленной на 100 (целочисленное деление)
        -возвращает результирующий список*/

public class FilterList {
    public static List<Integer> filter(List<Integer> list) {
        int sum = 0;
        for (int e : list) sum += e;
        System.out.println(sum);
        List<Integer> result = new ArrayList<>();
        int tmp = sum / 100;

        for (Integer e : list) {
            if (e < tmp) result.add(e);


        }
        return result;
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(Integer e:new Integer[]{40, 300, 0, 4, 3, 1, 2}) list.add(e);

        System.out.println(filter(list));
    }
}
