package ru.progwards.java1.lessons.bigints;

import java.math.BigInteger;
import java.util.Arrays;
/*
Реализовать класс ArrayInteger - целого числа произвольной длины на массиве byte[] digits;
Каждый элемент массива digits[i] может хранить только цифру, то есть число от 0 до 9.
Например, число 159 должно занять 3 ячейки массива digits[0] = 9; digits[1] = 5; digits[2] = 1;
Реализовать методы:
3.1 ArrayInteger(int n) - инициализирует класс, с максимальной точностью n цифр (размер массива)
3.2 void fromInt(BigDecimal value) - установить свое значение, взяв его из value
3.3 BigDecimal toInt() - привести свое значение к BigDecimal
3.4 boolean add(ArrayInteger num) - сложить 2 числа, не используя BigInteger, а  используя массив digits,
результат поместить в экземпляр ArrayInteger, у которого был вызван метод. При переполнении вернуть false,
при этом само число сбросить в 0
*/
public class ArrayInteger {
    byte[] digits; // массив цифр от 0 до 9
    int temp; // сколько цифр в даное время значимых

    ArrayInteger(int n) {
       // n=10;
        digits = new byte[n];

    }
    public ArrayInteger(String value) {
        this();
        fromString(value);
    }

    public ArrayInteger() {
        digits = new byte[10];
    }

    void fromString(String value) {
        char[] val = value.toCharArray();
        int len = val.length;
         //переведем массив к числовому
        for (int i = len - 1, j = 0; i >= 0; i--, j++) {
            digits[j] = (byte) (val[i] - '0');
        }
        // обнулим ранее использовавшиеся
        for (int i = len; i < temp; i++) {
            digits[i] = 0;
        }
        temp = len;
    }
        void fromInt(BigInteger value) {
            if (value.compareTo(BigInteger.TEN) == -1) {
                digits[0] = value.byteValue();
            }
            for (int i = 0; value.compareTo(new BigInteger("0")) != 0; i++) {
                digits[i] = value.mod(BigInteger.TEN).byteValue();
                value = value.divide(BigInteger.TEN);
            }
        }

    BigInteger toInt() {
        char[] charTemp = new char[temp];
        for (int i = temp - 1, j = 0; i >= 0; i--, j++) {
            charTemp[i] = (char) ((digits[j] + '0') & 0xFF);
        }
        return new BigInteger(String.valueOf(charTemp));
    }


    public boolean add(ArrayInteger num) {
        int sigMax = num.temp >= temp ? num.temp : temp; // max cущественный
        int len = digits.length;
        int leng = num.digits.length;
        int transfer = 0; // перенос
        int rez; // результат для цифр
        int sig = 0; // ИНДЕКС последнего значащего
        for (int i = 0; i <= sigMax; i++) {
            rez = transfer;
            if (i < len) rez += digits[i];
            if (i < leng) rez += num.digits[i];
            if (rez > 0) {
                sig = i;
                if (sig >= len) return false ;
                digits[sig] = (byte) (rez % 10);
            } else {
                if (i < len) digits[i] = 0;
            }
            transfer = rez / 10;
        }
        temp = sig + 1;
        return true;
    }
    @Override
    public String toString() {
        byte[] res = new byte[temp];
        for (int i = temp - 1, j = 0; i >= 0; i--, j++) {
            res[j] = (byte) (digits[i] + '0');
        }
        return new String(res);
    }
    public static void main(String[] args) {
        ArrayInteger a = new ArrayInteger("888");
        ArrayInteger b = new ArrayInteger("098");
        System.out.println(a + " + " + b + " = ");
        a.add(b);
        System.out.println(a);
    }
}