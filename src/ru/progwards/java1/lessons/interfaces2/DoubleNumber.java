package ru.progwards.java1.lessons.interfaces2;

public class DoubleNumber extends Number {
    Double num;

    public DoubleNumber(double num) {
        this.num = num;
    }

    @Override
    public Number div(Number num) {
        double num2 = Double.valueOf(num.toString());
        return new DoubleNumber(this.num / num2);
    }

    @Override
    public Number mul(Number num) {
        double num2 = Double.valueOf(num.toString());
        return new DoubleNumber(this.num * num2);
    }

    public Number newNumber(String strNum) {
        return new DoubleNumber(Double.parseDouble(strNum));
    }

    @Override
    public int compareTo(Number o) {
        return super.compareTo(o);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }


    }






