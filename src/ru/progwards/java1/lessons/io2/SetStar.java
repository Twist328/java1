package ru.progwards.java1.lessons.io2;

import java.io.RandomAccessFile;

public class SetStar {
     String setStars(String filename)  {
        StringBuilder builder = new StringBuilder(50);
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            long allBytes = raf.length();
            for (int i = 9; i < allBytes; i += 10) {
                raf.seek(i);
                builder.append((char) raf.readUnsignedByte());
                raf.seek(i);
                char setSymbol = (char) '*';
                raf.writeByte(setSymbol);
            }
        } catch (Throwable e) {
            //throw new Throwable(e.getClass().getName());
        }
        return builder.toString();
    }

    public static void main(String[] args) throws Throwable {
        System.out.println(new SetStar().setStars("src/ru/progwards/java1/test10.txt"));
    }
}
