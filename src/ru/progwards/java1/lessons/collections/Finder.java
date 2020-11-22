package ru.progwards.java1.lessons.collections;

import java.util.*;

public class Finder {


    public static Collection<Integer> findMinSumPair(Collection<Integer> numbers) {
        //найти 2 соседних числа в коллекции сумма которых минимальна, вернуть коллекцию, содержащую индексы этих чисел
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
        //найти локальные максимумы - числа, которые больше соседа справа и слева. Первый и последний элемент коллекции не может являться локальным
        // максимумом, вернуть коллекцию, содержащую значения этих максимумов
        ArrayList<Integer> list = (ArrayList<Integer>) numbers;
        List<Integer> result = new ArrayList();
        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i) > list.get(i - 1) & list.get(i) > list.get(i + 1)) {
                result.add(list.get(i));
            }
        }
        return result;
    }
    public static boolean findSequence(Collection<Integer> numbers) {
        //проверить, содержит ли коллекция все числа от 1 до size(), порядок может быть произвольный
        ArrayList<Integer> list = (ArrayList<Integer>) numbers;
        for (int i = 1; i <= list.size(); i++) {
            int number = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == i) {
                    number++;
                }
            }
            if (number == 0) {
                return false;
            }
        }
        return true;
    }
    public static String findSimilar(Collection<String> names) {
        //найдите максимальное количество повторяющихся подряд элементов. Результат вернуть в виде строки <элемент>:<количество>, например Василий:5.
        // При равенстве максимального количества у разных повторяющихся элементов, вернуть результат для элемента, повторяющаяся последовательность
        // которого началась с наименьшего индекса.
        ArrayList<String> list = (ArrayList<String>) names;

        int number = 0;
        String forename = "";

        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            int tmp = 0;

            for (int j = i; j < list.size(); j++) {
                if (list.get(i).equals(list.get(j))) {
                    tmp++;
                }
                else {
                    break;
                }
            }

            if (str.equals(forename) & number < tmp) {
                number = tmp;
            }

            if (!str.equals(forename) & number < tmp) {
                forename = str;
                number = tmp;
            }

        }

        return forename + ":" + number;
    }


    public static void main(String[] args) throws ClassCastException {
        Finder numbers = new Finder();
        List<Integer> list= new ArrayList();

        for (Integer e : new Integer[]{500,2800,5150,56,83,11}) list.add(e);


        System.out.println(findMinSumPair(list));
        System.out.println(findLocalMax(list));
        System.out.println(findSequence(list));

        List<String> arrayList= new ArrayList();
        for(String s : new String[] {"КОЛЯ","ПЕТЯ","ПЕТЯ","ПЕТЯ","ПЕТЯ", "ПЕТЯ", "ВАСЯ","ВАСЯ", "ВАСЯ","ВАСЯ","ВАСЯ"})arrayList.add(s);
        System.out.println(findSimilar(arrayList));
            }
        }

