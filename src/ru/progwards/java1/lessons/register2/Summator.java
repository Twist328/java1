package ru.progwards.java1.lessons.register2;



public class Summator {

    public static boolean add(ByteRegister value1, ByteRegister value2) {
        boolean pr = false; // бит переноса с предыдущего регистра
        boolean nv; // новое значение бита для value1
        boolean b1, b2;
        for(int i = 0; i < value1.len; i++) {
            b1 = value1.bits[i].get();
            b2 = value2.bits[i].get();
            nv = b1 ^ b2 ^ pr;
            pr = b1 && b2 || b1 && pr || b2 && pr;
            value1.bits[i].set(nv);
        }
        return !pr;
    }

    // второе дополнение в дополнительном коде
    public static ByteRegister invert(ByteRegister value) {
        ByteRegister bR = new ByteRegister((ByteRegister) value);

        for (int i = 0; i < bR.len; i++) {
            bR.bits[i].set(!bR.bits[i].get());
        }
        Counter.inc((ByteRegister) bR);
        //result.print();
        return bR;
    }

    public static boolean sub(ByteRegister value1, ByteRegister value2) {
        ByteRegister value3 = invert(value2);
        return add(value1, value3);
    }

    public static void main(String[] args) {
        ByteRegister a = new ByteRegister((byte)0b1001_0111);
        ByteRegister b = new ByteRegister((byte)0b1001_0111);
        a.print();
        b.print();
        System.out.println(Summator.add(a, b));
        a.print();
        System.out.println(Summator.add(a, a));
        a.print();
    }

}

