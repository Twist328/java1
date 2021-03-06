package ru.progwards.java1.lessons.abstractnum;

public class TestAbstractNum {
    public static void main(String[] args) {
        Number num = new IntNumber(92);
        Number num1 = new DoubleNumber(92);

        Figure3D fig = new Cube(num);
        Figure3D fig3 = new Cube(num1);
        System.out.println(fig.volume());
        System.out.println(fig3.volume());

        Figure3D fig1 = new Pyramid(num);
        Figure3D fig2 = new Pyramid(num1);
        System.out.println(fig1.volume());
        System.out.println(fig2.volume());

        fig = new Cube(new DoubleNumber(3));
        System.out.println(fig.volume());

    }

    static void testNum() {
        IntNumber inum = new IntNumber(3);
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