package ru.progwards.java1.lessons.datetime;


import java.time.*;
import java.time.format.DateTimeFormatter;

public class Insurance {

    static enum FormatStyle {SHORT, LONG, FULL} // стиль формата даты-времени

    private ZonedDateTime start; // дата-время начала действия страховки
    private Duration durationVal; // продолжительность действия
    //Duration val;

    public Insurance(ZonedDateTime start) {// установить дату-время начала действия страховки
        this.start = start;
    }

    public Insurance(String strStart, FormatStyle style) {// дата-время начала действия страховки
        start = Insurance(strStart,style);

    }

    // найти дату-время по строке с заданным форматом
     ZonedDateTime Insurance(String strStart, FormatStyle style) {
        DateTimeFormatter formatter;
        switch (style) {
            case SHORT:
                formatter = DateTimeFormatter.ISO_LOCAL_DATE;
                break;
            case LONG:
                formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                break;
            case FULL:
            default:
                formatter  = DateTimeFormatter.ISO_ZONED_DATE_TIME;
                return ZonedDateTime.parse(strStart, formatter);
        }
        LocalDate date = LocalDate.parse(strStart, formatter);
        return date.atStartOfDay(ZoneId.systemDefault());
    }

    // установить продолжительность действия страховки
    public void setDuration(Duration duration) {
        durationVal = duration;
    }

    // установить продолжительность действия страховки, задав дату-время окончания
    public void setDuration(ZonedDateTime stop) {
        durationVal = Duration.between(start, stop);
    }

    public void setDuration(String durationStr, FormatStyle style) {

        switch (style) {
            case SHORT: //целое число миллисекунд (тип long)
                durationVal = Duration.ofMillis(Integer.parseInt(durationStr));
                break;
            case LONG:
                LocalDateTime dateTime0 = LocalDateTime.parse("0000-01-01T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                LocalDateTime dateTime1 = LocalDateTime.parse(durationStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME).plusMonths(1).plusDays(1);
                durationVal = Duration.between(dateTime0, dateTime1);
                break;
            case FULL:
            default:
                durationVal = Duration.parse(durationStr);
        }
    }

    // установить продолжительность действия страховки, задав целыми числами количество месяцев, дней и часов
    public void setDuration(int months, int days, int hours) {
        ZonedDateTime zdt = start == null ? ZonedDateTime.now() : start;
        zdt = zdt.plusMonths(months).plusDays(days).plusHours(hours);
        durationVal = Duration.between(start, zdt);
    }

    // проверить валидна ли страховка на указанную дату-время
    public boolean checkValid(ZonedDateTime dateTime) {
        if (durationVal == null) return dateTime.isAfter(start);
        ZonedDateTime over = start.plusHours(durationVal.toHours());
        return dateTime.isAfter(start) | dateTime.isBefore(over);
    }

    // вернуть строку формата "Insurance "+start+" "+duration
    @Override
    public String toString() {
        return "Insurance issued on " + start + " is " + (checkValid(ZonedDateTime.now()) ? "" : "not ") + "valid";
    }

    public static void main(String[] args) {
        LocalDateTime date0 = LocalDateTime.parse("2020-01-01T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        LocalDateTime date1 = LocalDateTime.parse("2020-11-30T10:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME).
                plusMonths(1).plusDays(1);
        Duration val = Duration.between(date0, date1);
        System.out.println(date0);
        System.out.println(date1);
        System.out.println(val.toString());

        System.out.println(new Insurance("2020-11-30T10:00:00",FormatStyle.LONG));
    }
}
