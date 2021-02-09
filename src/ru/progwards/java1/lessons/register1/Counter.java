package ru.progwards.java1.lessons.register1;

/*  Класс Counter - счетчик, должен содержать 2 статических метода
public static void inc(ByteRegister value)
public static void dec(ByteRegister value)
        Класс должен корректно инкрементировать и декрементировать значение целого числа,
        работая непосредственно в ByteRegister value. При инкременте максимального числа
        (все единички) получаем 0, при декременте 0 - все единички.
        */
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
        ByteRegister bR = new ByteRegister((byte)0b1001_0111);
        bR.print();
        Counter.inc(bR);
        bR.print();
        bR.set((byte)0b1111_1111);
        bR.print();
        Counter.inc(bR);
        bR.print();
        bR.set((byte)0b1111_1110);
        bR.print();
        Counter.inc(bR);
        bR.print();
        System.out.println("Decrement:");
        bR.set((byte)0b0011_1110);
        bR.print();
        Counter.dec(bR);
        bR.print();
        bR.set((byte)0b1001_1001);
        bR.print();
        Counter.dec(bR);
        bR.print();
        bR.set((byte)0b0000_0000);
        bR.print();
        Counter.dec(bR);
        bR.print();
    }

}
