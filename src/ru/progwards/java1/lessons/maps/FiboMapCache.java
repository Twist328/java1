package ru.progwards.java1.lessons.maps;

import static java.lang.System.currentTimeMillis;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {
    private static Map<Integer, BigDecimal> fiboCache;
    private boolean cacheOn;     // cacheOn = true кэш работает, при cacheOn = false - выключен
    int lastFiboCache_n;

    FiboMapCache(boolean cacheOn) {
        this.cacheOn = cacheOn;               // Конструктор
        clearCahe();
    }

    public BigDecimal fiboNumber(int n) {                      // Обычный расчёт Фибоначчи
        return cacheOn ? fiboNumber1(n) : fiboNumber2(n);
    }

    public BigDecimal fiboNumber1(int n) { // Рассчёт Фибоначчи с кеш

        if (fiboCache.containsKey(n)) return fiboCache.get(n);     //  n имеется в кеш

        BigDecimal prev = fiboCache.get(lastFiboCache_n - 1);
        BigDecimal sum = fiboCache.get(lastFiboCache_n);
        BigDecimal next;
        int i = lastFiboCache_n;
        while (i++ < n) {
            next = sum;
            sum = sum.add(prev);
            prev = next;
            fiboCache.put(i, sum);
            if (i % 3 == 0)
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                }
        }
        lastFiboCache_n = n;
        return sum;
    }

    public BigDecimal fiboNumber2(int n) {     // Рассчёт Фибоначчи без КЭШ
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
        }
        BigDecimal prev = BigDecimal.ZERO;
        BigDecimal sum = BigDecimal.ONE;
        BigDecimal next;
        int i = 1;
        while (i++ < n) {
            next = sum;
            sum = sum.add(prev);
            prev = next;
        }
        return sum;
    }

    public static void test() {
        long start;
        FiboMapCache temp;

        start = currentTimeMillis();
        temp = new FiboMapCache(false);
        for (int i = 1; i <= 1000; i++) temp.fiboNumber(i);
        System.out.println("fiboNumber cacheOn=" + false + " время выполнения " + (currentTimeMillis() - start));

        start = currentTimeMillis();
        temp = new FiboMapCache(true);
        for (int i = 1; i <= 1000; i++) temp.fiboNumber(i);
        System.out.println("fiboNumber cacheOn=" + true + " время выполнения " + (currentTimeMillis() - start));

    }

    public void clearCahe() {   // Очистка КЭШ
        if (cacheOn == true) {
            if (fiboCache != null) fiboCache.clear();

            fiboCache = new HashMap<Integer, BigDecimal>();// иначе IOEXCEPTION nullpointer;
            fiboCache.put(1, BigDecimal.ONE);
            fiboCache.put(2, BigDecimal.ONE);
            lastFiboCache_n = 2;

        }
    }

    public static void main(String[] args) {
        FiboMapCache temp = new FiboMapCache(true);
        for (int i = 1; i <= 10; i++) System.out.println(temp.fiboNumber(i));
        test();
    }
}
