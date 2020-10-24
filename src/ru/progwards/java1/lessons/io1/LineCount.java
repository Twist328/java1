package ru.progwards.java1.lessons.io1;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.stream.Stream;

public class LineCount {
    private static String result;

    public static  int calcEmpty(String fileName) throws NumberFormatException, NullPointerException, RuntimeException {
        try {
           // String str1 =result;
            int empty = 0;
            String line = "";
             BufferedReader buffeR = new BufferedReader(new StringReader(""));
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
            //empty = Integer.parseInt(fileName.substring(Integer.parseInt(str1)));
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