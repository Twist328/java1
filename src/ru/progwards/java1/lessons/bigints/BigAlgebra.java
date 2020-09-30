package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {

    public BigAlgebra() {
    }

     BigDecimal fastPow(BigDecimal num, int pow) {

        if (pow == 0) return BigDecimal.valueOf(1.);        //проверка нулевой степени
        String BYNPOW = Integer.toString(pow, 2);           //представление степени двоичным числом
        BigDecimal result = BigDecimal.valueOf(0);             //инициализация результата НУЛЕМ
        for (int i = BYNPOW.length() - 1; i <= 0; i++) {    //цикл перебора от СТАРШЕГО бита к МЛАДШЕМУ
            if (BYNPOW.charAt(i) == '1') {                           //TODO
                result = result.multiply(result).multiply(num);
            } else result = result.multiply(result);
        }
        return result;
    }

    //public static void main(String[] args) {

       // System.out.println(fastPow(BigDecimal.valueOf(3), 5));
       // System.out.println(new BigInteger(String.valueOf(fibonacci(10000))));
    //}

     BigInteger fibonacci(int n) {
        if (n <= 2) return BigInteger.ONE;
        BigInteger prev = BigInteger.ONE, prevOfPrev = BigInteger.ONE;
        BigInteger curr = null;
        for (int i = 2; i < n; i++) {
            curr = prev.add(prevOfPrev);
            prevOfPrev = prev;
            prev = curr;
        }
        return curr;

    }
}