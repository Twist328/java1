package ru.progwards.java1.lessons.bigints;

import Tvist328.Calculator;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {
    int fibonaccinext;

    public BigAlgebra() {
    }

    BigDecimal fastPow(BigDecimal num, int pow) {
        return null;
    }

    public static void main(String[] args) {

        BigDecimal num = new BigDecimal("928372.333");

        int n = 5;

        BigDecimal result = num.pow(n);

        System.out.println(result);

    }

    BigInteger fibonacci(int n) {

        if (n <= 2) return BigInteger.ONE;

        BigInteger prev = BigInteger.ONE, sum = BigInteger.ONE;
        BigInteger next = null;
        for (int i = 2; i < n; i++) {
            next = prev.add(sum);
            sum = prev;
            prev = next;
        }
        return next;
    }
}