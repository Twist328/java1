package ru.progwards.java1.lessons.io1;

import java.io.*;
import java.util.Scanner;

import static java.lang.System.*;

public class LineCount {
    public static int calcEmpty(String fileName) throws IOException {
        final BufferedReader br = new BufferedReader(new StringReader("hello\n\nworld\n"));
        String line;
        int empty = 0;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) {
                empty++;
            }
        }
        System.out.println(empty);

       /*/ int calcEmpty = 0;
        try {
            Scanner input = new Scanner(new File(fileName));
            while (input.hasNextLine()) {
                String data = input.nextLine();
                calcEmpty++;
            }
            return calcEmpty;
        } catch (IOException e) {
            throw new IOException(String.valueOf(-1));/*/

        return empty;
    }
    public static void main(String[] args) throws IOException {
        LineCount fileName = new LineCount();
        throw new IOException(String.valueOf(-1));
    }
}