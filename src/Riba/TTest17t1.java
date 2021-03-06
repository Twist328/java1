package Riba;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TTest17t1 {
    String createFolder(String name) {
        File file = new File(name);
        file.mkdir();
        Path path = Paths.get("..");
        return String.valueOf(path.toAbsolutePath().normalize());
    }

    static boolean replaceF(String name) {//Заменить в файле F на f используя методы только из java.nio.file.Files.
        String word, newWords;
        try {
            Path path = Paths.get(name);
            word = Files.readString(path);
            newWords = word.replaceAll("F", "f");
            Files.writeString(path, newWords);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new TTest17t1().createFolder("..java1/src/Riba/replaceA.txt"));
        new TTest17t1();
        System.out.println(replaceF("C:/java1/src/Riba/replaceA"));
        boolean res = replaceF("C:/java1/src/Riba/replaceA.txt");
        System.out.println(res);
    }
}

