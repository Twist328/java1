package Mama;

import java.math.BigInteger;
import java.util.Arrays;


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

    boolean add(ru.progwards.java1.lessons.bigints.ArrayInteger num) {
        int sigMax = num.signif >= signif ? num.signif : signif; // max cущественный
        int len = digits.length;
        int leng = num.digits.length;
        int transfer = 0; // перенос
        int rez; // результат для цифр
        int sig = 0; // ИНДЕКС последнего значащего
        for (int i = 0; i <= sigMax; i++) {
            rez = transfer;
            if (i < len) rez += digits[i];
            if (i < leng) rez += num.digits[i];
            if (rez > 0) {
                sig = i;
                if (sig >= len) return raiseCalcError();
                digits[sig] = (byte) (rez % 10);
            } else {
                if (i < len) digits[i] = 0;
            }
            transfer = rez / 10;
        }
        signif = sig + 1;
        return true;
    }
    @Override
    public String toString() {
        byte[] res = new byte[signif];
        for (int i = signif - 1, j = 0; i >= 0; i--, j++) {
            res[j] = (byte) (digits[i] + '0');
        }
        return new String(res);
    }
    public static void main(String[] args) {
        ru.progwards.java1.lessons.bigints.ArrayInteger a = new ru.progwards.java1.lessons.bigints.ArrayInteger("2897");
        ru.progwards.java1.lessons.bigints.ArrayInteger b = new ru.progwards.java1.lessons.bigints.ArrayInteger("8934");
        System.out.print(a + " + " + b + " = ");
        a.add(b);
        System.out.println(a);
    }
}