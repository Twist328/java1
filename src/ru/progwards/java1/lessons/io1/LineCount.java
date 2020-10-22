package ru.progwards.java1.lessons.io1;

import java.io.*;
import java.util.Scanner;

public class LineCount {
    public static int calcEmpty(String fileName) throws IOException,ArithmeticException,FileNotFoundException {
        final BufferedReader br = new BufferedReader(new StringReader("hello\n\nworld\n\ni\n\nam\n\npiter\n\n!"));
        String line;
        int empty = 0;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) {
                empty++;
            }
        }
        System.out.println(empty);
        //if(empty == Integer.parseInt(null))
        throw new NumberFormatException(String.valueOf(-1));
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

    }
    public static void main(String[] args) throws IOException,NumberFormatException {
        LineCount calcEmpty = new LineCount();
        //throw new NumberFormatException(String.valueOf(-1));
        System.out.println(calcEmpty(null));
    }
}