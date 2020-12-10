package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {

    public static void main(String[] args) throws IndexOutOfBoundsException {

        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println("\n" + "   " + " " + " ДО СОРТИРОВКИ:");
        for (Integer e : new Integer[]{50, 600, 400, 10, -257, 15, 5, 0, 6, 7, 8, 9, 10, 15, 12, -13, -14,-500})
            list.add(e);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        mySort(list);
        System.out.print("\n" +" "+" "+ "ПОСЛЕ СОРТИРОВКИ:" + "\n");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        minSort(list);
        System.out.println("\n" + "MinList: " + list);

    }


    public static void mySort(Collection<Integer> data) {  //ПЕРЕДЕЛАТЬ ARRAYSORT В МЕТОД СОРТИРОВКИ КОЛЛЕКЦИЙ
        //НЕ ИСПОЛЬЗУЯ ВСТРОЕННЫЕ МЕТОДЫ СОРТИРОВКИ СПИСКОВ МНОЖЕСТВ ОЧЕРЕДЕЙ И КОЛЛЕКЦИЙ;

        ArrayList<Integer> list = (ArrayList<Integer>) data;
        Iterator<Integer> iter = list.iterator();

        int temp = 0;
        while (iter.hasNext()) {
            Integer intsum = iter.next();

            Iterator<Integer> iterator = list.iterator();
            int intbum;

            for (int i = temp; i >= 0; i--) iterator.next();
            int bemp = temp + 1;

            while (iterator.hasNext()) {
                intbum = iterator.next();

                if (intsum.compareTo(intbum) == 1) { //значение разворачивает коллекцию
                    Collections.swap((List) data, temp, bemp);
                    intsum = intbum;
                }
                bemp++;
            }
            temp++;
        }
        //Collections.reverse(list);//встроенный метод использовать нельзя..
    }

    public static void minSort(Collection<Integer> data) {

        ArrayList<Integer> list;
        list = (ArrayList<Integer>) data;
        TreeSet<Integer> set = new TreeSet<Integer>();

        if (list.size() > 0) {
            Integer minList = Collections.min(list);
            set.add(minList);
            list.remove(minList);

        }
        data.clear();
        while (list.isEmpty()) {
            data.addAll(set);
        }
    }
}








