package ru.progwards.java1.lessons.bigints;

import static ru.progwards.java1.lessons.bigints.AbsInteger.add;

public class TestInteger {
    public static void main(String[] args) {
        AbsInteger num1 = new ShortInteger((short) 32700);
        AbsInteger num2 = new IntInteger( -32768);

        int a = num1.intValue();
        int b = num2.intValue();

        int res = (a + b);
        
        AbsInteger result = add(num1,num2);
        System.out.println(result);


        if (res > -128 & res < 127) {
            System.out.println(res + " : - it is a ByteInteger");
        } else if (res < -128 & res >= -32768) {
            System.out.println(res + " : - it is a ShortInteger");
        } else if (res > 127 & res <= 32767) {
            System.out.println(res + " : - it is a ShortInteger");
        } else {
            System.out.println(res + " : - it is a IntInteger");
        }
    }
}


