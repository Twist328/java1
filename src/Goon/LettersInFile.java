package Goon;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LettersInFile {
    public static String process(String fileName) throws IOException {
        Set<Character> characterSet = new HashSet<Character>();
        FileReader reader = new FileReader(fileName);
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            str.toCharArray();
            char[] charArray = str.toCharArray();
            for (char doChar : charArray) {
                if (Character.isLetter(doChar)) characterSet.add(doChar);
            }
        }
        scanner.close();
        reader.close();
        return fileName;
    }
}