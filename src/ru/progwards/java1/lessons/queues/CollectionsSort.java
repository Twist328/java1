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
        collSort(list);
        minSort(list);
        System.out.println("\n" + "MinList: " + list);
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
        ArrayList<Integer> set = new ArrayList<Integer>(data.size());

        while (list.size() > 0) {
            Integer minList = Collections.min(list);
            set.add(minList);
            list.remove(minList);

        }
        data.clear();
        data.addAll(set);
    }

    public static void collSort(Collection<Integer> data) {
        //ArrayList<Integer> list = new ArrayList<Integer>(data);

        Collections.sort((List) data);

    }

    public static Collection<String> compareSort() {

        //сравнить производительность методов и вернуть их имена, отсортированные в порядке производительности,
        // первый - самый быстрый. В случае равенства производительности каких-то методов, возвращать их названия в алфавитном порядке.
      /*  class KomparablTest {
            String name;
            long time;

            KomparablTest(String name, long time) {
                this.name = name;
                this.time = time;
            }
        }
        class SortAndGo implements Comparator<KomparablTest> {

            public int compare(KomparablTest a, KomparablTest b) {
                return Long.compare(a.time, b.time);
            }
        }
        long restime3 = 0;
        long restime2 = 0;
        long restime1 = 0;

        for (int i = 0; i < 3; i++) {

            Integer[] anArray = new Integer[1000];
            Random rand = new Random();
            for (int j = 0; j < 1000; j++) {
                anArray[j] = rand.nextInt();
            }
            int count = 1;
            long time0 = System.nanoTime();
            for (int j = count; j > 0; j--) {
                ArrayList<Integer> sets = new ArrayList<Integer>(Arrays.asList(anArray));
                mySort(sets);
            }
            long time1 = System.nanoTime();
            for (int j = count; j > 0; j--) {
                ArrayList<Integer> ar = new ArrayList<Integer>(Arrays.asList(anArray));
                minSort(ar);
            }
            long time2 = System.nanoTime();
            for (int j = count; j > 0; j--) {
                ArrayList<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(anArray));
                collSort(arrayList);
            }
            long time3 = System.nanoTime();
            restime1 += time1 - time0;
            restime2 += time2 - time1;
            restime3 += time3 - time2;
            System.out.println(restime1 / 1000 + " " + "mySort" + " " +
                    restime2 / 1000 + " " + "minSort" + " " + restime3 / 1000 + " " + "collSort");
        }

        ArrayList<KomparablTest> list = new ArrayList<KomparablTest>(3);
        list.add(new KomparablTest("mySort", restime1));
        list.add(new KomparablTest("minSort", restime2));
        list.add(new KomparablTest("collSort", restime3));
        Collections.sort(list, new SortAndGo());

        ArrayList<String> itog = new ArrayList<String>(3);
        for (KomparablTest e : list) {
            itog.add(e.name);
        }
        return itog;
    }*/
        for (int cnt = 1; cnt <= 3; cnt++) {
            Integer[] anArray = new Integer[10000];
            Random random = new Random();
            for (int j = 0; j < 10000; j++) {
                anArray[j] = random.nextInt();
            }
            //int count = 1;

            long time0 = System.currentTimeMillis();
            for (int i = 1; i > 0; i--) {
                ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(anArray));
                mySort(l);
            }
            long time1 = System.currentTimeMillis();
            for (int i = 1; i > 0; i--) {
                ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(anArray));
                minSort(l);
            }
            long time2 = System.currentTimeMillis();
            for (int i = 1; i > 0; i--) {
                ArrayList<Integer> l = new ArrayList<Integer>(Arrays.asList(anArray));
                collSort(l);
            }
            long time3 = System.currentTimeMillis();
            System.out.println((time1 - time0) + " " + "mySort" + " " +
                    (time2 - time1) + " " + "minSort" + " " + (time3 - time2) + " " + "collSort");

        }
        return null;
    }
}







