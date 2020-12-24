package Riba;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public  class Test39 {
    static ZonedDateTime parseZDT(String str) {
        Locale loc = Locale.forLanguageTag("EN");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("DD.MM.yyyy HH:mm:ss.SSS Z zzzz", loc);
        return ZonedDateTime.parse(str, dtf.withZone(ZoneId.of("Europe/Moscow")));
    }

    public static void main(String[] args) {
        System.out.println(new Test39().parseZDT("01.01.2020 16:27:14.444 +0300 Moscow Standard Time"));
    }
}
