package Mama;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

class Scannerblabla {
    public static void scanLines() {
        String str = "Привет!";
        String str1 = "как дела?";
        String str2 = "/stop";
        String str6 = "Как погода?\nМой друг, Привет тебе, привет!\nКак настроение?\nУ тебя сейчас как дела?";
        String str3 = "Здравствуйте!";
        String str4 = "Как погода?";
        String str5 = "Хорошо";
        String str7 = "Как погода?\nЗдравствуйте!\nКак настроение?\nХорошо";


        try (Scanner sc = new Scanner(System.in)) {
            while (true) {
                str = sc.nextLine();
                System.out.println(str3);
                str1 = sc.nextLine();
                System.out.println(str5);
                if (str2 == String.valueOf(false)) ;
                sc.close();
                break;
            }


                    try (Scanner scan = new Scanner(System.in)) {
                        str6 = scan.nextLine();
                        System.out.println(str7);
                        str2 = scan.nextLine();
                        System.out.println();
                        scan.close();



                    }
                }
            }



                            public static void main (String[]args){
                            Scannerblabla scannerblabla = new Scannerblabla();
                            scanLines();
                            System.out.println(scannerblabla);
                        }
                    }

// boolean contains(String str){

//}