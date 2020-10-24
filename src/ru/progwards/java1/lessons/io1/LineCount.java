package ru.progwards.java1.lessons.io1;

import java.io.*;
import java.util.Scanner;

public class LineCount {
    public static <line> int calcEmpty(String fileName) throws NumberFormatException, NullPointerException, IOException {
        try {
            int empty = 0;
            String line;

            final BufferedReader buffeR = new BufferedReader(new StringReader("hello\n\nworld\n\ni\n\nam\n\nevgeniy\n\nshevelev\n\n!"));
            while ((line = buffeR.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    empty++;
                }
            }
            return empty;
        } catch (NumberFormatException e) {

            throw new IOException(String.valueOf(-1));
        }
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        LineCount calcEmpty = new LineCount();
        //calcEmpty(String.valueOf(8));
        //throw new NumberFormatException(String.valueOf(-1));
        System.out.println(calcEmpty(String.valueOf(100)));
    }
}