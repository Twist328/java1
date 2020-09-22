package ru.progwards.java1.lessons.arrays;

import java.util.Arrays;

public class Eratosthenes {
    private boolean[] sieve;
    int n;

    public boolean isSimple(int n) {

        if (n % 2 == 0 && n != 2) return false;
        int maxDiv = (int) Math.sqrt(n);
        for (int i = 3; i <= maxDiv; i += 2) {
            if (n % i == 0) return false;
        }
        return true;
    }


    public Eratosthenes(int N) {

        sieve = new boolean[N + 1];

        Arrays.fill(sieve, true);

        sift();

    }

    private void sift() {

        for (int i = 0; i < this.n; i++) sieve[i] = true;

        for (int J = 2; J * J <= this.n; J++)

            if (sieve[J] == true)

                for (int i = J * J; i <= this.n; i += J)

                    sieve[i] = false;

    }

}




