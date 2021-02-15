package ru.progwards.java1.lessons.interfaces2;

import java.util.*;


public class ArraySort implements Comparable<Number> {

    private static Number num;



    public static void sort(Comparable<Number>[] a){
        Set<Number> c = new TreeSet(Arrays.asList(a.length)){
            @Override
            public Comparator comparator() {
                return super.comparator();
            }

            @Override
            public String toString() {
                return "ArraySort{" +
                        "num=" + num +
                        '}';
            }
        };
    }

    @Override
    public int compareTo(Number o) {
        if (o.num.compareTo(this.num) > 0) {
            return 1;
        } else if (o.num.compareTo(this.num) == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    static class Main {
        public static void main(String[] args) throws NullPointerException {

           Set set = new TreeSet();

            for (Integer e : new Integer[]{90, 300, 10000000, 6, 3, 9, 21}) set.add(e);
            for (Object o : set) {

                System.out.println(o);

            }
            // Arrays.sort(a);
            //System.out.println(Arrays.toString(a));

        }
    }
}












     /*Arrays.sort(a, (o1, o2) -> o2.compareTo((Number) o1));

        for (Comparable<Number> i : a)
            System.out.print(i + " ");
    }

    @Override
    public int compareTo(Number o) {
        return ((o.compareTo( o.num)>0) ? -1 : ((o == o.num) ? 0 : 1));
    }
    }*/






   /* public static void sort(int[] a) {


        int maxValue, maxIndex;
        for (int i = a.length - 1; i >= 0; i--) {
            maxValue = a[i];
            maxIndex = i;
            // найдем в остатках максимальный
            for (int j = 0; j < i; j++) {
                if (a[j] > maxValue) {
                    maxValue = a[j];
                    maxIndex = j;
                }
            }
            // поменяем местами, если нашли больший
            if (maxIndex < i) {
                a[maxIndex] = a[i];
                a[i] = maxValue;

            }

        }

    }*/


//Сomparatable<Number> comparator = Comparator.comparing(obj -> obj.getId());
//ArraySort.sort(a, comparator);
       /*int[] a = {1, -100, 800, 567};
       int[] a1 = new Random().ints(100, -100, 100).toArray();
       sort(a);
       sort(a1);
       System.out.println(Arrays.toString(a));
       System.out.println(Arrays.toString(a1));
   }
    public static void sort(int[] a) {
        for (int i = 0; i < a.length; i++) {
            int min = a[i];
            int minId = i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minId = j;
                }
            }
            // замена
            int temp = a[i];
            a[i] = min;
            a[minId] = temp;
        }
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}*/