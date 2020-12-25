package ru.progwards.java1.lessons.datetime;

/*import java.time.Duration;
import java.time.ZonedDateTime;

public class Insurance {

    public static enum FormatStyle {SHORT, LONG, FULL}  //SHORT соответствует ISO_LOCAL_DATE
    private ZonedDateTime start;                         //LONG  - ISO_LOCAL_DATE_TIME
    private Duration duration;                            //FULL - ISO_ZONED_DATE_TIME

    public Insurance(ZonedDateTime start) {
        this.start = start;
    }
    public Insurance(String strStart, FormatStyle style){
        start=
    }
}*/
import java.time.*;
import java.time.format.DateTimeFormatter;




//Класс должен проверять валидность страховок,
//Каждая страховка имеет дату-время начала, и продолжительность.


public class Insurance {

   static enum FormatStyle
    {SHORT, LONG, FULL} // стиль формата даты-времени // перенесено сюда для тестера

    ZonedDateTime start; // дата-время начала действия страховки
    Duration valid; // продолжительность действия

    public Insurance(ZonedDateTime start){
        this.start = start;
    }

    // установить дату-время начала действия страховки
    public void Insurance(ZonedDateTime start) {
        this.start = start;
    }

    Insurance() {
    }

   Insurance(String strStart, FormatStyle style) {
        setDuration(strStart, style);
    }

    // найти дату-время по строке с заданным форматом
    /*private ZonedDateTime styledStringToZDT(String strStart, FormatStyle style) {
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
    }*/

    // установить продолжительность действия страховки
    public void setDuration(Duration duration) {
        valid = duration;
    }

    // установить продолжительность действия страховки, задав дату-время окончания
    public void setDuration(ZonedDateTime stop) {
        valid = Duration.between(start, stop);
    }

    public void setDuration(String durationStr, FormatStyle style) {

        switch (style) {
            case SHORT: //целое число миллисекунд (тип long)
                valid = Duration.ofMillis(Integer.parseInt(durationStr));
                break;
            case LONG:
                LocalDateTime date0 = LocalDateTime.parse("0000-01-01T00:00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                LocalDateTime date1 = LocalDateTime.parse(durationStr, DateTimeFormatter.ISO_LOCAL_DATE_TIME).plusMonths(1).plusDays(1);
                valid = Duration.between(date0, date1);
                break;
            case FULL:
            default:
                valid = Duration.parse(durationStr);
        }
    }

    // установить продолжительность действия страховки, задав целыми числами количество месяцев, дней и часов
    public void setDuration(int mons, int days, int hrs) {
        ZonedDateTime zdt = start == null ? ZonedDateTime.now() : start;
        zdt = zdt.plusMonths(mons).plusDays(days).plusHours(hrs);
        valid = Duration.between(start, zdt);
    }

    // проверить валидна ли страховка на указанную дату-время
    public  boolean checkValid(ZonedDateTime dateTime) {
        if (valid == null) return dateTime.isAfter(start);
        ZonedDateTime over = start.plusHours(valid.toHours());
        return dateTime.isAfter(start) && dateTime.isBefore(over);
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
        Duration valid = Duration.between(date0, date1);
        System.out.println(date0);
        System.out.println(date1);
        System.out.println(valid.toString());
        System.out.println(new Insurance().equals(valid));
    }
}
