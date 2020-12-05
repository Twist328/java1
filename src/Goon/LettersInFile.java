package Goon;

import javax.xml.stream.events.Characters;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

public class LettersInFile {
    public static String processBest(String fileName) throws IOException {
        String letter = "";
        FileReader reader = new FileReader(fileName);
        Scanner scanner = new Scanner(reader);
        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            str.toCharArray();
            char[] charArray = str.toCharArray();
            for (char doChar : charArray) {
                if (Character.isLetter(doChar)) {
                    if (letter.indexOf(doChar) == -1) letter += doChar;
                }
            }
        }
        scanner.close();
        reader.close();

        char[] charArray = letter.toCharArray();
        List<Character> charList = new ArrayList<Character>();
        for (char doChar : charArray) {
            charList.add(doChar);
        }
        Collections.sort(charList);
        StringBuilder sB = new StringBuilder(50);
        for (Character doChar : charList) {
            sB.append(doChar);
        }
        return sB.toString();
    }

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
        for (char doChar:charList) {
            sB.append(doChar);
        }
          return sB.toString();
        }

    public static void main(String[] args) throws IOException {
        System.out.println(process("src/ru/progwards/java1/lessons/sets/process.txt"));
        System.out.println(processBest("src/ru/progwards/java1/lessons/sets/process.txt"));
    }
    }