package ru.progwards.java1.lessons.queues;

import java.util.*;

public class CollectionsSort {

    public static void main(String[] args) throws IndexOutOfBoundsException {

        ArrayList<Integer> list = new ArrayList<Integer>();
        System.out.println("\n" + "   " + " " + " mySort ДО СОРТИРОВКИ:");
        for (Integer e : new Integer[]{50, 600, 400, 10, -257, 15, 5, 0, -200, 7, 8, 9, 10, 15, 12, -13, -14, -500})
            list.add(e);

        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        mySort(list);
        System.out.print("\n" + " " + " " + "mySort ПОСЛЕ СОРТИРОВКИ:" + "\n");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }

        minSort(list);
        System.out.println("\n" + "MinList: " + list);
        collSort(list);
        System.out.println("\n" + "CollSort: " + list);
        compareSort();
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

        ArrayList<Integer> list = new ArrayList<Integer>(data);
        TreeSet<Integer> set = new TreeSet<Integer>();

        if (list.size() > 0) {
            Integer minList = Collections.min(list);
            set.add(minList);
            list.remove(minList);
        }
        //data.clear();
        while (list.isEmpty()) {
            list.addAll(set);
        }
    }

    public static void collSort(Collection<Integer> data) {

        LinkedList<Integer> intnumbers = new LinkedList<Integer>(data);
        Collections.sort(intnumbers);
        System.out.println("КОЛЛЕКЦИЯ ПОСЛЕ ОКОНЧАНИЯ ПРОГРАММЫ" + " " + "Collection.sort() :  " + intnumbers);
    }

    public static Collection<String> compareSort(){

            //сравнить производительность методов и вернуть их имена, отсортированные в порядке производительности,
            // первый - самый быстрый. В случае равенства производительности первым вернуть "collSort"
            class KomparablTest {
                String name;
                long time;

                KomparablTest(String name, long time) {
                    this.name = name;
                    this.time = time;
                }
            }
            class SortExpByTime implements Comparator<KomparablTest> {
                public int compare(KomparablTest a, KomparablTest b) {
                    return Long.compare(a.time, b.time);
                }
            }
            long t3 = 0;
            long t2 = 0;
            long t1 = 0;
            for (int cnt = 0; cnt < 3; cnt++) {
                Integer[] c1 = new Integer[500];
                Arrays.fill(c1,5);
                int cCnt = 1;
                long time0 = System.nanoTime();
                for (int i = cCnt; i > 0; i--) {
                    ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(c1));
                    mySort(l);
                }
                long time1 = System.nanoTime();
                for (int i = cCnt; i > 0; i--) {
                    ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(c1));
                    minSort(l);
                }
                long time2 = System.nanoTime();
                for (int i = cCnt; i > 0; i--) {
                    ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(c1));
                    collSort(l);
                }
                long time3 = System.nanoTime();
                t1 += time1 - time0;
                t2 += time2 - time1;
                t3 += time3 - time2;
                System.out.println(t1 / 1000 + " " + t2 / 1000 + " " + t3 / 1000);
            }

            ArrayList<KomparablTest> exp = new ArrayList<KomparablTest>(3);
            exp.add(new KomparablTest("mySort", t1));
            exp.add(new KomparablTest("minSort", t2));
            exp.add(new KomparablTest("collSort", t3));
            Collections.sort(exp, new SortExpByTime());

            ArrayList<String> result = new ArrayList<String>(3);
            for (KomparablTest e : exp) {
                result.add(e.name);
            }
            return result;
        }
    }








