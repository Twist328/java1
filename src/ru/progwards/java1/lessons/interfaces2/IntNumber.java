package ru.progwards.java1.lessons.interfaces2;

public class IntNumber extends Number implements Comparator{
    int num;

    public IntNumber(int num) {
        this.num = num;
    }

    public IntNumber() {

    }


    @Override
    public Number mul(Number num){
        //int num2 = Integer.valueOf(num.toString());
        //int num2 = num.toInt();
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
    @Override
    public String toString() {
        return String.valueOf(num);
    }
    Comparator<IntNumber> comparator = new Comparator<IntNumber>() {
        @Override
        public int compare(IntNumber o1, IntNumber o2) {
            return 0;
        }


    };

}



