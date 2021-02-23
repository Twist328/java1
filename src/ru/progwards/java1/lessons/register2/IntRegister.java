package ru.progwards.java1.lessons.register2;

import java.util.Arrays;

public class IntRegister extends ByteRegister {

    public IntRegister() {
        len= 32;
        signed = true;
        Score scorType = Score.BEFORE;
        init();
    }

    public IntRegister(int value) {
        this();
        set(value);
    }

    public void set(int value) {
        int last = len - 1;
        bits[last].set(value < 0); // запоминаем знаковый бит
        value &= 0x7F_FF_FF_FF; // отбрасываем знаковый бит
        for (int i = 0; i < last; i++) {
            bits[i].set((value & 1) == 1);
             value >>>=1;
        }
    }

    @Override
    public void print() {
        System.out.println("0b" + this.toString() + " = (dec)" + this.toDecString());
    }

    // tests
    public static void main(String[] args) {
        IntRegister r = new IntRegister();
       /* r.print();*/
        r = new IntRegister(-237968432);
        r.print();
       /* r.set(1);
        r.print();*/

        /*IntRegister r = new IntRegister(1);
        r.print();
        Counter.inc(r);
        r.print();
        r.set(Integer.MAX_VALUE);
        r.print();
        Counter.inc(r);
        r.print();
        r.set(-1);
        r.print();
        Counter.inc(r);
        r.print();
        System.out.println("Decrement:");
        r.set(5);
        r.print();
        Counter.dec(r);
        r.print();
        r.set(0);
        r.print();
        Counter.dec(r);
        r.print();
        r.set(-1);
        r.print();
        Counter.dec(r);
        r.print();*/

        /*IntRegister a = new IntRegister(-2132582563);
        IntRegister b = new IntRegister(0);
        a.print();
        b.print();
        /*System.out.println(Summator.add(a, b));
        a.print();
        System.out.println(Summator.add(a, b));
        a.print();
        System.out.println(Summator.sub(a, b));
        a.print();
        System.out.println(Summator.sub(b, a));
        b.print();*/
    }

}
