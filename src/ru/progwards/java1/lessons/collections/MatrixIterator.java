package ru.progwards.java1.lessons.collections;


import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIterator<T> implements Iterator<T> {
    private int skolkoel;          //всего элементов в матрице
    private int position = 0;  //номер текущего элемента для "выдачи"
    private int stroka = 0;       //строка текущего элемента
    private int colonka = 0;       //столбец текущего элемента
    private T[][] matrix;

    public MatrixIterator(T[][] matrix) {
        this.matrix = matrix;
        this.skolkoel = countElements(matrix);
    }

    private int countElements(T[][] matrix) {  //считаем количество элементов в матрице
        int count = 0;
        for (T[] stroka : matrix) {
            count += stroka.length;
        }
        return count;
    }

    @Override
    public boolean hasNext() {
        return position < skolkoel;
    }

    @Override
    public T next() {
        if (position >= skolkoel) { //если перебрали все элементы, то бросить исключение
            throw new NoSuchElementException();
        }
        T element = matrix[stroka][colonka];  //запоминаем текущий элемент
        //переходим к следующему элементу
        position++;
        colonka++;
        while (stroka < matrix.length && colonka >= matrix[stroka].length) { //для того, чтоб пропустить возможные "пустые" строки
            colonka = 0;
            stroka++;
        }
        return element;
    }

    public static void main(String[] args) {
        Integer[][] matrix = {{1, 2, 3}, {}, {4, 5}, {6}};
        Iterator<Integer> iterator = new MatrixIterator<>(matrix);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}

