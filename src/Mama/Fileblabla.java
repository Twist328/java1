package Mama;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

class Scannerblabla {
    public static void scanLines() {
        String str = "Привет!";
        String str1 = "как дела?";
        String str2 = "/stop";
        // String str2 = "Как погода?\nМой друг, Привет тебе, привет!\nКак настроение?\nУ тебя сейчас как дела?";
        String str3 = "Здравствуйте!";
        String str4 = "Как погода?";
        String str5 = "Хорошо";

        try (Scanner scanner = new Scanner(System.in)) {

            str = scanner.nextLine();
            System.out.println(str3);
            str1 = scanner.nextLine();
            System.out.println(str5);
            str4=scanner.nextLine();
            System.out.println(str4);
            while (str2 == "/stop") {
                scanner.close();
            }
                System.out.println(str4);
                str1 = scanner.nextLine();
                scanner.close();
            }

        }

    public static void main(String[] args) {
        Scannerblabla scannerblabla=new Scannerblabla();
        scanLines();
        System.out.println(scannerblabla);
    }
}

// boolean contains(String str){

//}