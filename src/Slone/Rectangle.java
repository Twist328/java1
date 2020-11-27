package Slone;

import java.util.Objects;

class Rectangle {
    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double area() {

        return a * b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;
        Rectangle rectangle = (Rectangle) o;
        return Double.compare(rectangle.a, a) >= 0 &&
                Double.compare(rectangle.b, b) <= 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }


    public static void main(String[] args) {

        System.out.println(new Rectangle(20, 15).equals(new Rectangle(20, 15)));
        System.out.println(new Rectangle(20, 15).equals(new Rectangle(19, 23)));
        System.out.println(new Rectangle(20, 15).equals(new Rectangle(15, 20)));
    }
}
