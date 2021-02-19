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


    public int compareTo(DoubleNumber o) {
        DoubleNumber num = (DoubleNumber) o;
        return this.num.compareTo(o.num);
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }


    }






