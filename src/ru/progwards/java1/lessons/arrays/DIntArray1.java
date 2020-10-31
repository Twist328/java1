package ru.progwards.java1.lessons.arrays;

public class DIntArray1 {
    int[] array = new int[0];

    public void add(int item) {
        int[] newArray = new int[array.length+1];
        copyData(array, newArray);
        newArray[array.length] = item;
        array = newArray;
    }

    void copyData(int[] src, int[] dst) {
        for(int i=0; i<src.length; i++)
            dst[i] = src[i];
    }

    public int get(int index) {
        return array[index];
    }

    public int size() {
        return array.length;
    }
}


