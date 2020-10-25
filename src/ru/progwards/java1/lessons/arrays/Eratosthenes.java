package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {

    private boolean[] sieve;
    public Eratosthenes(int N) {
        this.sieve = new boolean[N + 1];
        Arrays.fill(sieve, true);
        shift();
    }
    private void shift() {
        for (int i = 2; i < sieve.length; i++) {
            for (int j = i +1; j < sieve.length; j++) {
                if (j % i == 0) {
                    sieve[j] = false;
                }
            }
        }
    }
    public boolean isSimple(int n) {
        return sieve[n];
    }
    public static void main(String[] args) {
        Eratosthenes eratosthenes = new Eratosthenes(100);
        System.out.println(eratosthenes.isSimple(13));
    }
}




