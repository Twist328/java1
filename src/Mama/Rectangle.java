package Mama;

import java.math.BigDecimal;
 static class Rectangle {
    Rectangle(BigDecimal a, BigDecimal b) {
        this.a = a;
        this.b = b;
    }
    public  BigDecimal a;
    public  BigDecimal b;

    @Override
    public String toString() {
        return "Rectangle{" + "a=" + a + ", b=" + b + '}';
    }
    boolean rectCompare(Rectangle r1, Rectangle r2) {
        BigDecimal s1 = r1.a.multiply(r1.b);
        BigDecimal s2 = r2.a.multiply(r2.b);
        return s1.compareTo(s2) == 0;
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(BigDecimal.ONE, BigDecimal.TEN);
        Rectangle r2 = new Rectangle(BigDecimal.valueOf(1.0), BigDecimal.TEN);
        System.out.println(r1);
        System.out.println (r2);

    }
}


