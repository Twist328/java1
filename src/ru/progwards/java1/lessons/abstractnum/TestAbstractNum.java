package ru.progwards.java1.lessons.abstractnum;

public class TestAbstractNum {
    public static void main(String[] args) {
        Number num = new IntNumber(2);

        System.out.println(num);

        Figure3D fig = new Cube(num);
        printVolume(fig);


    }

    static void printVolume(Figure3D fig) {
        System.out.println(fig.volume());
    }
}
