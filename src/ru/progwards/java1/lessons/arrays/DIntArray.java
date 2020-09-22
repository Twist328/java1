package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;


public class DIntArray {
    DIntArray i;
    private int[] values = {(100)};


    public DIntArray() {

    }

    private int j;

    public void add(int num) {
        if (j == values.length)
            values = Arrays.copyOf(values, j + 1);
        values[j] = num;
        j++;
    }

    public void atInsert(int pos, int num) {
        int[] values2 = new int[values.length + 1];

        System.arraycopy(values, 0, values2, 0, pos);

        values2[pos] = num;

        System.arraycopy(values, pos, values2, pos + 1, values.length - pos);
        values = values2;
    }


    public void atDelete(int pos) {

        if (pos == 0) {
            int[] values2 = new int[values.length - 1];
            System.arraycopy(values, 1, values2, 0, values2.length);
            values = values2;
        } else if (pos == values.length - 1) {
            int[] values2 = new int[values.length - 1];
            for (int i = 0; i < values.length - 1; i++) {
                values2[i] = values[i];
            }
            values = values2;
        } else {
            int[] values2 = new int[values.length - 1];
            for (int i = 0; i < values.length; i++) {
                if (i > pos) {
                    values2[i - 1] = values[i];
                }
                if (i == pos) {
                    continue;
                }
                if (i < pos) {
                    values2[i] = values[i];
                }
            }
            values = values2;
        }
    }

    public int at(int pos) {
        final int values1 = values[pos];

        return values[pos];
    }

}





