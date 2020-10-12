package ru.progwards.java1.lessons.bigints;

import static ru.progwards.java1.lessons.bigints.AbsInteger.add;

public class TestInteger {
    public static void main(String[] args) {
        AbsInteger num1 = new IntInteger( 111157);
        AbsInteger num2 = new ShortInteger((short)-8000);


        int a = num1.intValue();
        int b = num2.intValue();

        AbsInteger result  =  add(num1,num2);
        System.out.println(result);

        int res = (a + b);


        if (res>-128&res<127){
            System.out.println(res+"    ByteInteger");
        } else if (res < -128 | res <= -32768) {
            System.out.println(res+"    ShortInteger");
        } else if( res > 127 & res <= 32767) {
            System.out.println(res+"    ShortInteger");
        }else {
            System.out.println(res+"    IntInteger");
        }
    }
}


