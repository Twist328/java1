package ru.progwards.java1.lessons.interfaces2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Number implements Comparable<Number> {

    Number num;

    public Number() {

    }

    public Number mul(Number num) {//, который будет возвращать произведение содержимого класса на num.
        return null;
    }

    public Number div(Number num) {//, который будет возвращать частное от деления содержимого класса на num.
        return null;
    }

    public Number newNumber(String strNum) {//, который будет возвращать новый экземпляр класса с указанным значением.
        return null;
    }

    public Number(Number num) {
        this.num = num;
    }

    public static void main(String[] args) {
        int[] b = new Random().ints(15, -50, 100).toArray();
        Arrays.sort(b);

        System.out.println(Arrays.toString(b));
    }



    public int compare(Number o1, Number o2) {


        if (o1 instanceof IntNumber && o2 instanceof IntNumber) {
            return ((IntNumber) o1).compareTo((IntNumber) o2);
        } else if (o1 instanceof DoubleNumber && o2 instanceof DoubleNumber) {
            return ((DoubleNumber) o1).compareTo((DoubleNumber) o2);

        } else {
            throw new RuntimeException("Ooopps!");
    /*public int compareTo(Number o) {
        if(this.num == o.num) return 0;
        else
            return (this.num.compareTo( o.num)>0) ? 1 : -1;*/
        }
   /* public int compareTo(Number o) {
        Number num=(Number)o;
        return this.num.compareTo(o.num);*/

    }


    @Override
    public int compareTo(Number o) {
if (((Object) num).getClass().equals(((Object) o.num).getClass())) {
        // both numbers are instances of the same type!
        if (num instanceof Comparable) {
        // and they implement the Comparable interface
        return ((Comparable)this.num).compareTo(o.num);
        }
        }
        // for all different Number types, let's check there double values
        if (this.num.doubleValue()!=(o.num.doubleValue()))
        return -1;
        if (!(this.num.doubleValue() == o.num.doubleValue()))
        return 1;
        return 0;
        }

    private boolean doubleValue() {
        return true;
    }
    }


