package Tvist328;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;
import java.util.stream.Stream;

public class ZapisVFiles {
    private static int lineCount(String filename) throws NumberFormatException, IOException {
        int lineCount = 0; //В ДАННОЙ ЗАДАЧЕ НУЖНО БЫЛО ВЫЧИСЛИТЬ КОЛИЧЕСТВО СТРОК filename И СДЕЛАТЬ ПРОБРОС ИСКЛЮЧЕНИЙ
        try {

            Scanner input = new Scanner(new File(filename));
            while (input.hasNextLine()) {
                String data = input.nextLine();

                lineCount++;
            }
            return lineCount;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("файл не найден"); //ВОТ ОН ПРОБРОС (ПОМОГАЕЕТ ИЗБЕГАТЬ ВОЗВРАЩАТЬ НУЛЕВОЕ ЗНАЧЕНИЕ
        }

    }

    public static void main(String[] args) throws IOException {
        ZapisVFiles filename = new ZapisVFiles();
        //if (filename == null)
       // System.out.println("файл не найден");
            System.out.println(lineCount(String.valueOf((1))));
        }
    }


   /*/ static void lineCounter (String path) throws IOException {

        int lineCount = 0, commentsCount = 0;

        Scanner input = new Scanner(new File(path));
        while (input.hasNextLine()) {
            String data = input.nextLine();

            if (data.startsWith("//")) commentsCount++;

            lineCount++;
        }

        System.out.println("Line Count: " + lineCount + "\t Comments Count: " + commentsCount);
    }/*/
