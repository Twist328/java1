import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Less4 {
    static int addAsStrings(int n1, int n2) {


        return (n1+n2);


    }

    public static void main(String[] args) {
        System.out.println(addAsStrings(1, 3));
        MathContext mathContext = new MathContext(3);
        BigDecimal result = new BigDecimal("3.3333", mathContext);


        BigDecimal bigDec1 = BigDecimal.valueOf(10);
        BigDecimal bigDec2 = BigDecimal.valueOf(3);
        BigDecimal result1 = bigDec1.divide(bigDec2, 5, RoundingMode.HALF_UP);


        System.out.println(result);
        System.out.println(result1);
    }
}




