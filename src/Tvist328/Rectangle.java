package Tvist328;

public class Rectangle { //СРАВНЕНИЕ ПЕРИМЕТРОВ ПРЯМОУГОЛЬНИКОВ

    private double a;

    private double b;

    public Rectangle(double a, double b) {

        this.a = a;
        this.b = b;
    }

    public double area() {

        return a * b;
    }

    public int compareTo(Rectangle anRectangle) {


        if (this.area() > ((Rectangle) anRectangle).area()) {
            return 1;
        } else if (this.area() < ((Rectangle) anRectangle).area()) {
            return -1;
        } else {
            return 0;
        }
    }



}

