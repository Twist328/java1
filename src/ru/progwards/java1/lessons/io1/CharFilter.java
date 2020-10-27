package ru.progwards.java1.lessons.io1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CharFilter {
    public static void filterFile(String inFileName, String outFileName, String filter) throws IOException {
        FileReader reader = new FileReader(inFileName);
        FileWriter writer = new FileWriter(outFileName);
        char[] filterZnaki = filter.toCharArray();
        int znak;
        while ((znak = reader.read()) != -1) {
            int parol = 0;
            for (int i = 0; i < filterZnaki.length; i++) {
                if (filterZnaki[i] == (char) znak) {
                    parol += 1;
                }
            }
            if (parol == 0) {
                writer.write(znak);
            }
        }
        writer.close();
        reader.close();
    }
}
