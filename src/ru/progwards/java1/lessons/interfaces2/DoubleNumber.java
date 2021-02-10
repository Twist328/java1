package ru.progwards.java1.lessons.interfaces2;

public class DoubleNumber extends Number implements Comparator {
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
    Comparator<DoubleNumber> comparator = new Comparator<DoubleNumber>() {
        @Override
        public int compare(DoubleNumber o1, DoubleNumber o2) {
            return 0;
        }


    };

}

