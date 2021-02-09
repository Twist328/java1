package ru.progwards.java1.lessons.register1;

/*
Класс ShiftRegister - регистр со сдвигом, должен содержать 2 статических метода
public static void left(ByteRegister value)
public static void right(ByteRegister value)
Класс должен корректно реализовывать сдвиг влево и сдвиг вправо значения целого числа, работая непосредственно в
ByteRegister value
*/

public class ShiftRegister {

    public static void left(ByteRegister value) {
        for (int i = value.len - 1; i > 0; i--) value.bits[i].set(value.bits[i-1].get());
        value.bits[0].set(false);
    }

    public static void right(ByteRegister value) {
        for (int i = 1; i < value.len; i++) value.bits[i-1].set(value.bits[i].get());
        value.bits[value.len - 1].set(false);
    }


    public static void main(String[] args) {
        ByteRegister bR = new ByteRegister((byte)0b1001_0111);
        bR.print();
        ShiftRegister.left(bR);
        bR.print();
        ShiftRegister.left(bR);
        bR.print();
        ShiftRegister.left(bR);
        bR.print();
        System.out.println("Right:");
        bR.set((byte)0b1011_1110);
        bR.print();
        ShiftRegister.right(bR);
        bR.print();
        ShiftRegister.right(bR);
        bR.print();
        ShiftRegister.right(bR);
        bR.print();
    }

}

