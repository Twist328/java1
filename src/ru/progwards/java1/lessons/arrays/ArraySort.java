package ru.progwards.java1.lessons.arrays;


import ru.progwards.java1.lessons.interfaces.CompareWeight;

import java.util.Arrays;

    public class ArraySort {

        public static void main(String[] args) {
            int[] a = {1, 10, 84, -5, -93, 82,-2954, -83, -35, -74, 31, -99, -58, 222, 11};
            ArraySort.sort(a);
            System.out.println(Arrays.toString(a));
        }


        public static void sort(int[] a) {

            for (int i = 0; i < a.length; i++) {
                int  min = a[i];
                int minId = i;
                for (int j = i + 1; j < a.length; j++) {
                    if (a[j]>(min))  {
                        min = a[j];
                        minId = j;
                    }
                }
                int temp = a[i];
                a[i] = min;
                a[minId] = temp;
            }
        }
    }
