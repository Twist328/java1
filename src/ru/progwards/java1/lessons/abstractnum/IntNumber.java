package ru.progwards.java1.lessons.abstractnum;

class IntNumber extends Number {
    int num;

    public IntNumber(int num) {

        this.num = num;
    }

    @Override
    public String toString() {

        return String.valueOf(num);
    }

    @Override
    public Number mul(Number num) {
        int num2 = Integer.valueOf(num.toString());
        return new IntNumber(this.num * num2);
    }

    @Override
    public Number div(Number num) {
       int num2 = Integer.valueOf(num.toString());
       int res = this.num / num2;
        return new IntNumber(res);
    }

    @Override
    public Number newNumber(String strNum) {

        return new IntNumber(Integer.valueOf(strNum));
    }

}

