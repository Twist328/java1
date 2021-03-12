package ru.progwards.java1.lessons.collections;

import java.util.*;

public class TTTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Привет ");
        list.add("Обучающимся ");
        list.add("На ");
        list.add("Progwards !\n");


        Iterator iterator = list.iterator();//Теперь получим для него итератор и выведем в консоль все
                                            // содержащиеся строки:
        while (iterator.hasNext()) {
            System.out.print(iterator.next());

        }
        Map<String, Integer> map = new HashMap<>();//Для мар другая инициализация
        map.put("Анна",6);
        map.put("Евгения",1);
        map.put("Виктор",3);
        map.put("Прокопий",2);
                                                    // map.entrySet().iterator() чтобы реализовать пара-ключ-значение
        Iterator mapIterator = map.entrySet().iterator();
        System.out.println("/-------------------------------/");
        while (mapIterator.hasNext()) {
            Map.Entry<String, Integer> entry = (Map.Entry<String, Integer>) mapIterator.next();

            System.out.println("Key: " + entry.getKey());
            System.out.println("Value: " + entry.getValue());
        }
    }

}