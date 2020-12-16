package ru.progwards.java1.lessons.maps;

import ru.progwards.java1.lessons.interfaces.CalculateFibonacci;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {
    private static  Map<Integer, BigDecimal> fiboCache;


    public FiboMapCache(boolean cacheOn) {
        if (cacheOn == true) {

        } else {
            return;
        }
    }
        public void clearCahe() {
            if (cacheOn) {
                if (fiboCache != null) fiboCache.clear();
                fiboCache = new HashMap<Integer, BigDecimal>();
                fiboCache.put(1, BigDecimal.ONE);
                fiboCache.put(2, BigDecimal.ONE);
                prev = 2;
                lastFibo_f1 = BigDecimal.ZERO;
                lastFibo_f2 = BigDecimal.ONE;
                lastFibo_n = 1;
            }
        }


    public static BigDecimal  fiboNumber(int n) throws IOException{
        if (fiboCache.containsKey(n)) return fiboCache.get(n);

        if (n <= 2.0) return BigDecimal.ONE;
        BigDecimal prev = BigDecimal.ONE, sum = BigDecimal.ONE;
        BigDecimal next = null;
        for (int i = (int) 2.0; i < n; i++) {
            next = prev.add(sum);
            sum = prev;
            prev = next;
        }
        return next;
    }



    public static void test() {

    }

    public static void main(String[] args) throws NullPointerException, IOException {
        System.out.println(new BigDecimal(String.valueOf( fiboNumber((int) 100.0))));
    }

}
