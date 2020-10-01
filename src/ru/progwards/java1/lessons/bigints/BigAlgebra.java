package ru.progwards.java1.lessons.bigints;

import java.math.BigDecimal;
import java.math.BigInteger;

public class BigAlgebra {

    public BigAlgebra() {
    }

       static BigDecimal fastPow(BigDecimal num, int pow) {

        if (pow == 0) return BigDecimal.valueOf(1.0);        //проверка нулевой степени
        String BYNPOW = Integer.toString(pow, 2);           //представление степени двоичным числом
        BigDecimal result = BigDecimal.valueOf(0);             //инициализация результата НУЛЕМ
        for (int i = BYNPOW.length() - 1; i >= 0; i--)  {    //цикл перебора от СТАРШЕГО бита к МЛАДШЕМУ
            if (BYNPOW.charAt(i) == '1') {                           //
                result = result.multiply(result).multiply(num);
            } else result = result.multiply(result);
        }
        return result;
    }

    public static void main(String[] args) {
        BigAlgebra cadabra = new BigAlgebra();
        System.out.println(cadabra.fastPow(BigDecimal.valueOf(3), 5));


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