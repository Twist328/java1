package ru.progwards.java1.lessons.arrays;
/*
Эратосфе́н Кире́нский (др.-греч. Ἐρατοσθένης ὁ Κυρηναῖος; 276 год до н. э.—194 год до н. э.) — греческий математик,
астроном, географ, филолог и поэт.
Решето́ Эратосфе́на — алгоритм нахождения всех простых чисел до заданного целого числа N. Согласно легенде, Эратосфен
писал числа на дощечке, покрытой воском, и прокалывал дырочки в тех местах, где были написаны составные числа. Поэтому
дощечка являлась неким подобием решета, через которое «просеивались» все составные числа, а оставались только числа
простые.
Алгоритм:
Для нахождения всех простых чисел не больше заданного числа N, следуя методу Эратосфена, нужно выполнить следующие шаги:
1) Выписать подряд все целые числа от двух до n (2, 3, 4, …, N).
2) Пусть переменная p изначально равна двум — первому простому числу.
3) Зачеркнуть в списке числа от 2p до N считая шагами по p (это будут числа кратные p: 2p, 3p, 4p, …).
4) Найти первое незачёркнутое число в списке, большее чем p, и присвоить значению переменной p это число.
5) Повторять шаги 3 и 4, пока возможно.
Теперь все незачёркнутые числа в списке — это все простые числа от 2 до n.
Говоря простым языком, надо вначале вычеркнуть все числа, которые делятся на 2, кроме самой двойки, т.е. каждое второе
число, потом, которые делятся на 3, т.е. каждое 3-е число, кроме самой 3-ки, и т.д. в цикле
1.1 Реализовать класс Eratosthenes, содержащий:
массив чисел, собственно, "решето"
private boolean[] sieve, для того, чтобы узнать, я является ли число n простым, нужно взять значение по индексу в
массиве. sieve[n]. Значение true, означает простое число, false - составное.
1.2 Реализовать конструктор
public Eratosthenes(int N), который должен разместить массив sieve с размером в N и заполнить его значениями true,
после чего вызвать метод sift()
1.3 Реализовать метод
private void sift(), который, собственно и реализует алгоритм Эратосфена, просеивая составные числа.
Подсказка - нужно реализовать 2 вложенных цикла, внешний, например по i от 2 до N-1, и внутренний, например по j который
будет просеивать числа, кратные переменной внешнего цикла i*j.
1.4 Реализовать метод
public boolean isSimple(int n), который возвращает sieve[n], что бы можно было узнать, простое число n или составное
*/
import java.util.Arrays;

public class Eratosthenes {

    private boolean[] sieve; //решето: значение true, означает простое число, false - составное

    public Eratosthenes(int N) {
        sieve = new boolean[N + 1];
        if(N > 1) {
            Arrays.fill(sieve, true);
            sieve[0] = false;
            sieve[1] = false;
            sift();
        } else {
            Arrays.fill(sieve, false);
        }
    }
    private void sift() {
        int len = sieve.length;
        int n;
        for (int i = 2; i < len; i++) if (sieve[i]) {
            n = i * 2;
            while (n < len) {
                sieve[n] = false;
                n += i;
            }
        }
    }
    public boolean isSimple(int n) {
        return sieve[n];
    }
    public static void main(String[] args) {
        Eratosthenes e1 = new Eratosthenes(100);
        System.out.println(Arrays.toString(e1.sieve));
        System.out.println(e1.isSimple(73));
    }
}




