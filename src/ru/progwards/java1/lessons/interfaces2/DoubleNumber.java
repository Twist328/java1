package ru.progwards.java1.lessons.interfaces2;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.DoubleStream;

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
    public int compareTo(Number obj) {
        DoubleNumber entry = (DoubleNumber) obj;

        double result = this.num - (double) entry.num;
        if (result != 0) {
            return (int) result;
        }
        result = this.num - ((entry.num));
        if (result != 0) {
            return (int) ((int) result / Math.abs(result));
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }



    public static void main(String[] args) throws IOException {


        Double[] a = new Double[]{Double.valueOf(50), Double.valueOf(110), Double.valueOf(33)};
        Arrays.sort( a);
        System.out.println(Arrays.toString(( a)));
    }


}





