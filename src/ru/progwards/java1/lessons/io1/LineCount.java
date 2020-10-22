package ru.progwards.java1.lessons.io1;

import java.io.*;
import java.util.Scanner;

public class LineCount {
    public static int calcEmpty(String fileName) throws IOException,ArithmeticException,FileNotFoundException {
        final BufferedReader br = new BufferedReader(new StringReader("hello\n\nworld\n\ni\n\nam\n\npiter"));
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
        LineCount calcEmpty = new LineCount();
        System.out.println(calcEmpty(null));
    }
}