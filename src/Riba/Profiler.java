package Riba;



import java.util.*;

enum Chronoscope {MILLISECONDS, NANOSECONDS}

class Collation {
    public int selfTime; // чистое время связянной секции на момент создания связи
    StatisticInfo info; // секция, с которой связь

    Collation(StatisticInfo info, long timeNow) {
        this.info = info;
        selfTime = info.realSelfTime(timeNow);
    }

    int getCollTime(long timeNow) {
        return info.realSelfTime(timeNow) - selfTime;
    }
}

public class Profiler {//Реализовать класс для ручной профилировки производительности программного кода

    static Chronoscope chrono = Chronoscope.MILLISECONDS;
    static TreeMap<String, StatisticInfo> sections = new TreeMap<String, StatisticInfo>();

    // войти в профилировочную секцию
    public static void enterSection(String name) {
        StatisticInfo section;
        if (sections.containsKey(name)) {
            section = sections.get(name);
        } else {
            section = new StatisticInfo(name, chrono);
            sections.put(name, section);
        }
        if (!section.begin) {
            for (StatisticInfo sInfo : sections.values()) sInfo.addCollation(section);
        }
        section.enter();
    }

    // выйти из профилировочной секции
    public static void exitSection(String name) {
        StatisticInfo section = sections.get(name);
        section.exit();
        if (!section.begin) {
            for (StatisticInfo sInfo : sections.values()) sInfo.removeCollation(section);
        }
    }

    // обнулить статистику
    public static void clear() {
        sections.clear();
    }

    // получить профилировочную статистику, отсортировать по наименованию секции
    public static List<StatisticInfo> getStatisticInfo() {
        return new ArrayList<StatisticInfo>(sections.values());
    }

    public static String getSectionsInfo() {
        return sections.values().toString();
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ex) {
        }
    }

    public static void main(String[] args) {
        enterSection("2");
        sleep(200);
        enterSection("1");
        sleep(200);
        enterSection("3");
        sleep(300);
        enterSection("2");
        sleep(200);
        exitSection("2");
        enterSection("2");
        sleep(200);
        exitSection("2");
        exitSection("2");
        sleep(100);
        exitSection("1");
        exitSection("3");
        sleep(200);

        System.out.println(getSectionsInfo());
    }
}
