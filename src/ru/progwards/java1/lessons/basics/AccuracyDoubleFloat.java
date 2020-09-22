package ru.progwards.java1.lessons.basics;

public class AccuracyDoubleFloat {

    public static float volumeBallFloat(float radius) {
        int m = (int) 3.14;
        float b = (float) 3.14F;
        float temp = (float) radius;
        return (float) Math.abs(4 * b * (temp * temp * temp) / 3);
    }

    public static double volumeBallDouble(double radius) {
        radius = 6371.2;
        final double m = 3.14;
        return Math.abs(4 * m * (radius * radius * radius) / 3);
    }

    public static double calculateAccuracy(double radius) {
        int m = (int) 3.14;
        radius = 6371.2;
        float b = (float) 3.14F;
        float temp = (float) 6371.2F;
        return (4 * 3.14 * (radius * radius * radius) / 3 - (float) (4 * 3.14 * (temp * temp * temp) / 3));
    }

    public static void main(String[] args) {

        System.out.println(volumeBallDouble(6371.2));

        System.out.println(volumeBallFloat(6371.2F));

        System.out.println(calculateAccuracy(6371.2 - 6371.2F));
    }

}



