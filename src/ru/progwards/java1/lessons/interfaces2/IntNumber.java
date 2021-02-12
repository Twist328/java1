package ru.progwards.java1.lessons.interfaces2;

public class IntNumber extends Number {
    int num;

    public IntNumber(int num) {
        super();
        this.num = num;
    }

    public IntNumber() {
        super();

    }


    @Override
    public Number mul(Number num) {
        //int num2 = Integer.valueOf(num.toString());
        //int num2 = num.toInt();
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
    public int compareTo(Number o) {
        return super.compareTo(o);
    }


}









