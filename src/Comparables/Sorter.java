package Comparables;

import java.util.*;

public class Sorter {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int number = 2; // сколько цифр будет в массиве
        int count = 0; // Вот эту переменную можно и не создавать
        int id = 1;

        int[] arrName = new int[number];

        TreeSet<Integer> treeSet = new TreeSet<>();

        for (int i = 0; i < number; i++) { // цикл будет идти пока пользователь не заполнит все числа в массиве
            System.out.printf("Введите число %d:\n", id++);

            arrName[count] = scanner.nextInt(); // А здесь вместо 'arrName[count]' просто указать 0 именно вместо count

            System.out.println();

            treeSet.add(arrName[count]); // И тут 0
        }

        List<Integer> list = new ArrayList<>(treeSet);

        Collections.reverse(list); // Если хотите чтоб наибольшее число было внизу, а наименьшее было сверху то удалите эту строку и все

        for (Integer integer : list) {
            System.out.println(integer);
        }

        int[] arr = {-10, -10, -9, 99, 0, 89, 11, 0, 1, 2, 3, 4, 5, 6, 7, -100, 8, 0, 1, 1, 1, 0, 1, 1, 1, -3, -2, -10};
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j > 0 && arr[i] < arr[--j]) {
                if (j == 0 || arr[i] >= arr[j - 1]) {
                    int x = arr[i];
                    for (int k = i; k > j; k--)
                        arr[k] = arr[k - 1];
                    arr[j] = x;
                }
            }
        }

        for (int x : arr)
            System.out.print(x + " ");
    }
}