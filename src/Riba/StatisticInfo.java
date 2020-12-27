package Riba;


import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class StatisticInfo implements Comparable {
    public String sectionName; // имя секции
    public int fullTime = 0; // полное время выполнения секции в миллисекундах
    public int selfTime = 0; // чистое время выполнения секции в миллисекундах
    public int count = 0; // количество вызовов

    boolean begin; // задействована ли секция
    private Chronoscope chrono; // единицы измерения времени
    private long startTime; // время начала
    private List<Collation> runColl; // кто запущен внутри


    StatisticInfo(String sectionName, Chronoscope chrono) {
        this.sectionName = sectionName;
        this.chrono = chrono;
        runColl = new ArrayList<Collation>();
    }

    // текущее время
    long getTimeNow() {
        switch (chrono) {
            case NANOSECONDS:
                return System.nanoTime();
            default:
                return System.currentTimeMillis();
        }
    }

    // вход в секцию
    void enter() {
        count++;
        if (!begin) {
            begin = true;
            startTime = getTimeNow();
        }
    }

    // выход из секции
    void exit() {
        if (!begin) return;
        long timeNow = getTimeNow();
        int newFullTime = fullTime + (int) (timeNow - startTime);
        int newSelfTime = realSelfTime(timeNow);
        runColl.clear();
        begin = false;
        fullTime = newFullTime;
        selfTime = newSelfTime;
    }

    // собственное время, без подсекций
    int realSelfTime(long timeNow) {
        if (!begin) return selfTime;
        int result = selfTime + (int) (timeNow - startTime);
        for (Collation e : runColl) {
            result -= e.getCollTime(timeNow);
        }
        return result;
    }

    // добавить внутреннюю секцию
    void addCollation(StatisticInfo info) {
        if (begin) {
            runColl.add(new Collation(info, getTimeNow()));
        }
    }

    // удалить внутреннюю секцию
    void removeCollation(StatisticInfo info) {
        if (begin) {
            long timeNow = getTimeNow();
            ListIterator iter = runColl.listIterator();
            while (iter.hasNext()) {
                Collation coll = (Collation) iter.next();
                if (coll.info.equals(info)) {
                    selfTime = selfTime - coll.getCollTime(timeNow);
                    iter.remove();
                }
            }
        }
    }

    @Override
    public String toString() {
        return "\n" + sectionName + " Sec " + " Total:" + fullTime + " Self:" + selfTime + " Count:" + count;
    }

    @Override
    public int compareTo(Object o) {
        return this.sectionName.compareTo(((StatisticInfo) o).sectionName);
    }

    // для сортировки в TreeMap
  /* @Override
    public int compareTo(Object o) {
        return this.sectionName.compareTo(((StatisticInfo) o).sectionName);
    }*/
}


