package ru.progwards.java1.SeaBattle.tvist;

import ru.progwards.java1.SeaBattle.SeaBattle;
import ru.progwards.java1.SeaBattle.SeaBattle.FireResult;

import java.util.Arrays;

public class SeaBattleAlg {
    int direction;
    private static final int RITE = 0b01; //-
    private static final int LEFT = 0b10; //+
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
    char field[][];
    int hits;
    boolean doPrint = true;

    void init(SeaBattle seaBattle) {
        this.seaBattle = seaBattle;
        field = new char[seaBattle.getSizeY()][seaBattle.getSizeX()];
        hits = 0;
        for (int i = 0; i < seaBattle.getSizeY(); i++)
            Arrays.fill(field[i], ' ');
    }

    void print() {
        if (!doPrint)
            return;

        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            String str = "|";
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                str += field[y][x] + "|";
            }
            System.out.println(str);
        }
        System.out.println("-------------------");
    }

    void markKilled() {
        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                if (field[y][x] == 'X')
                    markHit(x, y);
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
        if (checkCoords(x, y) && field[y][x] == ' ')
            field[y][x] = '.';
    }

    // отметить наш выстрел
    void markFire(FireResult result, int x, int y) {
        if (result == FireResult.MISS)
            field[y][x] = '*';
        else
            field[y][x] = 'X';
    }

    boolean checkCoords(int x, int y) {
        if (x < 0 || x >= seaBattle.getSizeX() || y < 0 || y >= seaBattle.getSizeY())
            return false;
        return true;
    }

    SeaBattle.FireResult fire(int x, int y) {
        if (hits >= 20 || !checkCoords(x, y) || field[y][x] != ' ')
            return FireResult.MISS;
        SeaBattle.FireResult fireResult = seaBattle.fire(x, y);
        markFire(fireResult, x, y);
        if (fireResult != FireResult.MISS) {
            hits++;
            if (fireResult == FireResult.DESTROYED)
                markKilled();
            print();
        }
        return fireResult;
    }

    SeaBattle.FireResult fireAndKill(int x, int y) {
        SeaBattle.FireResult fireResult = fire(x, y);
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
        direction = RITE | LEFT;
        int i = 1;
        do {
            if ((direction & LEFT) != 0)
                destroyed = checkHit(fire(x + i, y), LEFT);
            if ((direction & RITE) != 0)
                destroyed = checkHit(fire(x - i, y), RITE);
            i++;
        } while (direction != 0 || destroyed);
        return destroyed;
    }

    private boolean killVertikal(int x, int y) {
        boolean destroyed = false;
        direction = RITE | LEFT;
        int i = 1;
        do {
            if ((direction & LEFT) != 0)
                destroyed = checkHit(fire(x, y + i), LEFT);
            if ((direction & RITE) != 0)
                destroyed = checkHit(fire(x, y - i), RITE);
            i++;
        } while (direction != 0 || destroyed);
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
                return true;
        }
        return false;
    }

    void deathСellx(int temp) {
        for (int x = 0; x < seaBattle.getSizeX(); x++) {
            for (int y = x + temp; y < seaBattle.getSizeY(); y += 3)
                fireAndKill(x, y);

            for (int y = x - temp; y >= 0; y -= 3)
                fireAndKill(x, y);
        }
    }

    void deathСelly(int temp) {
        for (int y = 0; y < seaBattle.getSizeY(); y++) {
            for (int x = y + temp; x < seaBattle.getSizeX(); x += 3)
                fireAndKill(x, y);

            for (int x = y - temp; x >= 0; x -= 3)
                fireAndKill(x, y);
        }
    }

    void variant3() {
        deathСelly(0);
        deathСelly(2);
        deathСelly(1);
    }

    void variant2() {
        deathСellx(1);
        deathСelly(2);
        deathСellx(0);
        deathСelly(1);
        deathСellx(0);
        deathСelly(0);

    }

    void variant1() {
        // пример алгоритма:
        // стрельба по всем квадратам поля полным перебором
        for (int y = 0; y < seaBattle.getSizeX(); y++) {
            for (int x = 0; x < seaBattle.getSizeY(); x++) {
                SeaBattle.FireResult fireResult = fireAndKill(x, y);
            }
        }
    }

    public void battleAlgorithm(SeaBattle seaBattle) {
        init(seaBattle);
        doPrint = false;
        //variant1();
        //variant2();
        variant3();

    }

    // функция для отладки
    public static void main(String[] args) {
        System.out.println("Sea battle");
        //SeaBattle seaBattle = new SeaBattle(true);
        //new SeaBattleAlg().battleAlgorithm(seaBattle);
        // System.out.println(seaBattle.getResult());
        test();
    }

    static void test() {
        SeaBattleAlg alg = new SeaBattleAlg();
        int result = 0;
        for (int i = 0; i < 1000; i++) {
            SeaBattle seaBattle = new SeaBattle();
            alg.battleAlgorithm(seaBattle);
            result += seaBattle.getResult();
        }
        System.out.println(result / 1000);

    }
}