package ru.progwards.java1.lessons.io2;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class Censor {

    public static String repeatStr(String value, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = count; i > 0; i--) sb.append(value);
        return sb.toString();
    }

    static class CensorException extends RuntimeException {

        String errorName;
        String fileName;

        CensorException(String errorName, String fileName) {
            this.errorName = errorName;
            this.fileName = fileName;
        }

        @Override
        public String toString() {
            return errorName + ":" + fileName;
        }
    }

    public static void censorFile(String inoutFileName, String[] obscene) {
        if (inoutFileName == null || inoutFileName.compareTo("") == 0)
            throw new CensorException("Проверить имя файла!", inoutFileName);
        if (obscene == null) throw new CensorException("Проверить последовательность символов в файле!", inoutFileName);
        int len;
        String[] baks;
        try {
            len = obscene.length;
            baks = new String[len];
            for (int i = 0; i < len; i++) {

                baks[i] = repeatStr("~", obscene[i].length());
            }
        } catch (Exception e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }
        String tmpFileName = inoutFileName + ".tmp";
        String lineSeparator = System.getProperty("line.separator");
        boolean firstLine = true;
        try (FileReader fr = new FileReader(inoutFileName);
             Scanner scan = new Scanner(fr);
             FileWriter fw = new FileWriter(tmpFileName)) {

            while (scan.hasNext()) {
                if (firstLine) {
                    firstLine = false;
                } else {
                    fw.write(lineSeparator);
                }
                String str = scan.nextLine();
                for (int i = len - 1; i >= 0; i--) {
                    str = str.replace(obscene[i], baks[i]);
                }
                fw.write(str);
            }
        } catch (IOException e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }
        try {
            File file = new File(inoutFileName);
            file.delete();
            File name = new File(tmpFileName);
            name.renameTo(file);
        } catch (Exception e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }
    }

    public static void main(String[] args) {
        Censor censor = new Censor();
        censorFile("src/ru/progwards/java1/lessons/censor.txt", new String[]{"Java","объектно","ориентированный","Oracle", "Sun", "Microsystems"}); //Здесь можно вбить и другие слова из файла
        System.out.println(censor.getClass());
    }
}
// ДЛЯ ОТЛАДКИ (ВСТАВКИ) В ФАЙЛ censor.txt ПЕРВОНАЧАЛЬНОЙ ОРИГИНАЛЬНОЙ СТРОКИ:
// Java — строго типизированный объектно-ориентированный язык программирования, разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle).
// ПОЛУЧАЕТСЯ после проверки в мейн, в файле : **** — строго типизированный объектно-ориентированный язык программирования, разработанный компанией *** ************ (в последующем приобретённой компанией ******).
// "src/ru/progwards/java1/lessons/censor.txt"