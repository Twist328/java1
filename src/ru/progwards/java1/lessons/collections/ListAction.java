package ru.progwards.java1.lessons.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/*Напишите метод с сигнатурой public List<Integer> listAction(List<Integer> list), который выполняет следующие действия:
        удаляет минимальный элемент коллекции
        по индексу 0 добавляет число равное количеству элементов
        по индексу 2 добавляет максимальный элемент из list
        возвращает list как результат метода
        */
public class ListAction {
    public static List<Integer> listAction(List<Integer> list) {
        //if (list == null) return null;
       // if (list.size() == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<Integer>();
        result.addAll(list);
        result.remove(Collections.min(result));
        //Collections.sort(result);
        System.out.println(result);
        result.add(0, result.size());
        System.out.println(result);
        result.add(2, Collections.max(result));
        System.out.println(result);
        return result;
    }
    public static List<Integer> listAction2(List<Integer> list) {
        if (list == null) return null;
        if (list.size() == 0) return new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        result.addAll(list);
        int minIdx = 0, minVal = Integer.MAX_VALUE, maxVal = Integer.MIN_VALUE, lastIdx = result.size() - 1;
        for (int i = lastIdx; i >= 0; i--) {
            int v = result.get(i);
            if (v > maxVal) maxVal = v;
            if (v < minVal) {
                minVal = v;
                minIdx = i;
            }
        }
        result.remove(minIdx);
        result.add(0, lastIdx);
        result.add(2, maxVal);
        return result;
    }
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{5, 4, 3, 2, 1});
        //System.out.println(list);
        System.out.println(new ListAction().listAction(list));
        System.out.println("/------------------------------------------------/");
        System.out.println(list);
        System.out.println(new ListAction().listAction2(list));
    }
}
