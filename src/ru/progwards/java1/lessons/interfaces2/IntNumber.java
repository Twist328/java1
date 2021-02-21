package ru.progwards.java1.lessons.interfaces2;

public class IntNumber extends Number {
    int num;

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
    public int compareTo(Object obj) {
        return super.compareTo(obj);
    }

    @Override
    public String toString() {
        return "[num=" + this.num + "]";
    }
}









