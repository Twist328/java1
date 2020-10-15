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
    public String test(String filename) throws IOException {
        try {

        } catch (NullPointerException e) {

        } finally {

            if (filename == null) {
                return "File not found";

            } else {

                    return "File processing";
                }
            }
        }
    }



