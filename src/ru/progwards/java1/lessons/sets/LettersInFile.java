package ru.progwards.java1.lessons.sets;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class LettersInFile {

    public static String process(String fileName) throws IOException {

        Set<Character> charSet = new HashSet<Character>();
        FileReader reader = new FileReader(fileName);
        Scanner scan = new Scanner(reader);
        while (scan.hasNextLine()) {
            String str = scan.nextLine();
            str.toCharArray();
            char[] charArray = str.toCharArray();
            for (char doChar : charArray) {
                if (Character.isLetter(doChar)) charSet.add(doChar);
            }
        }
        scan.close();
        reader.close();

        List<Character> charList = new ArrayList<Character>(charSet);
        Collections.sort(charList);
        StringBuilder sB = new StringBuilder(50);
        for (char doChar : charList) {
            sB.append(doChar);
        }
        return sB.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println(process("src/ru/progwards/java1/lessons/sets/process.txt"));
    }
}
