package Tvist823Tests;

import java.math.BigDecimal;
import java.util.Objects;

class Rectangle {
    public static Rectangle r1; //СРАВНЕНИЕ ПРЯМОУГОЛЬНИКОВ ПО ПЛОЩАДИ ЧЕРЕЗ ФУНКЦИЮ ПЕРЕОПРЕДЕЛЕНИЯ equals и hashCode()



    private double a;
    private double b;

    public Rectangle(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Rectangle(BigDecimal one, BigDecimal ten) {
    }

    public double area() {

        return a * b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;

        return Double.compare(rectangle.a, b) >= 0 &&
                Double.compare(rectangle.b, b) <= 0 ;

    }
    @Override
    public int hashCode() {
        return Objects.hash(a, b);
    }


    public static void main(String[] args) {

        System.out.println(new Rectangle(2, 3).equals((new Rectangle(3, 2))));
        System.out.println(new Rectangle(3, 3).equals((new Rectangle(2, 2))));
        System.out.println(new Rectangle(3, 4).equals((new Rectangle(6, 2))));
        System.out.println(new Rectangle(2, 2).equals((new Rectangle(2, 2))));
        System.out.println(new Rectangle(2, 2).equals(null));
        System.out.println(new Rectangle(2, 2).equals(new Object()));
        System.out.println(Objects.hash(3, 2));
        System.out.println(Objects.hash(2, 3));
        System.out.println(Objects.hash(3, 3));
        System.out.println(Objects.hash(2, 2));
        System.out.println(Objects.hash(3, 4));
        System.out.println(Objects.hash(6, 2));
        System.out.println(Objects.hash(0, 0));
    }

    public int getArea() {
        return 0;
    }
}


