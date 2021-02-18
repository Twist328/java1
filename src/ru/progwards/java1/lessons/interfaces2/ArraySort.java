package ru.progwards.java1.lessons.interfaces2;


import java.util.*;


public class ArraySort implements Comparable<Number> {

    private static Number num;


    public ArraySort() {
        super();
    }

    public static void sort(Comparable<Number>[] a) {


        Comparable<Number> tmpValue;
        for (int i = a.length - 1; i >= 0; i--) {
            // найдем в остатках максимальный
            for (int j = 0; j < i; j++) {
                if (a[j].compareNumber(a[i])==CompareResult.GREATER) {
                        tmpValue = a[i];
                a[i] = a[j];
                a[j] = tmpValue;
                }
            }
        }
    }

    public static void main(String[] args) throws NullPointerException {

        Comparable<Number>[] a = new Comparable[]{new Number(72628, 876786876, 99, 9999, 0, 0, 7)};
       // new ArraySort().sort(a);
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

    }


    @Override
    public CompareResult compareNumber(Comparable<Number> smthHasNumber) {
        List<Number> num = (List<Number>) new Number();
        Collections.sort(num, new Comparator<Number>() {
            @Override
            public int compare(Number o1, Number o2) {
                return 0;
            }


        });
        return null;
    }

    @Override
    public String toString() {
        return "ArraySort{}";
    }
}
           /* @Override
            public int compare(Number o1, Number o2) {
                List<Number> num = new ArrayList<Number>();

                Collections.sort(num, new Comparator<Number>(){
            {
                return o1.Number.compareTo(o2.Number);
            }
        });
                return 0;
            });
                })*/
















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