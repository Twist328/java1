package ru.progwards.java1.lessons.io1;

import java.io.*;
import java.util.Scanner;

public class LineCount {
    public static int calcEmpty(String fileName) throws NumberFormatException, IOException {
        int empty = 0;String line;

        try {
            final BufferedReader br = new BufferedReader(new StringReader("hello\n\nworld\n\ni\n\nam\n\npiter\n\n!"));
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    empty++;
                }
            }
             }catch (Exception e){
            System.out.println(empty);
            throw new NumberFormatException(String.valueOf("-1"));
        } finally {
            if (fileName == String.valueOf(0))
                return -1;
        }
        return empty;
    }

    public static void main(String[] args) throws IOException, NumberFormatException {
        LineCount calcEmpty = new LineCount();
        // calcEmpty(String.valueOf(8));
        //throw new NumberFormatException(String.valueOf(-1));
        System.out.println(calcEmpty(String.valueOf(1)));
    }
}