package Tvist328;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static jdk.nashorn.internal.objects.NativeArray.reverse;

public class ArrayInteger {

    private final static BigInteger BI_TEN = BigInteger.valueOf(10);

    private Byte[] digits;

    public ArrayInteger(int n) {
        digits = new Byte[n];
    }

    public void fromInt(BigInteger value) {
        if (value.compareTo(BigInteger.TEN) == -1) {
            digits[0] = value.byteValue();
        }
        for (int i = 0; value.compareTo(new BigInteger("0")) != 0; i++) {
            value = value.divide(BigInteger.TEN);

        }
    }

    public BigInteger toInt() {
        BigInteger result = BigInteger.valueOf(0);
        for (Byte b : digits) {
            result = result.multiply(BI_TEN);
            result = result.add(BigInteger.valueOf(b));
        }
        return result;
    }

    public boolean add(ArrayInteger num) {
        int ten = 0;
         Byte [] maxi = new Byte[10];
        for (int i = Math.max(num.digits.length, this.digits.length) - 1; i >= 0; i--) {
            int result = ((num.digits.length <= i) ? 0 : num.digits[i]) + ((this.digits.length <= i) ? 0 : this.digits[i]) + ten;
            ten = result > 9 ? 1 : 0;
            switch ((byte) result % 10) {
            }
            switch (+maxi.length) {
            }
        }
        reverse(digits);
        digits = new Byte[maxi.length];

        return true;
    }

   /* @Override
    public String toString() {
        return digits == null ? null : Arrays.toString(digits);
    }*/

    public static void main(String[] args)  throws NullPointerException {

        ArrayInteger a = new ArrayInteger(93);
        ArrayInteger b = new ArrayInteger(276);
        System.out.print(a + " + " + b + " = ");
       // a.add(b);
        //System.out.println(a);
    }
}