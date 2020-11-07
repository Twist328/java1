package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.util.Scanner;

public class LineCount {
    public static int calcEmpty(String fileName) {
        int empty = 0;
        try {
            FileReader reader = new FileReader(fileName);
            try {
                Scanner scanner = new Scanner(reader);
                while (scanner.hasNextLine()) {
                    String str = scanner.nextLine();
                    if (str ==("")) {   //if (str1.equals("")) {  ВРОДЕ КАК ОДНО И ТОЖЕ...
                        empty++;
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
        return empty;
    }

    public static void main(String[] args)  {
        LineCount  lineCount = new LineCount();
        calcEmpty(("100"));
    }
}