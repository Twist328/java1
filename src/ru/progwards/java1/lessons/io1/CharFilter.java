package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        FileReader reader = new FileReader(inFileName);
        FileWriter writer = new FileWriter(outFileName);
        char [] filterSymbols = filter.toCharArray();
        int symbol;
        while ((symbol = reader.read()) != -1) {
            int n = 0;
            for (int i = 0; i < filterSymbols.length; i++) {
                if (filterSymbols[i] == (char)symbol) {
                    n = n + 1;
                }
            }
            if (n == 0) {
                writer.write(symbol);
            }
        }
        writer.close();
        reader.close();
    }
}
