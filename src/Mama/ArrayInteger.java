package Mama;

import java.math.BigInteger;

public class ArrayInteger {
    private static final BigInteger BI_TEN = BigInteger.valueOf(10);
    private Byte[] digits;

    public ArrayInteger(int n) {
        digits = new Byte[n];
    }

    public void fromInt(BigInteger value) {
        if (value.compareTo(BigInteger.TEN) == -1) {
            digits[0] = value.byteValue();
        }
        for (int i = 0; value.compareTo(new BigInteger("0")) != 0; i++) {
            digits[i] = value.mod(BigInteger.TEN).byteValue();
            value=value.divide(BigInteger.TEN);
        }
    }

}


