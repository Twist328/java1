package Goon;

import java.util.*;

public class Test43 {
    public static void iSetTest() {
    }

    public static void wSetTest() {
    }

    public static void cset() {

    }

    public static void main(String[] args) {

        Set<Integer> iSet = new HashSet<>();
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                iSet.add(i + j);
            }
        System.out.println(iSet.size());
//__________________________________________________________________________________________//
        String TEXT = "на дворе трава на траве дрова не руби дрова на траве двора";
        Set<String> wordSet = new HashSet<>(Arrays.asList(TEXT.split(" ")));
        Iterator<String> iter = wordSet.iterator();
        while (iter.hasNext())
            if (iter.next().contains("ра"))
                iter.remove();
        System.out.println(TEXT);
        System.out.println(wordSet);
        System.out.println(wordSet.size());
        //__________________________________________________________________________________________//
        Set<Integer> fiboTreeSet1000 = Set.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 55);

        for (int num : fiboTreeSet1000)

            System.out.println(num + " " + (fiboTreeSet1000.contains(num) ? "Фибо" : ""));
//__________________________________________________________________________________________//
        Set<Integer> fiboSet1000a = Set.of(0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987);
        System.out.println(fiboSet1000a);
        for (int i = 0; i < 1; i++) {
            System.out.print(i + " " + (fiboSet1000a.contains(i) ? "ДА!!!!" : ""));


            Map<String, String> books = new HashMap<>();
            books.put("Война и мир", "Лев Толстой");
            books.put("Преступление и наказание", "Федор Достоевский");
            books.put("Философия Java", "Брюс Эккель");
            books.put("Братья Карамазовы", "Федор Достоевский");
            books.put("Властелин Колец", "Джон Толкин");

            books.computeIfPresent("Евгений Онегин", (a, b) -> b = "Александр Пушкин");
            System.out.println("_________________");
            books.forEach((a, b) -> System.out.println("Название книги: " + a + ". Автор: " + b));
            books.computeIfPresent("Братья Карамазовы", (a, b) -> b = "Александр Пушкин");
            System.out.println("_________________");
            books.forEach((a, b) -> System.out.println("Название книги: " + a + ". Автор: " + b));


        }
    }
}
