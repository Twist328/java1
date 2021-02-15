package Goon;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Objects;

class Rectangle {

    Rectangle(BigDecimal a, BigDecimal b) {
        this.a = a;
        this.b = b;
    }

    public BigDecimal a;
    public BigDecimal b;

    boolean rectCompare(Rectangle r1, Rectangle r2) {
        BigDecimal s1 = r1.a.multiply(r1.b);
        BigDecimal s2 = r2.a.multiply(r2.b);
        return s1.compareTo(s2) == 0;
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(BigDecimal.ONE, BigDecimal.TEN);
        Rectangle r2 = new Rectangle(BigDecimal.valueOf('1'), BigDecimal.TEN);
        System.out.println(r1);
        System.out.println (r2);
        System.out.println ((new Rectangle(BigDecimal.ONE, BigDecimal.TEN).equals(new Rectangle(BigDecimal.valueOf(1.0), BigDecimal.TEN))));

        MathContext mathContext = new MathContext(3);
        BigDecimal result = new BigDecimal("3.3333", mathContext);
        System.out.println(result);

        BigDecimal bigDec1 = BigDecimal.valueOf(10);
        BigDecimal bigDec2 = BigDecimal.valueOf(3);
        BigDecimal result1 = bigDec1.divide(bigDec2, 5, RoundingMode.HALF_UP);
        System.out.println(result1);

    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

