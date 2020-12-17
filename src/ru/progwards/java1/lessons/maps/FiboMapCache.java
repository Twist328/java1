package ru.progwards.java1.lessons.maps;

import static java.lang.System.currentTimeMillis;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class FiboMapCache {
    private static  Map<Integer, BigDecimal> fiboCache;


    private boolean cacheOn; // cacheOn = true кэш работает, при cacheOn = false - выключен

    FiboMapCache(boolean cacheOn) {
        this.cacheOn = cacheOn;               // Конструктор
        clearCahe();
    }

    // Очистка кеша

    public void clearCahe() {
        if (cacheOn) {
            if (fiboCache != null) fiboCache.clear();
            fiboCache = new HashMap<Integer, BigDecimal>();
            fiboCache.put(1, BigDecimal.ONE);
            fiboCache.put(2, BigDecimal.ONE);
            lastFiboCache_n = 2;
            lastFibo_prev = BigDecimal.ZERO;
            lastFibo_next  = BigDecimal.ONE;
            lastFibo_n = 1;
        }
    }



    public BigDecimal fiboNumber(int n) {                      // Расчёт Фибоначчи
        return cacheOn ? fiboCacheMap(n) : fiboNoCache(n);
    }

    int lastFiboCache_n;       // Рассчёт Фибоначчи с кеш

    public BigDecimal fiboCacheMap(int n) {

        if (fiboCache.containsKey(n)) return fiboCache.get(n); // имеется в кеш

        BigDecimal prev = fiboCache.get(lastFiboCache_n - 1);
        BigDecimal next = fiboCache.get(lastFiboCache_n);
        BigDecimal sum;
        int i = lastFiboCache_n;

        while (i++ < n) {
            sum = next;
            next = next.add(prev);
            prev = sum;
            fiboCache.put(i, next);
            if (i % 3 == 0)
                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {
                }
        }

        lastFiboCache_n = n;
        return next;
    }

    int lastFibo_n = 1;
    BigDecimal lastFibo_prev = BigDecimal.ZERO;
    BigDecimal lastFibo_next  = BigDecimal.ONE;

    public BigDecimal fiboCacheLast(int n) {

        if (lastFibo_n == n) return lastFibo_next ; //  последнее число КЭШ

        BigDecimal prev;
        BigDecimal next;
        BigDecimal sum;
        int i;

        if (lastFibo_n < n) {                       //    КЭШ
            prev = lastFibo_prev;
            next = lastFibo_next ;
            i = lastFibo_n;
        } else {                               //  сначала
            prev = BigDecimal.ZERO;
            next = BigDecimal.ONE;
            i = 1;
        }

        while (i++ < n) {
            sum = next;
            next = next.add(prev);
            prev = sum;
        }

        lastFibo_n = n;
        lastFibo_prev = prev;
        lastFibo_next  = next;
        return next;
    }

    // Рассчитываем Фибоначчи с нуля без кеша

    public BigDecimal fiboNoCache(int n) {
        try {
            Thread.sleep(1);
        } catch (InterruptedException ex) {
        }
        BigDecimal prev = BigDecimal.ZERO;
        BigDecimal next = BigDecimal.ONE;
        BigDecimal sum;
        int i = 1;
        while (i++ < n) {
            sum = next;
            next = next.add(prev);
            prev = sum;
        }
        return next;
    }

    public static void test() {
        long start;
        FiboMapCache temp;

        start = currentTimeMillis();
        temp = new FiboMapCache(false);
        for (int i = 1; i <= 50; i++) temp.fiboNumber(i);
        System.out.println("fiboNumber cacheOn=" + false + " время выполнения " + (currentTimeMillis() - start));

        start = currentTimeMillis();
        temp = new FiboMapCache(true);
        for (int i = 1; i <= 50; i++) temp.fiboNumber(i);
        System.out.println("fiboNumber cacheOn=" + true + " время выполнения " + (currentTimeMillis() - start));

        /*start = currentTimeMillis();
        temp = new FiboMapCache(false);
        for (int i = 1; i <= 1000; i++) temp.fiboCacheLast(i);
        System.out.println("fiboNumber cacheOn=my время выполнения " + (currentTimeMillis() - start));*/

    }

   /* public static void test1() {
        FiboMapCache temp = new FiboMapCache(true);
        final int NUM_FROM = 1;
        final int NUM_TO = 1_000;

        test2(temp, NUM_FROM, NUM_TO, "время на загрузку в КЭШ ");
        test2(temp, NUM_FROM, NUM_TO, "выгрузка из КЭШ");
        temp.clearCahe();
        test2(temp, NUM_FROM, NUM_TO, "чистка КЭШ ");
        temp.clearCahe();
        test2(temp, NUM_TO, NUM_TO, " КЭШ расчетом " + NUM_TO);
        temp.clearCahe();
        test2(temp, NUM_FROM, NUM_TO, " КЭШ перебором с " + NUM_FROM + " до " + NUM_TO);

    }

    private static void test2(FiboMapCache temp, int numFrom, int numTo, String caption) {
        long start = currentTimeMillis();
        for (int i = numFrom; i <= numTo; i++) temp.fiboNumber(i);
        System.out.println(caption + ", мс: " + (currentTimeMillis() - start));
    }*/

    public static void main(String[] args) {
        FiboMapCache temp = new FiboMapCache(true);
        for (int i = 1; i <= 10; i++) System.out.println(temp.fiboNumber(i));
        test();
    }
}