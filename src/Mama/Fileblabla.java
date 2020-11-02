package Mama;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

class Scannerblabla {
    public static void scanLines() {
        String str = "Привет!\nкак дела?";
        String str1 = "как дела?";
        String str2 = "/stop";
        String str6 = "Как погода?\nМой друг, Привет тебе, привет!\nКак настроение?\nУ тебя сейчас как дела?";
        String str3 = "Здравствуйте!\nХорошо";
        String str4 = "Как погода?";
        String str5 = "Хорошо";
        String str7 = "Как погода?\nЗдравствуйте!\nКак настроение?\nХорошо";

        try (Scanner sc = new Scanner(System.in)) {

                while (sc.hasNextLine()) {
                    str = sc.nextLine();
                    System.out.println(str3);
                    str2 = sc.nextLine();
                    sc.close();

                    try (Scanner scan = new Scanner(System.in)) {
                        while (true) {
                            while (scan.hasNext()) {
                                str6 = scan.nextLine();
                                System.out.println(str7);
                                str2 = scan.nextLine();
                                scan.close();
                            }
                   /*/ str = sc.nextLine();
                    System.out.println(str3);
                    str1 = sc.nextLine();
                    System.out.println(str5);

                    while (true) {

                        try (Scanner scan = new Scanner(System.in)) {
                            while (scan.hasNext()) {
                                str6 = scan.nextLine();
                                System.out.println(str7);
                                str2 = Boolean.parseBoolean(scan.nextLine());
                                System.out.println();*/
                        }
                    }
                }

            }
        }



    public static void main(String[] args) {
        Scannerblabla scannerblabla = new Scannerblabla();
        scanLines();
        System.out.println(scannerblabla);
    }
}

// boolean contains(String str){

//}