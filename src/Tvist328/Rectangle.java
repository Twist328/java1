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

    public  int compareTo(Rectangle anRectangle) {


        if (this.area() > ((Rectangle) anRectangle).area()) {
            return 1;
        } else if (this.area() < ((Rectangle) anRectangle).area()) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {

        System.out.println(new Rectangle (20,15).compareTo(new Rectangle(18,13)));
        System.out.println(new Rectangle (20,15).compareTo(new Rectangle(19,23)));
        System.out.println(new Rectangle (20,15).compareTo(new Rectangle(15,20)));
    }

}

