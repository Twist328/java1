package Mama;

import java.util.*;

public class FilterList {
    public static List<Integer> filter(List<Integer> list) {
        int sum = 0;
        for (int e : list) sum = sum + e;
        List<Integer> res;
        if (list instanceof ArrayList) res = new ArrayList<>();
        else if (list instanceof LinkedList) res = new LinkedList<>();//это бонус
        else if (list instanceof Vector) res = new Vector<>();       //тоже
        else if (list instanceof Stack) res = new Stack<>();         //тоже
        else if (list instanceof List) res = new ArrayList<>();      //дублирование 10 строки
        else throw new RuntimeException("Неизвестный тип'list'!");
        int fraction = sum / 100;
        for (Integer e : list) if (e < fraction) res.add(e);
        return res;
    }
      /*Напишите метод, с сигнатурой public List<Integer> filter(List<Integer> list) который работает
       по следующему алгоритму:
       суммирует значения всех элементов списка
       удаляет из списка элементы, значение которых меньше суммы, деленной на 100 (целочисленное деление)
       возвращает результирующий список */

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (Integer e : new Integer[]{555, 800, -100, 253, -50, 1, 888}) list.add(e);
        System.out.println(filter(list));

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (Integer e : new Integer[]{2800, 400, -100, 253, -50, 1, 888}) linkedList.add(e);
        System.out.println(filter(linkedList));

        Vector<Integer> vector = new Vector<>();
        for (Integer e : new Integer[]{2400, -200, -100, 253, -50, 1, 8}) vector.add(e);
        System.out.println(filter(vector));

        Stack<Integer> stack = new Stack<>();
        for (Integer e : new Integer[]{2, -200, -100, 253, -50, 1, 8}) stack.add(e);
        System.out.println(filter(stack));

    }
}
