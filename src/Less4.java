import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Less4 {
    static int addAsStrings(int n1, int n2) {
        String str = String.valueOf(n1);
        String str1 = String.valueOf(n2);

        return Integer.parseInt(str+str1);


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

        float d= (float) 1000000.0;
        float f = (float)d;
        System.out.println(f);



        BigDecimal bigDec1 = BigDecimal.valueOf(10);
        BigDecimal bigDec2 = BigDecimal.valueOf(3);
        BigDecimal result1 = bigDec1.divide(bigDec2, 5, RoundingMode.HALF_UP);


        System.out.println(result);
        System.out.println(result1);
    }
}




