package Riba;

import java.io.*;
import java.util.Scanner;

public class Test35 {
    public static void main(String[] args) throws FileNotFoundException,IOException {

    }

    private static int lineCount(String[] filename) throws IOException {
        try {
            Scanner scanner = new Scanner(new File(String.valueOf(filename)));
            int tmp = 0;
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                tmp++;
            }
            return tmp;
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("файл не найден");
        }
    }
}