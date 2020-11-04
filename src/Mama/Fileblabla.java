package Mama;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import java.io.*;

class Scannerblabla {
    public static void scanLines() {
        String str = "Привет!";
        String str1 = "как дела?";
        String str2 = "/stop";
        String str6 = "Как погода?\nМой друг, Привет тебе, привет!\nКак настроение?\nУ тебя сейчас как дела?";
        String str3 = "Здравствуйте!\nХорошо";
        String str4 = "Как погода?";
        String str5 = "Хорошо";
        String str7 = "Как погода?\nЗдравствуйте!\nКак настроение?\nХорошо";

        try (Scanner in = new Scanner(System.in)) {
            while (true) {
                str = in.nextLine();
                System.out.println(str3);
                if (!(str2 == in.nextLine())) {

                    break;

                }
                try (Scanner scanner = new Scanner(System.in)) {
                    while (true) {
                        str6 = scanner.nextLine();
                        System.out.println(str7);
                        if (!(str2 == scanner.nextLine())) {

                            break;

                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scannerblabla scannerblabla = new Scannerblabla();
        scanLines();
        //System.out.println(scannerblabla);
    }
}

// boolean contains(String str){

//}