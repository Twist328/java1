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

    public BigInteger toInt() {
        BigInteger bigInteger = new BigInteger("0");
        if (digits.length == 0) {
            return bigInteger;

        }
        if (digits.length == 1) {
            return new BigInteger(String.valueOf(digits[0]));
        }
        for (int i = 0; i < digits.length; i++) {
            bigInteger = bigInteger.add(new BigInteger(String.valueOf(new BigInteger(String.valueOf(digits[i])).multiply(BigInteger.TEN.pow(i)))));

        }
        return bigInteger;
    }

    public boolean add(ArrayInteger num) {
        boolean result = false;
        if (digits.length < num.digits.length) {
            for (int i = 0; i < digits.length; i++) {
                digits[i] = 0;

            }
            return false;
        }
        if (digits.length == num.digits.length) {
            for (int i = 0; i < digits.length; i++) {
                byte b = (byte) (digits[i] + num.digits[i]);
                if (b >= 10 & i == digits.length - 1) {
                    for (int j = 0; j < digits.length; j++) {
                        digits[j] = 0;
                    }
                     return false;
                    }
                }
                }









