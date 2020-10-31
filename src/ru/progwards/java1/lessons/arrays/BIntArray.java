package ru.progwards.java1.lessons.arrays;

public class BIntArray {
    int[] array;
    int size;

    public BIntArray(int iniSize) {
        array = new int[iniSize == 0 ? 100 : iniSize];
        size = 0;
    }

    public void add(int item) {
        if (size == array.length) {
            int[] newArray = new int[array.length<<1];
            copyData(array, newArray);
            array = newArray;
        }
        array[size++] = item;
    }

    void copyData(int[] src, int[] dst) {
        for(int i=0; i<src.length; i++)
            dst[i] = src[i];
    }

    public int get(int index) {
        return array[index];
    }

    public int size() {
        return size;
    }
}
