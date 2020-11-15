package ru.progwards.java1.lessons.io2;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Censor {

    public static String repeatStr(String value, int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = count; i > 0; i--) sb.append(value);
        return sb.toString();
    }

    static class CensorException extends RuntimeException {

        String errName;
        String fileName;

        CensorException(String errName, String fileName) {
            this.errName = errName;
            this.fileName = fileName;
        }

        @Override
        public String toString() {
            return errName + ":" + fileName;
        }
    }

    public static void censorFile(String inoutFileName, String[] obscene) {
        if (inoutFileName == null || inoutFileName.compareTo("") == 0)
            throw new CensorException("Проверить имя файла!", inoutFileName);
        if (obscene == null) throw new CensorException("Проверить последовательность символов!", inoutFileName);
        int obLen;
        String[] stars;
        try {
            obLen = obscene.length;
            stars = new String[obLen];
            for (int i = 0; i < obLen; i++) {

                stars[i] = repeatStr("*", obscene[i].length());
            }
        } catch (Exception e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }
        String tmpFileName = inoutFileName + ".tmp";
        String lineSeparator = System.getProperty("line.separator");
        boolean firstLine = true;
        try (FileReader r = new FileReader(inoutFileName);
             Scanner scan = new Scanner(r);
             FileWriter fw = new FileWriter(tmpFileName)) {

            while (scan.hasNext()) {
                if (firstLine) {
                    firstLine = false;
                } else {
                    fw.write(lineSeparator);
                }
                String str = scan.nextLine();
                for (int i = obLen - 1; i >= 0; i--) {
                    str = str.replace(obscene[i], stars[i]);
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
        censorFile("src/ru/progwards/java1/lessons/censor.txt", new String[]{"Java", "Oracle", "Sun", "Microsystems"});
    }
}


