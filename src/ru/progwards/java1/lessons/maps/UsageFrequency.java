package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class UsageFrequency {

    static Map<Character, Integer> alphabet;

    static Map<String, Integer> speech;


    public static void processFile(String fileName) {     // загрузить содержимое файла
        alphabet = new HashMap<Character, Integer>(2500);
        speech = new HashMap<String, Integer>(5000);
        try (FileReader rider = new FileReader(fileName);
             Scanner scan = new Scanner(rider)) {
            while (scan.hasNext()) {
                processLine(scan.nextLine());
            }
        } catch (IOException e) {
            throw new RuntimeException(fileName + ":\n" + e.getMessage());
        }
    }

    // загрузить содержимое строки
    private static void processLine(String str) {
        //System.out.println(str);
        int speechIndex = -1;
        Character keyChar;
        String keySpeech;
        int strSize = str.length();
        for (int i = 0; i < strSize; i++) {
            keyChar = str.charAt(i);

            if (Character.isLetterOrDigit(keyChar)) {
                alphabet.put(keyChar, alphabet.containsKey(keyChar) ? 1 + alphabet.get(keyChar) : 1);
                if (speechIndex < 0) speechIndex = i;
            } else {
                if (speechIndex >= 0) {
                    keySpeech = str.substring(speechIndex, i);
                    speech.put(keySpeech, speech.containsKey(keySpeech) ? 1 + speech.get(keySpeech) : 1);
                    speechIndex = -1;
                }
            }
        }
        if (speechIndex >= 0) {
            keySpeech = str.substring(speechIndex, strSize);
            speech.put(keySpeech, speech.containsKey(keySpeech) ? 1 + speech.get(keySpeech) : 1);
        }
    }

    public static Map<Character, Integer> getLetters() {     // вернуть Map, который содержит все найденные буквы и цифры
        return alphabet;
    }
    public static Map<String, Integer> getWords() {     // вернуть Map, который содержит все найденные слова
        return speech;
    }

    public static void main(String[] args) {

       // processFile("..\\java1\\src\\ru\\progwards\\java1\\lessons\\maps\\UsageFrequency.java");
        processFile("..\\java1\\src\\ru\\progwards\\java1\\lessons\\maps\\wiki.test.tokens");
        processFile("..\\java1\\src\\ru\\progwards\\java1\\lessons\\maps\\wiki.train.tokens");
        System.out.println(getLetters());
        System.out.println(getWords());
    }
}