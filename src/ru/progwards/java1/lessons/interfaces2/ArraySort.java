package ru.progwards.java1.lessons.interfaces2;

import java.util.*;


public class ArraySort extends Number {

    private static Number num;
    public ArraySort() {
        super();
    }

    public static void sort(Comparable<Number>[] a) {
        Set<Comparable<Number>[]> comparables = new TreeSet(Arrays.asList(a)) {

            private DoubleNumber num;


            public int compareTo(Number o) {
                Number num = (Number) o;
                return this.num.compareTo(o.num);

            }

            @Override
            public String toString() {
                return "ArraySort{" +
                        "num=" + num +
                        '}';
            }
        };
    }

        public static void main(String[] args) throws NullPointerException {

            Comparable<Number>[] a = new Comparable[]{90, 300, -100000,10000000, 6, 3, 9, 21};

            Arrays.sort(a);

            System.out.println(Arrays.toString(a));

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