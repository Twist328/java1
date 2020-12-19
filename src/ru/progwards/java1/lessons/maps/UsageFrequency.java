package ru.progwards.java1.lessons.maps;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class UsageFrequency {

    static Map<Character, Integer> ALPFABET;

    static Map<String, Integer> SPEECH;


    public static void processFile(String fileName) {     // загрузить содержимое файла
        ALPFABET = new HashMap<Character, Integer>(5000);
        SPEECH = new HashMap<String, Integer>(5000);
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
        //System.out.println(str);   // ПРОСМОТР текста файлов wiki ДО ИЗМЕНЕНИЙ по подсчету
        int wordIndex = -1;
        Character keyChar;
        String keySpeech;
        int strSize = str.length();
        for (int i = 0; i < strSize; i++) {
            keyChar = str.charAt(i);

            if (Character.isLetterOrDigit(keyChar)) {
                ALPFABET.put(keyChar, ALPFABET.containsKey(keyChar) ? 1 + ALPFABET.get(keyChar) : 1);
                if (wordIndex < 0) wordIndex = i;
            } else {
                if (wordIndex >= 0) {
                    keySpeech = str.substring(wordIndex, i);
                    SPEECH.put(keySpeech, SPEECH.containsKey(keySpeech) ? 1 + SPEECH.get(keySpeech) : 1);
                    wordIndex = -1;
                }
            }
        }
        if (wordIndex >= 0) {
            keySpeech = str.substring(wordIndex, strSize);
            SPEECH.put(keySpeech, SPEECH.containsKey(keySpeech) ? 1 + SPEECH.get(keySpeech) : 1);
        }
    }

    public static Map<Character, Integer> getLetters() {     // вернуть Map, который содержит все найденные буквы и цифры
        return ALPFABET;
    }   //вернуть (буквы) символы
    public static Map<String, Integer> getWords() {     // вернуть Map, который содержит все найденные слова
        return SPEECH;
    } //  вернуть слова

    public static void main(String[] args) {

        processFile("..\\java1\\src\\ru\\progwards\\java1\\lessons\\maps\\wiki.test.tokens");
        processFile("..\\java1\\src\\ru\\progwards\\java1\\lessons\\maps\\wiki.train.tokens");
        // processFile("..\\java1\\src\\ru\\progwards\\java1\\lessons\\maps\\UsageFrequency.java");
        System.out.println(getLetters());
        System.out.println(getWords());
    }
}