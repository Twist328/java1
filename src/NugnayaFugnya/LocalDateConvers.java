package NugnayaFugnya;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.rmi.server.UID;
import java.time.*;
import java.util.Date;
import java.util.UUID;

public class LocalDateConvers {
    public static class FileDateTimeChange {
        static public LocalDateTime readDateTime(Path path) {
            //метод читает дату и время обновления файла по path
            //и конвертирует ее в LocalDateTime
            //с учетом настроек операционной системы по умолчанию
            try {
                LocalDateTime datetime = Files.getLastModifiedTime(path)
                        .toInstant()
                        .atZone(ZoneId.systemDefault())
                        .toLocalDateTime();

                return datetime;
            } catch (IOException e) {
                return null;
            }
        }

        static public FileTime convertLocalDateTime(LocalDateTime dateTime) {
            //метод конвертирует LocalDateTime dateTime в формат FileTime
            ZoneId systemZone = ZoneId.systemDefault();
            ZoneOffset zoneOffset = systemZone.getRules().getOffset(dateTime);
            Instant instant = dateTime.toInstant(zoneOffset);
            FileTime fileTime = FileTime.from(instant);

            return fileTime;
        }

        public static void main(String[] args) {
            ZoneId zid = ZoneId.of("Europe/Moscow");
            System.out.println(convertLocalDateTime(LocalDateTime.now(zid)));
        }
    }
}
