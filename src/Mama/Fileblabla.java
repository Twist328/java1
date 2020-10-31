package Mama;

import java.util.Scanner;

class Scannerblabla {
    public void scanLines() {
        String str = "Привет!";
        String str1 = "как дела?";
        String str2 = "/stop";
        String str3 = "Как погода?";
        String str4 = "Мой друг, Привет тебе, привет!";
        String str5 = "Как настроение?";
        String str6 = "У тебя сейчас как дела??";
        try (Scanner scanner = new Scanner(System.in)) {
            if (str2 == scanner.nextLine()) {
                scanner.close();
                System.out.println("/stop");
                str = scanner.nextLine();
                System.out.println("Здравствуйте!");
                str1 = scanner.nextLine();
                System.out.println("Хорошо");
                try {
                    if (str3 == scanner.nextLine()) {
                        System.out.println("Как погода?");
                        System.out.println("Здравствуйте!");
                        System.out.println("Как настроение?");
                        System.out.println("Хорошо");
                        while (str2 == scanner.nextLine()) {
                            scanner.close();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}


// boolean contains(String str){

//}