package ru.progwards.java1.lessons.datetime;

import java.time.*;

public class Test38 {
    Instant createInstant(){  //Создайте метод с сигнатурой Instant createInstant(), который возвращает
        // Instant, соответствующий 1 января 2020 года, 15 часов и одна наносекунда по Московскому времени
LocalDateTime time=LocalDateTime.of(2020, 01,01,15,00,00,01);

        return time.toInstant(java.time.ZoneOffset.of("+03:00:00"));
    }

    public static void main(String[] args) {
        LocalDateTime ldt1= LocalDateTime.now();
        LocalDateTime ldt2= ldt1.plusDays(4);
        Duration duration = Duration.between(ldt1,ldt2);

        System.out.println(duration.toHours());


        LocalDateTime ldt0= LocalDateTime.of(2019, 05, 05, 22, 24);

        System.out.println(ldt0);


        ZoneId zid1 = ZoneId.of("Europe/Moscow");

        System.out.println(zid1.getRules().getOffset(Instant.now()));

        System.out.println(new Test38().createInstant());
    }
}
