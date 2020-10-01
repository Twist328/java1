package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {

    public BigAlgebra() {
    }

       static BigDecimal fastPow(BigDecimal num, int pow) {

         return num.pow(pow);
    }
    public static void main(String[] args) {
        BigAlgebra cadabra = new BigAlgebra();
        System.out.println(cadabra.fastPow(BigDecimal.valueOf(8), 5));


        System.out.println(new BigInteger(String.valueOf(fibonacci(15))));
    }

     static BigInteger fibonacci(int n) {
        if (n <= 2) return BigInteger.valueOf(1);
        BigInteger prev = BigInteger.valueOf(1), prevOfPrev = BigInteger.valueOf(1);
        BigInteger curr = null;
        for (int i = 2; i < n; i++) {
            curr = prev.add(prevOfPrev);
            prevOfPrev = prev;
            prev = curr;
        }
        return curr;

    }
}