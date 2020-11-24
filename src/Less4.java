import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

public class Less4 {
    static int addAsStrings(int n1, int n2) {
        String str = String.valueOf(n1);
        String str1 = String.valueOf(n2);

        return Integer.parseInt(str + str1);


    }

    public static void main(String[] args) {
        System.out.println(addAsStrings(1, 2));
        System.out.println(addAsStrings(2, 1));
        MathContext mathContext = new MathContext(3);
        BigDecimal result = new BigDecimal("3.3333", mathContext);

        String a = "Не всяко ";
        String b = "в строку";
        String c = "лыко ";
        System.out.println(a + c + b);

        float d = (float) 1000000.0;
        float f = (float) d;
        System.out.println(f);


        BigDecimal bigDec1 = BigDecimal.valueOf(10);
        BigDecimal bigDec2 = BigDecimal.valueOf(3);
        BigDecimal result1 = bigDec1.divide(bigDec2, 5, RoundingMode.HALF_UP);

        int[] a1 = {12, 5, 0, 58, 36};
        int[] a2 = Arrays.copyOf(a1, a1.length);
        Arrays.sort(a2);
        System.out.println(Arrays.equals(a1, a2));




        System.out.println(result);
        System.out.println(result1);

    }
}

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

    public int compareTo(Rectangle anRectangle) {
        if (this.area() > ((Rectangle) anRectangle).area()) {
            return 1;
        } else if (this.area() < ((Rectangle) anRectangle).area()) {
            return -1;
        } else {
            return 0;
        }
    }

    public int arrayMax(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }

        }

        return max;
    }
}

