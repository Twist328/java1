package ru.progwards.java1.lessons.bitsworld;

public class SumBits {
    public static int sumBits(byte value) {
        byte num = (byte) 0;
        for (int i = 0; i < 8; i++) {
            num += (value >> i) & 1 ;
        }
        return num;
    }


    public static void main(String[] args) {

        System.out.println(sumBits((byte) ((byte) 11110110)));
    }
}

