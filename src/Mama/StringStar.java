package Mama;

import java.io.*;
import java.util.Scanner;

public class StringStar {
   /* Реализовать метод с сигнатурой public String setStars(String filename) который читает файл filename и меняет в нем \
   каждый 10-йбайт на символ *, при этом конкатенируя оригинальный символ в строку ответа.
    В случае ошибки выбросить исключение IOException со строкой сообщения:равной имени класса оригинального сообщения
    Например,при содержимом файла:
            0123456789012345678A012345678B01
    новое содержимое должно быть
012345678*012345678*012345678*01
    и метод должен вернуть "9AB"*/

    static String setStars(String filename) throws Throwable {
        int star = (int) '*';
        StringBuilder result = new StringBuilder(100);
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            long totalBytes = raf.length();
            for (long i = 9; i < totalBytes; i += 10) {
                //raf.seek(i);
                result.append((char) raf.readUnsignedByte());
                //raf.seek(i);
                raf.writeByte(star);
            }
        } catch (Throwable e) {
            throw new Throwable(e.getClass().getName());
        }
        return result.toString();
    }
    public static void main(String[] args) throws Throwable {
        StringStar stringstar = new StringStar();
        setStars("0123456789012345678A012345678B01");
    }
}
