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

    public static void censorFile1(String inoutFileName, String[] obscene) {
        int obLen = obscene.length;
        String[] stars = new String[obLen];
        for (int i = 0; i < obLen; i++) {
            stars[i] = repeatStr("*", obscene[i].length());
        }
        Translator tr = new Translator(obscene, stars);
        String tmpFileName = inoutFileName + ".tmp";
        String lineSeparator = System.getProperty("line.separator");
        try (FileReader fr = new FileReader(inoutFileName);
             Scanner scan = new Scanner(fr); FileWriter w = new FileWriter(tmpFileName)) {

            while (scan.hasNext()) {
                String str = scan.nextLine();
                str = tr.translate(str + lineSeparator);
                w.write(str);
            }
        } catch (IOException e) {
            throw new CensorException(e.getMessage(), inoutFileName);
        }
        File file = new File(inoutFileName);
        file.delete();
        File name = new File(tmpFileName);
        name.renameTo(file);

    }

    private static Word rafGetNextWord(RandomAccessFile raf, Word prevWord) throws IOException {
        long pos = prevWord.endPos + 1;
        raf.seek(pos);
        long len = raf.length();
        int c = 0;

        while (pos < len) {
            c = raf.read();
            if (Character.isLetter(c)) break;
            pos++;
        }
        if (pos == len) return null;
        Word result = new Word(pos);

        StringBuilder sb = new StringBuilder(16);
        sb.append((char) c);

        while (pos < len) {
            c = raf.read();
            if (!Character.isLetter(c)) break;
            sb.append((char) c);
            pos++;
        }
        result.endPos = pos;
        result.word = sb.toString();
        return result;
    }

    private static void rafEraseWord(RandomAccessFile raf, Word word, int charCode) throws IOException {
        long pos = word.startPos;
        raf.seek(pos);
        while (pos <= word.endPos) {
            raf.write(charCode);
            pos++;
        }
    }

    public static void censorFile2(String inoutFileName, String[] obscene) {
        Set<String> obs = new HashSet<String>(Arrays.asList(obscene));
        try {
            RandomAccessFile raf = new RandomAccessFile(inoutFileName, "rw");
            try {
                Word word = new Word(0, -1, "");
                while (word != null) {
                    word = rafGetNextWord(raf, word);
                    if (word != null) {
                        if (obs.contains(word.word)) {
                            rafEraseWord(raf, word, '*');
                        }
                    }
                }
            } catch (Exception e) {
                throw new CensorException(e.getMessage(), inoutFileName);
            }
            raf.close();
        } catch (Exception e) {
            throw new CensorException(e.getMessage(), inoutFileName);
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
}

class Word {

    long startPos;
    long endPos;
    String word;

    Word(long startPos) {
        this.startPos = startPos;
    }

    Word(long startPos, long endPos, String word) {
        this.startPos = startPos;
        this.endPos = endPos;
        this.word = word;
    }

    @Override
    public String toString() {
        return "Word{" +
                "startPos=" + startPos +
                ", endPos=" + endPos +
                ", word='" + word + '\'' +
                '}';
    }
}

