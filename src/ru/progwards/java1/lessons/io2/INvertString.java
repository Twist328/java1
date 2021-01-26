package ru.progwards.java1.lessons.io2;

import java.io.RandomAccessFile;
import java.util.Scanner;

public class INvertString {
   /* Реализуйте метод с сигнатурой public String invertWords(String sentence), который переставляет слова,
    в полученной фразе.
   В качестве исходного разделителя использовать пробел. В качестве соединительного точку.
    Например,
    invertWords("Буря мглою небо кроет") должен вернуть
"кроет.небо.мглою.Буря"*/

    static String invertWords(String sentence) {

        String[] str = sentence.split(" ");
        StringBuilder builder = new StringBuilder(30);
        for (int i = str.length - 1; i >= 0; i--) {
            builder.append(str[i]);
            if (i > 0) builder.append('.');
        }
        return builder.toString();
    }
    public static void scanLines() {
        /*
Создайте метод с сигнатурой public void scanLines(), который реализует следующий алгоритм:
- вводить с клавиатуры строки, до тех пор, пока во входной строке не встретится "/stop"
- если во входной строке содержится "Привет" вывести на консоль "Здравствуйте!"
- если во входной строке содержится "как дела" вывести на консоль "Хорошо"
- если во входной строке содержится "/stop" - закончить выполнение метода
- во всех остальных случая вывести введенную строку на консоль
Примечание: для проверки, содержит ли строка, содержимое другой строки используйте метод класса
String boolean contains(String str)
*/
        try (Scanner scanner = new Scanner(System.in)) {
            String str;
            while (true) {
                str = scanner.nextLine();
                if (str.contains("Привет!")) {
                    System.out.println("Здравствуйте!");
                } else if (str.contains("как дела?")) {
                    System.out.println("Хорошо");
                } else if (str.contains("Как погода?")) {
                    System.out.println("Как погода?");
                } else if (str.contains("Мой друг, Привет тебе, привет!")) {
                    System.out.println("Здравствуйте!");
                } else if (str.contains("Как настроение?")) {
                    System.out.println("Как настроение?");
                } else if (str.contains("У тебя сейчас как дела?")) {
                    System.out.println("Хорошо");

                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        INvertString iNvertString = new INvertString();
        System.out.println(invertWords("Буря мглою небо кроет"));
        System.out.println(invertWords(invertWords
                ("Java это строго типизированный объектно-ориентированный язык программирования")));
        System.out.println(invertWords("Hello World!"));
        scanLines();


    }
}
