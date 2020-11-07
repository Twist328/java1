package Mama;

import java.util.Scanner;

public class INvertString {
   /* Реализуйте метод с сигнатурой public String invertWords(String sentence), который переставляет слова,
    в полученной фразе.
   В качестве исходного разделителя использовать пробел. В качестве соединительного точку.
    Например,
    invertWords("Буря мглою небо кроет") должен вернуть
"кроет.небо.мглою.Буря"*/

    static String invertWords(String sentence) {

        Scanner in = new Scanner(sentence);

        System.out.print("");

        String origString = in.nextLine();
        in.close();

        String[] words = origString.split("\\s");
        String reversedString = " ";

        //Перевернем положение каждого слова
        for (int i = 0; i < words.length; i++) {
            if (i == words.length - 1)
                reversedString = words[i] + reversedString;
            else
                reversedString = "." + words[i] + reversedString;
        }

        // Отображение строки после реверса
        System.out.print("" + reversedString);
        return "";
    }

    public static void main(String[] args) {
        INvertString iNvertString = new INvertString();
        invertWords("Буря мглою небо кроет");
        invertWords("Java это строго типизированный объектно-ориентированный язык программирования");
        invertWords("Hello World!");
    }
}