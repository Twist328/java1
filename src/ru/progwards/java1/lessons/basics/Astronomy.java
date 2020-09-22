package ru.progwards.java1.lessons.basics;

public class Astronomy {

    public static void main(String[] args) {

        System.out.println(sphereSquare(0.0));
        earthSquare();
        System.out.println(sphereSquare(6371.2));
        mercurySquare();
        System.out.println(sphereSquare(2439.7));
        jupiterSquare();
        System.out.println(sphereSquare(71492.0));
        earthVsMercury();
        System.out.println(sphereSquare((6371.2) / (2439.7)) / 4 / 3.14);
        earthVsJupiter();
        System.out.println(sphereSquare((6371.2) / (71492.0)) / 4 / 3.14);
    }

    public static Double sphereSquare(Double r) {
        earthVsMercury();
        earthVsJupiter();
        final double PI = 3.14;
        return 4 * 3.14 * (r * r);


    }

    public static Double earthSquare() {
        final double PI = 3.14;
        final double r = 6371.2;
        return 4 * 3.14 * (r * r);
    }

    public static Double mercurySquare() {
        final double PI = 3.14;
        final double r = 2439.7;
        return 4 * 3.14 * (r * r);
    }

    public static Double jupiterSquare() {
        final double PI = 3.14;
        final double r = 71492.0;
        return 4 * 3.14 * (r * r);
    }

    public static Double earthVsMercury() {
        final double v = 5.098378993664E8;
        final double v1 = 7.475882929039998E7;
        return v / v1;
    }

    public static Double earthVsJupiter() {
        final double v = 5.098378993664E8;
        final double v1 = 6.4195492163840004E10;

        return v / v1;
    }
}

