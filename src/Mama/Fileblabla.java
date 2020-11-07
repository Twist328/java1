package Mama;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.*;

public class Fileblabla {
    public static void scanLines() {

       /* Создайте метод с сигнатурой public void scanLines(), который реализует следующий алгоритм:
        - вводить с клавиатуры строки, до тех пор, пока во входной строке не встретится "/stop"
                - если во входной строке содержится "Привет" вывести на консоль "Здравствуйте!"
                - если во входной строке содержится "как дела" вывести на консоль "Хорошо"
                - если во входной строке содержится "/stop" - закончить выполнение метода
        - во всех остальных случая вывести введенную строку на консоль
        Примечание: для проверки, содержит ли строка, содержимое другой строки используйте метод класса String boolean contains(String str)*/

        try (Scanner in = new Scanner(System.in)) {
            String str;
            while (true) {
                str = in.nextLine();
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
        Fileblabla scannerblabla = new Fileblabla();
        scanLines();

    }
}

