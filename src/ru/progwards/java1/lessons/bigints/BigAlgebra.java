package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {

    public BigAlgebra() {
    }

    //(int a, int n)
    static BigDecimal fastPow(BigDecimal num, int pow) {
        BigDecimal result = BigDecimal.valueOf(1);
        while (pow > 0) {
            if ((pow & 1) == 1) {
                result = result.multiply(num);
            }
            num = num.multiply(num);                 //x *= y x = x * y
            pow >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        BigAlgebra dec = new BigAlgebra();
        System.out.println(dec.fastPow(BigDecimal.valueOf(256.33), 5));
        System.out.println(new BigInteger(String.valueOf(fibonacci(66999))));
    }

    static BigInteger fibonacci(int n) {
        if (n <= 2) return BigInteger.valueOf(1);
        BigInteger prev = BigInteger.valueOf(1), sum = BigInteger.valueOf(1);
        BigInteger next = null;
        for (int i = 2; i < n; i++) {
            next = prev.add(sum);
            sum = prev;
            prev = next;
        }
        return next;

    }
}