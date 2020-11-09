package Mama;

import java.util.Scanner;

public class SpaseString {
    //ПОЛНЫЙ РАЗВОРОТ СТРОКИ, ТОЧКИ ВМЕСТО ПРОБЕЛОВ
    static String invertWords(String sentence) {
        try (Scanner scanner = new Scanner(sentence)) {
            System.out.print("");

            String origString = scanner.nextLine();
            scanner.close();

            String[] words = origString.split("\\s");
            String reversedString = "";

            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                String reverseWord = ".";//МОЖНО УБРАТЬ ТОЧКИ МЕЖДУ СЛОВАМИ СТРОКИ УБРАВ ТОЧКУ))
                for (int j = word.length() - 1; j >= 0; j--) {
                    reverseWord = reverseWord + word.charAt(j);
                }
                reversedString = reverseWord + reversedString + " ";//МЕНЯЯ МЕСТАМИ СЛАГАЕМЫЕ МЕНЯЕШЬ И ЗЕРКАЛЬНОСТЬ
               // СЛОВ В СТРОКЕ, Т,Е МОЖНО РАЗВЕРНУТЬ НЕ ТОЛЬКО СЛОВО НО И ВСЮ СТРОКУ
            }

            // ОТОБРАЖЕНИЕ СТРОКИ ПОСЛЕ РАЗВОРОТА
            System.out.print("Reversed string : " + reversedString);
            return "";
        }

    }
    public static void main(String[] args) {
        SpaseString spaseString = new SpaseString();
        invertWords("ЧТОБЫ ТЫ НЕ ДЕЛАЛ\n\n");
        invertWords("Java это тема \n\n");
        invertWords("Hello World!\n\n");
    }
}
