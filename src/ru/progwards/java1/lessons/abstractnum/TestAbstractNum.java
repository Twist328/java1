package ru.progwards.java1.lessons.abstractnum;

public class TestAbstractNum {
    public static void main(String[] args) {
        Number num = new IntNumber(3);
        Figure3D fig = new Cube(num);
        System.out.println(fig.volume());

        Figure3D fig1 = new Pyramid(num);
        fig1 = new Pyramid(new DoubleNumber(1));
        System.out.println(fig1.volume());

        fig = new Cube(new DoubleNumber(3));
        System.out.println(fig.volume());

    }

    static void testNum() {
        IntNumber inum = new IntNumber(2);
        Number num = inum;

        inum = (IntNumber) num;
        print(num);
        DoubleNumber dnum = new DoubleNumber(3.0);
        print(dnum);
    }

    static void print(Number num) {
        System.out.println(num);
    }
}
