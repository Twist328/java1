package ru.progwards.java1.lessons.bigints;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.*;

public class ArrayInteger {

    private final static BigInteger BI_TEN = BigInteger.valueOf(10);
    private Byte[] digits;

    public ArrayInteger(int n) {
        digits = new Byte[n];
    }

    public void fromInt(BigInteger value) {
        final List<Byte> list = new ArrayList<>();
        while (!value.equals(BigInteger.ZERO)) {
            list.add(value.mod(BI_TEN).byteValueExact());
            value = value.divide(BI_TEN);
        }
        Collections.reverse(list);
        digits = list.toArray(new Byte[list.size()]);
    }

    BigInteger toInt() {
        BigInteger bigInteger = new BigInteger("0");
        if (digits.length == 0) {
            return bigInteger;
        }
        if (digits.length == 1) {
            return new BigInteger(String.valueOf(digits[0]));
        }
        for (int i = 0; i < digits.length; i++) {
            bigInteger = bigInteger.add(new BigInteger(String.valueOf(new BigInteger(String.valueOf(digits[i])).
                    multiply(BigInteger.TEN.pow(i)))));
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
                if (b >= 10) {
                    digits[i] = (byte) (b % 10);
                    digits[i + 1] = (byte) (digits[i + 1] + (b / 10));
                } else {
                    digits[i] = b;
                }
            }
            result = true;
        }
        if (digits.length > num.digits.length) {
            for (int i = 0; i < num.digits.length; i++) {
                byte b = (byte) (digits[i] + num.digits[i]);
                if (b >= 10 & digits[num.digits.length] == 9 & digits.length == num.digits.length + 1) {
                    for (int j = 0; j < digits.length; j++) {
                        digits[j] = 0;
                    }
                    return false;
                }
                if (b >= 10) {
                    digits[i] = (byte) (b % 10);
                    digits[i + 1] = (byte) (digits[i + 1] + (b / 10));
                } else {
                    digits[i] = b;
                }
            }
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] > 9 & i == digits.length - 1) {
                    for (int j = 0; j < digits.length; j++) {
                        digits[i] = 0;
                    }
                } else if (digits[i] > 9) {
                    digits[i + 1] = (byte) (digits[i + 1] + digits[i] / 10);
                    digits[i] = (byte) (digits[i] % 10);
                }
            }
            result = true;
        }
        return result;
    }
}
    /*/public static void main(String[] args) {
        ArrayInteger arrayInteger = new ArrayInteger(9);
       System.out.println(Arrays.toString(arrayInteger.digits));
        arrayInteger.fromInt(new BigInteger("89289799"));
        System.out.println(Arrays.toString(arrayInteger.digits));
        System.out.println(arrayInteger.toInt());
        ArrayInteger arrayInteger1 = new ArrayInteger(5);
        arrayInteger1.fromInt(new BigInteger("805097"));
        System.out.println(arrayInteger.add(arrayInteger1));
        System.out.println(Arrays.toString(arrayInteger.digits));
    }
}*/
/*/public class ArrayInteger {
    byte[] digits;

    ArrayInteger(int n) {
        digits = new byte[n];
    }

    void fromInt(BigInteger value) {
        if (value.compareTo(BigInteger.TEN) == -1) {
            digits[0] = value.byteValue();
        }
        for (int i = 0; value.compareTo(new BigInteger("0")) != 0; i++) {
            digits[i] = value.mod(BigInteger.TEN).byteValue();
            value = value.divide(BigInteger.TEN);
        }
    }

    BigInteger toInt() {
        BigInteger bigInteger = new BigInteger("0");
        if (digits.length == 0) {
            return bigInteger;
        }
        if (digits.length == 1) {
            return new BigInteger(String.valueOf(digits[0]));
        }
        for (int i = 0; i < digits.length; i++) {
            bigInteger = bigInteger.add(new BigInteger(String.valueOf(new BigInteger(String.valueOf(digits[i])).
                    multiply(BigInteger.TEN.pow(i)))));
        }
        return bigInteger;
    }

    boolean add(ArrayInteger num) {
        boolean result = false;
        if (digits.length < num.digits.length) {
            for (int i = 0; i < digits.length; i++) {
                digits[i] = 0;
            }
            return false;
        }
        if (digits.length == num.digits.length) {
            for (int i = 0; i < digits.length; i++) {
                byte number = (byte) (digits[i] + num.digits[i]);
                if (number >= 10 & i == digits.length - 1) {
                    for (int j = 0; j < digits.length; j++) {
                        digits[j] = 0;
                    }
                    return false;
                }
                if (number >= 10) {
                    digits[i] = (byte) (number % 10);
                    digits[i + 1] = (byte) (digits[i + 1] + (number / 10));
                } else {
                    digits[i] = number;
                }
            }
            result = true;
        }
        if (digits.length > num.digits.length) {
            for (int i = 0; i < num.digits.length; i++) {
                byte number = (byte) (digits[i] + num.digits[i]);
                if (number >= 10 & digits[num.digits.length] == 9 & digits.length == num.digits.length + 1) {
                    for (int j = 0; j < digits.length; j++) {
                        digits[j] = 0;
                    }
                    return false;
                }
                if (number >= 10) {
                    digits[i] = (byte) (number % 10);
                    digits[i + 1] = (byte) (digits[i + 1] + (number / 10));
                } else {
                    digits[i] = number;
                }
            }
            for (int i = 0; i < digits.length; i++) {
                if (digits[i] > 9 & i == digits.length - 1) {
                    for (int j = 0; j < digits.length; j++) {
                        digits[i] = 0;
                    }
                } else if (digits[i] > 9) {
                    digits[i + 1] = (byte) (digits[i + 1] + digits[i] / 10);
                    digits[i] = (byte) (digits[i] % 10);
                }
            }
            result = true;
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayInteger arrayInteger = new ArrayInteger(8);
//        System.out.println(Arrays.toString(arrayInteger.digits));
        arrayInteger.fromInt(new BigInteger("15980465"));
        System.out.println(Arrays.toString(arrayInteger.digits));
        System.out.println(arrayInteger.toInt());
        ArrayInteger arrayInteger1 = new ArrayInteger(5);
        arrayInteger1.fromInt(new BigInteger("69268"));
        System.out.println(arrayInteger.add(arrayInteger1));
        System.out.println(Arrays.toString(arrayInteger.digits));
    }
}*/