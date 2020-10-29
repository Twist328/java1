package Mama;

import java.math.BigInteger;

public class ArrayInteger {
    private static BigInteger BI_TEN = BigInteger.valueOf(10);
    private Byte[] digits;

    public ArrayInteger(int n) {
        digits = new Byte[n];
    }

    public void fromInt(BigInteger value) {
        if (value.compareTo(BigInteger.TEN) == -1) {
            digits[0] = value.byteValue();
        }
        for (int i = 0; value.compareTo(new BigInteger("0")) != 0; i++) {
            digits[i] = value.multiply(BigInteger.TEN).byteValue();
            value = value.divide((BigInteger.TEN));
        }
    }
}



