package ru.progwards.java1.lessons.interfaces;

public class CalculateFibonacci {
    private static CacheInfo lastFibo;

    public static int fiboNumber(int n) {

        int iter = 3;
        int sum = 1;
        int previous = 1;
        int next = 0;

        if (n == 2 | n == 1 | n == 0)

            next = 1;

        while (iter <= n) {

            next = sum + previous;
            sum = previous;
            previous = next;
            iter++;

            if (lastFibo != null && lastFibo.n == n)
                return lastFibo.fibo;

        }
        lastFibo = new CacheInfo(n, next);

        return next;
    }

    public static class CacheInfo {

        public int n;
        public int fibo;

        public CacheInfo(int n, int fibo) {
            this.n = n;
            this.fibo = fibo;

        }
    }

    public static CacheInfo getLastFibo() {

        return lastFibo;
    }

    public static void clearLastFibo() {
        lastFibo = null;
    }

    public static void main(String[] args) {
        System.out.println(fiboNumber(43));
        System.out.println(lastFibo.fibo);
        System.out.println(lastFibo.n);

    }
}
