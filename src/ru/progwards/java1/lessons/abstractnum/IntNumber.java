package ru.progwards.java1.lessons.abstractnum;

/*
Реализовать класс IntNumber, который содержит
3.8 конструктор
public IntNumber(int number), который будет сохранять в классе значение целого числа.
3.9 переопределение метода
public Number mul(Number n1, Number n1), который будет вычислять произведение n1 на n2 в целых числах.
3.10 переопределение метода
public Number div(Number n1, Number n1), который будет вычислять частное от деления n1 на n2 в целых числах.
3.11 переопределение метода
public Number newNumber(String strNum), который будет возвращать новый экземпляр класса IntNumber
со значением параметра strNum, приведенного к типу int.
Внимание! Реально будет передаваться строковое значение в виде и double и int, например 3.14.... или 4, 3.
Надо будет правильно распарсить строку и привести значение к нужному типу.
*/
public class IntNumber extends Number {
    public int num;

    public IntNumber(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public Number mul(Number num) {
        int num2 = ((IntNumber)num).num;
        return new IntNumber(this.num*num2);
    }

    @Override
    public Number div(Number num) {
        int num2 = ((IntNumber)num).num;
        return new IntNumber(this.num/num2);
    }

    public Number newNumber(String strNum){
        return new IntNumber(Integer.parseInt(strNum));
    }
}

