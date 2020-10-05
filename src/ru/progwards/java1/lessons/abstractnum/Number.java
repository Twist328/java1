package ru.progwards.java1.lessons.abstractnum;
 public class Number {
    public Number mul(Number num) {
        return null;
    }

    public Number div(Number num) {
        return null;
    }

    public Number newNumber(String strNum) {
        return null;
    }

    public String toString() {
        return null;
    }

     private int number;

     Number(int number) {
         this.number = number;
     }

     public int get() {
         return number;
     }

     public Number add(Number number) {
         return new Number(this.number + number.get());
     }

 }
