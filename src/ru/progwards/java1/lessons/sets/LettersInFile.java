package ru.progwards.java1.lessons.sets;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LettersInFile {

    public static String process(String fileName) throws IOException {
        Set<Character> set = new HashSet<Character>();
        FileReader reader = new FileReader(fileName);
        Scanner scan = new Scanner(reader);
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            str.toCharArray();
            char[] charArray = str.toCharArray();
            for (char aChar : charArray) {
                if (Character.isLetter(aChar)) set.add(aChar);
            }
        }
        scan.close();
        reader.close();

        List<Character> list = new ArrayList<>(set);
        Collections.sort(list);
        StringBuilder sB = new StringBuilder(100);
        for (Character aChar : list) {
            sB.append(aChar);
        }
        return sB.toString();
    }
}
