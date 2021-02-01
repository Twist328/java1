package ru.progwards.java1.lessons.egts;

public class EgtsDirectionAndSpeed {


    public static int getSpeed(short speedAndDir) {

        return speedAndDir & 0b0111_1111_1111_1111;

    }


    public static int getDirection(byte dirLow, short speedAndDir) {

        return (dirLow & 0b1111_1111) + (speedAndDir >>> 7 & 0b1_0000_0000);

    }

    public static void main(String[] args) {
        System.out.println("2=" + getSpeed((short)0b1000_0000_0000_0010));
        System.out.println("2=" + getDirection((byte)0b0000_0010, (short)0b0000_0000_0000_0000));
        System.out.println("258=" + getDirection((byte)0b0000_0010, (short)0b1000_0000_0000_0000));
        System.out.println("255=" + getDirection((byte)0b1111_1111, (short)0b0000_0000_0000_0000));
        System.out.println("511=" + getDirection((byte)0b1111_1111, (short)0b1000_0000_0000_0000));
        System.out.println("144=" + getDirection((byte)0b1001_0000, (short)0b0000_0000_0000_0000));
        System.out.println("456=" + getDirection((byte)0b1111_1111, (short)0b0000_0000_0000_0000));//11001001

    }

    @Override
    public String toString() {
        return super.toString();
    }
}
//Эта задача основана на реальной практике (с минимальным упрощением)
// и связана с обработкой протокола EGTS для отслеживания движения и состояния транспортных средств (далее ТС).
//Исходные данные: два целых беззнаковых числа (например, беззнаковое число хранящееся в байте принимает значения
// от 0 до 255, поскольку старший бит используется не для знака, а для самого числа), одно (dirLow) хранится в byte,
// второе (speedAndDir) в short. В байте dirLow хранятся младшие 8 бит направления движения ТС в градусах.
// А в 15 младших битах speedAndDir (short) хранится скорость в км/час.
// В старшем бите speedAndDir хранится старший бит направления движения ТС.
//Таким образом получается, что для хранения направления движения ТС используется 9 бит, а для хранения скорости - 15 бит.
//При решении задачи необходимо помнить, что в Java byte и short являются знаковыми типами, но данные из протокола EGTS, положенные в byte и short, являются беззнаковыми.
//Для решения задачи следует.
//3.1 Реализовать функцию public static int getSpeed(short speedAndDir), которая будет возвращать скорость движения ТС в км/час.
//3.2 Реализовать функцию public static int getDirection(byte dirLow, short speedAndDir), которая будет возвращать направление движения ТС в градусах.
//
//Подсказки:
//полезно вспомнить как приводить знаковые типы byte и short к беззнаковому значению в int (в конце лекции Битовые операции);
//при решении задачи удобно использовать битовые операции &, >>;
//при работе с константами представленными в двоичном виде удобно разделять каждые 8 бит (один байт) подчёркиванием (например int y = 0b10011101_00010011).