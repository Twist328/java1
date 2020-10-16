package Tvist328;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class ZapisVFiles {
    private static int lineCount(String filename) throws IOException {
        LineNumberReader reader  = new LineNumberReader(new FileReader(filename));
        while (reader.readLine() != null) {}
        reader.close();
        return reader.getLineNumber();
    }}
   /*/ public static void main(String[] args) throws IOException {
        ZapisVFiles filename =new ZapisVFiles();

        System.out.println(lineCount(String.valueOf(1)));
    }
}/*/