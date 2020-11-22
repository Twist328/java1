package ru.progwards.java1.lessons.io2;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class Censor {

    /*public static String repeatStr(String value, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(value);
        }
        return builder.toString();
    }

                                       ЕЩЕ РАБОТАЮЩИЕ  МЕТОДЫ repeat() В НАШЕМ КОНТЕКСТЕ:
            1)

    public static String repeatStr0(String value, int count) {
        return count == 1 ? value : (count % 2 == 0 ? repeatStr0(value + value, count / 2) : value + repeatStr0(value + value, (count - 1) / 2));//   - РЕКУРСИЯ;
    }
            2)

    public static String repeatStr1(String value, int count) {
        if (count <= 0) {
            return "";
        } else {
            return value + repeatStr1(value, count - 1);
        }
           3)
        public static String repeatStr2 (String value,int count){
            String tmp = "";
            for (int i = 0; i < count; i++) {
                tmp += value;
            }
            return tmp;
        }
           4)
        public static String repeatStr3 (String value,int count){
            StringBuilder sb = new StringBuilder(count);
            for (int i = count; i > 0; i--) {
                sb.append(value);
            }
            return sb.toString();
        }*/

    /*public static String repeatStr(String value, int count) {
        char[] sample = value.toCharArray();
        char[] res = new char[count * sample.length];
        int len = sample.length;
        for (int i = 0; i < count; i++)

            System.arraycopy(sample, 0, res, i * len, len);

            return new String(res);*/
    public static String repeatStr(String value, int count) {
        char[] sample = value.toCharArray();
        char[] res = new char[count * sample.length];
        int len = sample.length;
        for (int i = 0; i < count; i++)
            System.arraycopy(sample, 0, res, i * len, len);
        return new String(res);

    }

    static class CensorException extends RuntimeException {

        String errorName;
        String fileName;

        @Override
        public String toString() {
            return errorName + ":" + fileName;

        }

        public CensorException(String errorName, String fileName) {
            this.errorName = errorName;
            this.fileName = fileName;
        }

    }

    public static void censorFile(String inoutFileName, String[] obscene) {
        if (inoutFileName == null || inoutFileName.compareTo("") == 0)
            throw new CensorException("Проверить имя файла!", inoutFileName);
        if (obscene == null)
            throw new CensorException("Проверить последовательность символов в файле!", inoutFileName);
        int len;
        String[] znak;
        try {
            len = obscene.length;
            znak = new String[len];
            for (int i = 0; i < len; i++) {

                znak[i] = repeatStr("*", obscene[i].length()); //value может быть любой символ или знак или цифра(буква) в зависимости от услович задачи
            }
        } catch (Exception e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }
        String tmpFileName = inoutFileName + ".tmp"; // временный файл, который можно использовать как обычный до момента окончания программы (обычно потом удаляется)

        String lineSeparator = System.getProperty("line.separator");

        /*Если запустить это: System.getProperty("line.separator"), ТО\n
         он вернет разделитель строк, используемый в данной ОС: - в W-s он вернет \r\n, а в Unix он вернет \n.*/

        boolean nextLine = true;
        try (FileReader reader = new FileReader(inoutFileName);
             Scanner scan = new Scanner(reader);
             FileWriter writer = new FileWriter(tmpFileName)) {

            while (scan.hasNext()) {
                if (nextLine) {
                    nextLine = false;
                } else {
                    writer.write(lineSeparator);
                }
                String str = scan.nextLine();
                for (int i = len - 1; i >= 0; i--) {
                    str = str.replace(obscene[i], znak[i]);
                }
                writer.write(str);
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
        censorFile("src/ru/progwards/java1/lessons/censor.txt", new String[]{"Java", "Oracle", "Sun", "Microsystems"});


//Здесь можно вбить и другие слова из файла censor.txt, и варьировать результатом censorFile()
        System.out.println(censor.getClass());
    }
}

/*ДЛЯ ОТЛАДКИ (ВСТАВКИ) В ФАЙЛ censor.txt ПЕРВОНАЧАЛЬНОЙ ОРИГИНАЛЬНОЙ СТРОКИ:
 Java — строго типизированный объектно-ориентированный язык программирования, разработанный компанией Sun Microsystems (в последующем приобретённой компанией Oracle).
 НУЖЕН РЕЗУЛЬТАТ: после проверки в мейн, в файле : **** — строго типизированный ********-*************** язык программирования,\n
 разработанный компанией *** ************ (в последующем приобретённой компанией ******)- Это по заданию, но: можно менять слова в String[]obscene и соответственно
 будет меняться результат;
 путь к файлу :   "src/ru/progwards/java1/lessons/censor.txt"*/