package ru.progwards.java1.SeaBattle.tvist;

import ru.progwards.java1.SeaBattle.SeaBattle;
import ru.progwards.java1.SeaBattle.SeaBattle.FireResult;

import java.util.Arrays;

public class SeaBattleAlg {


    // Тестовое поле создаётся конструктором
    //     SeaBattle seaBattle = new SeaBattle(true);
    //
    // Обычное поле создаётся конструктором по умолчанию:
    //     SeaBattle seaBattle = new SeaBattle();
    //     SeaBattle seaBattle = new SeaBattle(false);
    //
    // Посомтреть результаты стрельбы можно в любой момент,
    // выведя объект класса SeaBattle на консоль. Например так:
    //     System.out.println(seaBattle);
    //
    //
    // Вид тестового поля:
    //
    //           0 1 2 3 4 5 6 7 8 9    координата x
    //         0|.|.|.|.|.|.|.|X|.|.|
    //         1|.|.|.|.|.|X|.|.|.|.|
    //         2|X|X|.|.|.|.|.|.|.|.|
    //         3|.|.|.|.|.|.|.|X|X|X|
    //         4|.|.|.|.|X|.|.|.|.|.|
    //         5|.|.|.|.|X|.|.|Х|.|.|
    //         6|.|.|.|.|.|.|.|Х|.|X|
    //         7|X|.|X|.|.|.|.|Х|.|X|
    //         8|X|.|.|.|.|.|.|X|.|.|
    //         9|X|.|.|.|X|.|.|.|.|.|
    SeaBattle seaBattle;
    private static final int MINUS = 0b01;
    private static final int PLUS = 0b10;
    int hits;
    char field[][];
    int direction;

    void init(SeaBattle seaBattle) {
        this.seaBattle = seaBattle;
        hits = 0;
        field = new char[seaBattle.getSizeY()][seaBattle.getSizeX()];
        for (int i = 0; i < seaBattle.getSizeX(); i++)
            Arrays.fill(field[i], ' ');

    }

    void print() {
        for (int y = 0; y < seaBattle.getSizeY(); y++) {
            String str = "|";
            for (int x = 0; x < seaBattle.getSizeX(); x++) {
                str += field[y][x] + "|";
            }
            System.out.println(str);
        }
        System.out.println("---------------------");
    }

    void markKilled() {
        for (int y = 0; y < seaBattle.getSizeY(); y++) {
            for (int x = 0; x < seaBattle.getSizeX(); x++) {
                if (field[y][x] == 'X')
                    markHit(x,y);
            }
        }
    }

    private void markHit(int x, int y) {
        markDot(x - 1, y - 1);
        markDot(x - 1, y);
        markDot(x - 1, y + 1);
        markDot(x + 1, y - 1);
        markDot(x + 1, y);
        markDot(x + 1, y + 1);
        markDot(x, y - 1);
        markDot(x, y + 1);
    }

    private void markDot(int x, int y) {
        if (checkCords(x, y) && field[y][x] == ' ')
            field[y][x] = '.';
    }

    void markFire(FireResult result, int x, int y) { // обозначить  * - выстрел
        if (result == FireResult.MISS)
            field[y][x] = '*';
        else
            field[y][x] = 'X';
    }

    boolean checkCords(int x, int y) {
        if (x < 0 || x >= seaBattle.getSizeX() || y < 0 || y >= seaBattle.getSizeY())
            return false;
        return true;
    }

    SeaBattle.FireResult fire(int x, int y) {
        if (hits >= 20 || !checkCords(x, y) || field[y][x] != ' ')
            return FireResult.MISS;
        SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
        markFire(fireResult, x, y);
        if (fireResult != SeaBattle.FireResult.MISS)
            hits++;
        if (fireResult != FireResult.DESTROYED)
            markKilled();
        return fireResult;
    }

    SeaBattle.FireResult fireAndKill(int x, int y) {
        SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
        if (fireResult == FireResult.HIT)
            killShip(x, y);
        return fireResult;
    }

    private void killShip(int x, int y) {
        if (!killkHorizontal(x, y))
            killVertikal(x, y);
    }

    private boolean killkHorizontal(int x, int y) {
        boolean destroyed = false;
        direction = PLUS | MINUS;
        int i = 1;
        do {
            if ((direction&PLUS) != 0)
                destroyed = checkHit(fire(x + i, y), PLUS);
            if ((direction&MINUS) != 0)
                destroyed = checkHit(fire(x - i, y), MINUS);
            i++;
        } while (direction != 0);
        return destroyed;

    }

    private boolean killVertikal(int x, int y) {
        boolean destroyed = false;
        direction = PLUS | MINUS;
        int i = 1;
        do {
            if ((direction&PLUS) != 0)
                destroyed = checkHit(fire(x,y+i), PLUS);
            if ((direction&MINUS) != 0)
                destroyed = checkHit(fire(x,y-i), MINUS);
            i++;
        } while (direction != 0);
        return destroyed;

    }

    private boolean checkHit(FireResult result, int fireDirection) {
        switch (result) {
            case MISS:
                direction &= ~fireDirection;
                return false;
            case HIT:
                return false;
            case DESTROYED:
                direction = 0;
                return true;
        }
        return false;
    }

    public void battleAlgorithm(SeaBattle seaBattle) {
        init(seaBattle);

        // пример алгоритма:
        // стрельба по всем квадратам поля полным перебором

        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                SeaBattle.FireResult fireResult = fireAndKill(x,y);
                print();
            }
        }
    }

    static void test() {
        System.out.println("Sea battle");
        SeaBattle seaBattle = new SeaBattle(true);
        new SeaBattleAlg().battleAlgorithm(seaBattle);
        System.out.println(seaBattle.getResult());
    }

    static void comp() {
        SeaBattleAlg alg = new SeaBattleAlg();
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            SeaBattle seaBattle = new SeaBattle();
            alg.battleAlgorithm(seaBattle);
            result += seaBattle.getResult();
        }
        System.out.println(result / 1000);
    }

    // функция для отладки
    public static void main(String[] args) {
        test();
        comp();
    }
}



