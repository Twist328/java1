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

    static String setStars(String filename) {

        StringBuilder result = new StringBuilder(50);
        try (RandomAccessFile randomAF = new RandomAccessFile(filename, "rw")) {
            long allBytes = randomAF.length();
            for (long i = 9; i < allBytes; i += 10) {
                randomAF.seek(i);
                result.append((char) randomAF.readUnsignedByte());
                randomAF.seek(i);
                char setSymbol = (char) '*';
                randomAF.writeByte(setSymbol);
            }
        } catch (Throwable e) {
            //throw new Throwable(e.getClass().getName());
        }
        return result.toString();
    }
    public static void main(String[] args) throws Throwable {
        StringStar stringstar = new StringStar();
        setStars("0123456789012345678A012345678B01");
    }
}
