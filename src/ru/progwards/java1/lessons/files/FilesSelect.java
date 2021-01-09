package ru.progwards.java1.lessons.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilesSelect {
    /*
    Реализовать метод с сигнатурой public void selectFiles(String inFolder, String outFolder, List<String> keys),
    который сортирует файлы по их содержимому. Нужно просмотреть содержимое всех файлов, с расширением txt,
    содержащихся в каталоге inFolder с подкаталогами, и если файл содержит ключевое слово из коллекции keys,
    то скопировать его в подпапку с соответствующим именем, этого элемента keys,
    все подпапки должны находиться в outFolder.
    Например, вызвана функция с параметрами (“aaa”, “bbb”, {“check”, “files”} )
    нужно проверить каталог aaa с подкаталогами, найти там все файлы txt, и если файл содержит “check”,
    скопировать его в папку bbb/check, если файл содержит “files”, скопировать его в папку bbb/files.
    Важно! Если, например, слово “files” ни разу не встретилось, пустую папку создавать не нужно
    */
    public static void main(String[] args) {

        new FilesSelect().selectFiles("\\java1\\", "out", Arrays.asList("java1"));
        new FilesSelect().selectFiles(".", "\\C\\", Arrays.asList("C"));
    }


    // поиск ключевиков во всех файлах каталога, копирование в папки с названиями ключевиков
    public static void selectFiles(String inFolder, String outFolder, List<String> keys) {
        List<Path> paths = null;
        try {
            paths = Files.walk(Paths.get(inFolder))
                    .filter(str -> str.toString().endsWith(".txt"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(paths);
        if (paths != null)
            for (Path path : paths) {
                String tmp = findKey(path, keys);
                if (tmp != null) copyFile(path, outFolder, tmp);
            }
    }

    // найти ключевую последовательность символов в файле
    private static String findKey(Path path, List<String> keys) {
        Charset set = Charset.forName("UTF-8");
        try (BufferedReader reader = Files.newBufferedReader(path, set)) {
            String str;
            while ((str = reader.readLine()) != null) {
                for (String key : keys) {
                    if (str.indexOf(key) >= 0) return key;
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return null;
    }

    // скопировать файл в подкаталог
    private static void copyFile(Path path, String outFolder, String subFolder) {
        Path nextPath = Paths.get(outFolder + "/" + subFolder);
        Path  next = Paths.get(outFolder + "/" + subFolder + "/" + path.getFileName());
        System.out.println("copy " + path + " -> " + next);
        try {
            if (Files.notExists(nextPath)) Files.createDirectories(nextPath);
            Files.copy(path, next, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}