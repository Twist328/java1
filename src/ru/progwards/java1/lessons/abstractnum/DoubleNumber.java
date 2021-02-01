package ru.progwards.java1.lessons.abstractnum;
/*
Реализовать класс DoubleNumber, который содержит
3.12 конструктор
public DoubleNumber(double number), который будет сохранять в классе значение числа double.
3.13 переопределение метода
public Number mul(Number n1, Number n1), который будет вычислять произведение n1 на n2 в числах double.
3.14 переопределение метода
public Number div(Number n1, Number n1), который будет вычислять частное от деления n1 на n2 в числах double.
3.15 переопределение метода
public Number newNumber(String strNum), который будет возвращать новый экземпляр класса DoubleNumber
со значением параметра strNum, приведенного к типу double.
Внимание! Реально будет передаваться строковое значение в виде и double и int, например 3.14.... или 4, 3.
Надо будет правильно распарсить строку и привести значение к нужному типу.
*/
public class DoubleNumber extends Number {
    public DoubleNumber() {}
    public DoubleNumber(double number) {
        super("" + number, NumType.DOUBLE);
    }
    public static Number mul(Number n1, Number n2) {
        return new DoubleNumber(Double.parseDouble(n1.toString()) * Double.parseDouble(n2.toString()));
    }
    public static Number div(Number n1, Number n2) {
        return new DoubleNumber(Double.parseDouble(n1.toString()) / Double.parseDouble(n2.toString()));
    }

    DoubleNumber(String strNum) {
        super(strNum);
    }

    public static DoubleNumber newNumber(String strNum) {
        DoubleNumber d = new DoubleNumber();
        d.strNum = strNum;
        d.numType = getNumType(strNum);
        return d;
    }
}