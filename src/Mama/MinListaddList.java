package Mama;

import ru.progwards.java1.lessons.bigints.ArrayInteger;

import java.util.*;

public class MinListaddList {

    private static Object List;

    public MinListaddList(List<Integer> listAction) {
    }
    public MinListaddList() {
    }
    public static List<Integer> listAction(List<Integer> list) {

        if (list == null) return null;

        if (list.size() == 0) return new ArrayList<>();

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 7; i++)

            res.add(i);
        System.out.println("res=" + res);

        res.addAll(list);
        System.out.println("res=" + res);

        res.remove(Collections.min(res));
        System.out.println("res=" + res);

        res.add(0, res.size());
        System.out.println("res=" + res);

        res.add(1, Collections.max(res));
        System.out.println("res=" + res);

        return res;
    }
    public static void main(String[] args) {

        Collection<Integer> res4 = new ArrayList();
        for (int i = 0; i < 5; i++)
            res4.add(i);
        res4.remove(3);
        System.out.println(res4);

        Collection<Integer> res1 = new ArrayList();
        for (int i = 0; i < 5; i++)
            res1.add(i);
        res1.add(Collections.min(res1));
        System.out.println(res1);

        Collection<Integer> res2 = new ArrayList();
        for (int i = 0; i < 5; i++)
            res2.add(i);
        ((ArrayList) res2).add(3, res2.size());
        System.out.println(res2);

        Collection<Integer> res3 = new ArrayList();
        for (int i = 0; i < 5; i++)
            res3.add(i);
        res3.add(Collections.max(res3));
        System.out.println(res3);

        MinListaddList listAction = new MinListaddList(listAction(Collections.singletonList(0)));
    }
    private static Object listAction() {
        return 0;
    }
}
    /*Напишите метод с сигнатурой public List<Integer> listAction(List<Integer> list), который выполняет следующие действия:

        удаляет минимальный элемент коллекции
        по индексу 0 добавляет число равное количеству элементов
        по индексу 2 добавляет максимальный элемент из list
        возвращает list как результат метода*/