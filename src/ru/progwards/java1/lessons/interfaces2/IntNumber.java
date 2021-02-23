package ru.progwards.java1.lessons.interfaces2;

import java.io.IOException;
import java.util.Arrays;

public class IntNumber extends Number {
    Integer num;

    public IntNumber(int num) {

        this.num = num;
    }

    @Override
    public Number mul(Number num) {
        int num2 = ((IntNumber) num).num;
        return new IntNumber(this.num * num2);
    }

    @Override
    public Number div(Number num) {
        int num2 = ((IntNumber) num).num;
        return new IntNumber(this.num / num2);
    }

    public Number newNumber(String strNum) {
        return new IntNumber(Integer.parseInt(strNum));
    }


    @Override
    public int compareTo(Number obj) {
        IntNumber entry = (IntNumber) obj;

        int result = this.num - (Integer) entry.num;
        if (result != 0) {
            return result;
        }
        result = this.num - ((entry.num));
        if (result != 0) {
            return (int) result / Math.abs(result);
        }
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }
    public static void main(String[] args) throws IOException {


        int a[] = {89, 58, 34};
        Arrays.sort(((int[]) a));
        System.out.println(Arrays.toString(((int[]) a)));
    }
}










