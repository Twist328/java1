package Goon;

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

    // public static void randomFill(Integer[] a, int from, int to) {
    //  for (int i = a.length - 1; i >= 0; i--) a[i] = (int) (Math.random() * (to - from)) + from;
    // }

    public static Collection<String> compareSort() {
        //сравнить производительность методов и вернуть их имена, отсортированные в порядке производительности,
        // первый - самый быстрый. В случае равенства производительности первым вернуть "collSort"
        for (int cnt = 1; cnt <= 3; cnt++) {
            Integer[] anArray = new Integer[10000];
            Random rand = new Random();
            for (int j = 0; j < 10000; j++) {
                anArray[j] = rand.nextInt();
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
