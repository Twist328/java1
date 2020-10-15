package Tvist328;

import java.io.FileWriter;
import java.io.IOException;

class Exception1 {
    public Integer sqr(Integer n) {// ОБРАБОТКА ИСКЛЮЧЕНИЯ ПРИ МЕТОДЕ вычисления квадрата переданного числа
        try {
            int x = n;
            int res = 0;
            res = x * x;
            return res;
        } catch (NullPointerException e) {

        } finally {
            if (n == null)
                return -1; //ЗДЕСЬ МОЖЕТ БЫТЬ ЛЮБОЕ ЗАДАННОЕ ЗНАЧЕНИЕ КОТОРОЕ НУЖНО ВЕРНУТЬ
            // ПРИ возникновении ИСКЛЮЧЕНИЯ NullPointerException
        }
        return n;
    }


    //public static void main(String[] args) {


     public static String test(String filename) throws IOException {
       // try {
            //if (filename == null)
               // return String.valueOf(0);
       // } catch (NullPointerException e) {
           // return String.valueOf(1);

            if (filename == null) {
                //System.out.println("IOException");

                return  "java.io.IOException File not found\n";

            } else {

                return  "File processing";
            }
    }
            public static void main(String[] args) throws IOException {
                System.out.println( test(null));
            }
        }




