package ru.progwards.java1.lessons.interfaces2;

import java.util.Comparator;

public class DoubleNumber extends Number  {
    double num;

    @Override
    public Number div(Number num) {
        double num2 = Double.valueOf(num.toString());
        return new DoubleNumber(this.num/num2);
    }

    public DoubleNumber(double num) {
        this.num = num;
    }

    @Override
    public Number mul(Number num) {
        double num2 = Double.valueOf(num.toString());
        return new DoubleNumber(this.num*num2);
    }
    public Number newNumber(String strNum){
        return new DoubleNumber(Double.parseDouble(strNum));
    }
    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public int compare(Number o1, Number o2) {
        return super.compare(o1, o2);
    }


}




