package Goon;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LettersInFile {
    public static String process(String fileName) throws IOException {

        Set<Character>charSet=new HashSet<Character>();
        FileReader reader=new FileReader(fileName);
        Scanner scan = new Scanner(reader);
        while (scan.hasNextLine());
            String str = scan.nextLine();

        return fileName;
    }
}