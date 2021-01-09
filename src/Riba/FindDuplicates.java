package Riba;



import java.io.IOException;
import java.nio.file.*;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

import javax.sound.midi.Patch;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.stream.Collectors;


public class FindDuplicates implements NeedPathValue {


    //private static boolean dir;
// В заданном каталоге и его подкаталогах найти файлы, точно совпадающие
    public static List<List<String>> findDuplicates(String startPath) throws IOException {
        System.out.println("В указанном каталоге:");
        List<Path> path = readAllPathsNio(startPath);
        if (path == null) return null;
        List<List<Path>> content = new ArrayList<List<Path>>();
        content.add(path);
        System.out.println("Найдены: " + countAll((Collection) content) + "\n");

        // по имени файлов
       /**/ System.out.println("Поиск файлов с одинаковыми именами:");
        content = getEquals(content, p -> p.getFileName().toString());
        System.out.println("Найдено: " + countAll((Collection) content) + "\n");

        // с одинаковой датой-временем последнего изменения
        System.out.println("С одинаковым временем последних изменений:");
        content = getEquals(content, p -> {
            try {
                return Files.getLastModifiedTime(p);
                // return Files.getAttribute(p, "basic:lastModifiedTime");
            } catch (IOException e) {
                return null;
            }
        });
        System.out.println("Найдено: " + countAll((Collection) content) + "\n");

        // с одинаковым размером
        System.out.println("Такого-же размера:");
        content = getEquals(content, p -> {
            try {
                return Files.size(p);
            } catch (IOException e) {
                return null;
            }
        });
        System.out.println("Найдено: " + countAll((Collection) content) + "\n");

        // с одинаковым содержимым
        System.out.println("По одинаковому контенту:");
        content = getEquals(content, (o1, o2) -> isEqualPaths(o1, o2) ? 0 : 1);
        System.out.println("Найдено: " + countAll((Collection) content) + "\n");

        // преобразуем к List<List<String>>
        List<List<String>> res = new ArrayList<List<String>>(content.size());
        for (List<Path> listP : content) {
            List<String> list = new ArrayList<String>(listP.size());
            for (Path path1 : listP) list.add(path1.toString());
            res.add(list);
        }
        return res;
    }

    // посчитать общее количество элементов вместе со всеми подколлекциями
    public static int countAll(Collection<Object> manyCollection) {

        int result = manyCollection.size();
        if (result > 0) {
            Iterator iter = manyCollection.iterator();
            Object obj = iter.next();
            if (obj instanceof Collection) {
                result += countAll((Collection) obj);
                while (iter.hasNext()) {
                    result += countAll((Collection) iter.next());
                }
            }
        }
        //System.out.println(result+countAll((Collection)content);
        return result;
    }

    // сравнить содержимое двух файлов
    public static boolean isEqualPaths(Path path1, Object path2) {
        try (
                InputStream files1 = Files.newInputStream(path1);
                InputStream files2 = Files.newInputStream((Path) path2);
        ) {
            long fileSize = Files.size(path1);
            int lenSize = (int) (fileSize / 16);
            final int minSize = 128 * 1024;
            final int maxSize = 1 * 1024 * 1024;
            if (lenSize > maxSize || fileSize > Integer.MAX_VALUE) lenSize = maxSize;
            else if (lenSize < minSize)
                if (fileSize < minSize) lenSize = (int) fileSize;
                else lenSize = (int) fileSize / 4;
            try (
                    BufferedInputStream str1 = new BufferedInputStream(files1, lenSize);
                    BufferedInputStream str2 = new BufferedInputStream(files2, lenSize);
            ) {
                int tmp = 0;
                while ((tmp = str1.read()) != -1) {
                    if (tmp != str2.read()) return false;
                }

                return str2.read() == -1;
                //return false;
            }
        } catch (Throwable e) {
            return false;
        }
    }

    // в заданных списках оставить только с одинаковым результатом comp
    public static <T> List<List<T>> getEquals(List<List<T>> paths, Comparator<T> comp) {
        List<List<T>> res = new ArrayList<List<T>>();
        for (List<T> doList : paths) {
            int[] foundIndx = new int[doList.size()]; // массив найденных, храним индекс в массиве результатов
            boolean[] found = new boolean[doList.size()]; // массив найденных, храним индекс в массиве результатов
            int i = -1;
            for (T p1 : doList) {
                i++;
                if (!found[i]) {
                    found[i] = true;
                    int j = -1;
                    for (T p2 : doList) {
                        j++;
                        if (!found[j]) {
                            int cmp = comp.compare(p1, p2);
                            if (cmp == 0) {
                                int indx = foundIndx[i];
                                if (indx > 0) {
                                    res.get(indx).add(p2);
                                } else {
                                    foundIndx[i] = res.size();
                                    ArrayList<T> list = new ArrayList<T>();
                                    list.add(p1);
                                    list.add(p2);
                                    res.add(list);
                                }
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    // в заданных списках <T> obj оставит только с одинаковым значением comp
    public static <CompareObj, ListObj> List<List<ListObj>> getEquals(List<List<ListObj>> paths, ru.progwards.java1.lessons.files.NeedPathValue<CompareObj, ListObj> comp) {
        ListIterator<List<ListObj>> pIter = paths.listIterator();
        List<List<ListObj>> res = new ArrayList<List<ListObj>>();
        while (pIter.hasNext()) {
            List<ListObj> p1 = pIter.next();
            Hashtable<CompareObj, List<ListObj>> hTable = new Hashtable<CompareObj, List<ListObj>>();
            for (ListObj p : p1) {
                CompareObj cmpO = comp.get(p);
                if (cmpO != null) {
                    List<ListObj> detected = hTable.get(cmpO);
                    if (detected == null) {
                        detected = new ArrayList<ListObj>();
                        detected.add(p);
                        hTable.put(cmpO, detected);
                    } else {
                        detected.add(p);
                    }
                }
            }
            hTable.forEach((k, v) -> {
                if (v.size() > 1) res.add(v);
            });
        }
        return res;
    }

    // Считываем все файлы в данном каталоге в поток
    public static List<Path> readAllPathsLambda(String startPath) throws IOException {
        return Files.walk(Paths.get(startPath))
                .filter(Files::isRegularFile) //.map(Path::toString)
                .collect(Collectors.toList());
    }

    // Считываем все файлы в данном каталоге в массив
    public static List<Path> readAllPathsNio(String startPath) {
        List<Path> res = new ArrayList<Path>();
        Path path = Paths.get(startPath);
        SimpleFileVisitor sfv = new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException {
                res.add(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException e)
                    throws IOException {
                return FileVisitResult.SKIP_SUBTREE;
            }
        };
        try {
            Files.walkFileTree(path, sfv);
            return res;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public Object get(Object p) {
        return null;
    }
}