package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

import static java.math.BigDecimal.*;

public class BigAlgebra {

    static BigDecimal fastPow(BigDecimal num, int pow) {
        BigDecimal result = ONE;    // return num.pow(pow);
        while (pow > 0) {
            if ((pow & 1) == 1) {
                result = result.multiply(num);
           }
            num = num.multiply(num);
            pow >>= 1;
        }
        return result;
    }

    public static void main(String[] args)  {

        BigAlgebra dec = new BigAlgebra();
        System.out.println(dec.fastPow(BigDecimal.valueOf(256.33), 5));



        System.out.println(new BigInteger(String.valueOf(fibonacci(259))));
    }

    static BigInteger fibonacci(int n) {
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