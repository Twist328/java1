package ru.progwards.java1.lessons.collections;

import java.util.*;

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

        for (Integer e : list){
            if (e < tmp) result.add(e);


        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(Integer e:new Random().ints(50,-10,50).toArray()) list.add(e);

        System.out.println(filter((List<Integer>) list));

    }
}
