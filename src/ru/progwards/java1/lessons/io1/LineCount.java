package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.util.Scanner;

public class LineCount {
    public static int calcEmpty(String fileName) {
        int ampty = 0;
        try {
            FileReader reader = new FileReader(fileName);
            try {
                Scanner scanner = new Scanner(reader);
                while (scanner.hasNextLine()) {
                    String strFromFile = scanner.nextLine();
                    if (strFromFile.equals("")) {
                        ampty++;
                    }
                }
            }
            finally {
                reader.close();
            }
        }
        catch (Exception e) {
            return -1;
        }
        return ampty;
    }

    public static void main(String[] args) throws Exception {
        LineCount calcEmpty = new LineCount();
        System.out.println(calcEmpty(String.valueOf(100)));
    }
}