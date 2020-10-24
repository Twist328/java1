package ru.progwards.java1.lessons.io1;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.stream.Stream;

public class LineCount {
    public static  int calcEmpty(String fileName) throws NumberFormatException, NullPointerException, RuntimeException {
        try {
            int empty = 0;
            String line = "";
            final BufferedReader buffeR = new BufferedReader(new StringReader("hello\n\nworld\n\ni\n\nam\n\nevgeniy\n\nshevelev\n\n!"));
            while (true) {
                try {
                    if (!((line = buffeR.readLine()) != null)) break;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                if (line.trim().isEmpty()) {
                    empty++;
                }
            }
            return empty;
        } catch (NumberFormatException e) {
            throw new NullPointerException(String.valueOf(-1));
        }
    }
    public static void main(String[] args) throws Exception {
        LineCount calcEmpty = new LineCount();

        System.out.println(calcEmpty(String.valueOf(100)));
    }
}