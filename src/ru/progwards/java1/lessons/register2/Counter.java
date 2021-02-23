package ru.progwards.java1.lessons.register2;

import ru.progwards.java1.lessons.register1.ByteRegister;

public class Counter {

    public static void inc(ByteRegister value) {
        int i = 0;
        while (i < value.len) {
            if(value.bits[i].get()) {
                value.bits[i].set(false);
                i++;
                continue;
            } else {
                value.bits[i].set(true);
                break;
            }
        }
    }

    public static void dec(ByteRegister value) {
        int i = 0;
        while (i < value.len) {
            if(value.bits[i].get()) {
                value.bits[i].set(false);
                break;
            } else {
                value.bits[i].set(true);
                i++;
                continue;
            }
        }
    }

    public static void main(String[] args) {
        ByteRegister r = new ByteRegister((byte)0b1001_0111);
        r.print();
        Counter.inc(r);
        r.print();
        r.set((byte)0b1111_1111);
        r.print();
        Counter.inc(r);
        r.print();
        r.set((byte)0b1111_1110);
        r.print();
        Counter.inc(r);
        r.print();
        System.out.println("Decrement:");
        r.set((byte)0b0011_1110);
        r.print();
        Counter.dec(r);
        r.print();
        r.set((byte)0b1001_1001);
        r.print();
        Counter.dec(r);
        r.print();
        r.set((byte)0b0000_0000);
        r.print();
        Counter.dec(r);
        r.print();
    }

}
