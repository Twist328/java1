package ru.progwards.java1.lessons.interfaces;
public class CalculateFibonacci {
    static CacheInfo lastFibo = new CacheInfo();
    public static int fiboNumber(int n) {
        if (n == CalculateFibonacci.lastFibo.n) {
            return CalculateFibonacci.lastFibo.fibo;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int sum = 1;
        int prev = 1;
        int next = 0;
        for (int i = 2; i < n; i++) {
            next = sum + prev;
            sum = prev;
            prev = next;
        }
        CalculateFibonacci.lastFibo.n = n;
        CalculateFibonacci.lastFibo.fibo = next;
        return next;
    }
    static class CacheInfo {
        int n;
        int fibo;
    }
    public static void main(String[] args) {

        CalculateFibonacci calculateFibonacci = new CalculateFibonacci();
        System.out.println(CalculateFibonacci.lastFibo.n);
        System.out.println(CalculateFibonacci.lastFibo.fibo);
        System.out.println(CalculateFibonacci.fiboNumber(15));

    }

}