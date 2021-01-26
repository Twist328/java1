package ru.progwards.java1.lessons.io2;

import java.util.Scanner;

public class ScanLines {
    public void scanLines(){
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

}
