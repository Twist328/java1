package ru.progwards.java1.lessons.arrays;

import java.util.ArrayList;

class PIntArray {
    ArrayList<int[]> pages;
    int size; // количеств элемементов в крайней странице
    int blockSize;

    public PIntArray(int blockSize) {
        pages = new ArrayList<>(1000);
        pages.add(new int[blockSize]);
        this.blockSize = blockSize;
        size = 0;
    }

    public void add(int item) {
        int[] array = pages.get(pages.size() - 1);
        if (size >= array.length) {
            array = new int[blockSize];
            pages.add(array);
            size = 0;
        }
        array[size++] = item;
    }

    int get(int index) {
        int index1 = index / blockSize;
        int index2 = index % blockSize;
        return pages.get(index1)[index2];
    }

    public int size() {
        return (pages.size() - 1) * blockSize + size;
    }
}
