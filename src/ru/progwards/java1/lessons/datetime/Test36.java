package ru.progwards.java1.lessons.datetime;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Test36 {
    static Date createDate() {
        GregorianCalendar calendar = new GregorianCalendar(1986, Calendar.FEBRUARY, 28);
        calendar.set(Calendar.HOUR, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND, 00);
        //calendar.clear();
        return Date.from(calendar.toInstant());
    }

    public static void main(String[] args) {
        Date now = new Date();
        long unixTS = now.getTime() / 1000L;
        System.out.println(now);
        System.out.println(now.toString());
        GregorianCalendar calendar = new GregorianCalendar(1986, Calendar.FEBRUARY, 28);
        calendar.set(Calendar.HOUR, 00);
        calendar.set(Calendar.MINUTE, 00);
        calendar.set(Calendar.SECOND, 00);
        calendar.set(Calendar.MILLISECOND, 00);

        System.out.println("Год: " + calendar.get(Calendar.YEAR));
        System.out.println("Месяц: " + calendar.get(Calendar.MONTH));
        System.out.println("Порядковый номер недели в месяце: " + calendar.get(Calendar.WEEK_OF_MONTH));
//порядковый номер недели в месяце
        System.out.println("Число: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Часы: " + calendar.get(Calendar.HOUR));
        System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
        System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
        System.out.println("Миллисекунды: " + calendar.get(Calendar.MILLISECOND));

        System.out.println(new Test36().createDate());

    }
}

