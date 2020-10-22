package ru.progwards.java1.lessons.io1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.System.*;

public class LineCount {
    public static int calcEmpty(String fileName) throws IOException {
        int calcEmpty = 0;
        try {
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNextLine()) {
                String data = input.nextLine();
                calcEmpty++;
            }
            return calcEmpty;
        } catch (IOException e) {
            throw new IOException(String.valueOf(-1));
        }
    }

    public static void main(String[] args) throws IOException {
        LineCount fileName = new LineCount();
        throw new IOException(String.valueOf(-1));
    }
}