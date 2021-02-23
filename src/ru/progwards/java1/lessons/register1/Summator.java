package ru.progwards.java1.lessons.register1;

/*
Класс Summator - сумматор, должен содержать 1 статический метод
public static boolean add(ByteRegister value1, ByteRegister value2)
Класс должен корректно реализовывать сложение целых положительных чисел,
результат помещается в первый регистр value1. Метод возвращает true если
не было переполнения (выход за границы значения числа) и false если было
*/

public class Summator {

    public static boolean add(ByteRegister value1, ByteRegister value2) {
        boolean perr = false; // бит переноса с предыдущего регистра
        boolean neo; // новое значение бита для value1
        boolean bit1, bit2;
        for(int i = 0; i < value1.len; i++) {
            bit1 = value1.bits[i].get();
            bit2 = value2.bits[i].get();
            neo = bit1 ^ bit2^ perr;
            perr = bit1 && bit2 || bit1 && perr || bit2 && perr;
            value1.bits[i].set(neo);
        }
        return !perr;
    }

    // второе дополнение в дополнительном коде
    public static ByteRegister invert(ByteRegister value) {
        ByteRegister bR = new ByteRegister(value);
        /*if (result.signed && result.negStoreType != ByteRegister.NegStoreType.ADDITIONAL && result.bits[result.size - 1].get()) {
            result.bits[result.size - 1].set(false); // инвертируем знаковый бит для отрицательных
        }*/
        for (int i = 0; i < bR.len; i++) {
            bR.bits[i].set(!bR.bits[i].get());
        }
        Counter.inc(bR);
        //result.print();
        return bR;
    }

    public static boolean sub(ByteRegister value1, ByteRegister value2) {
        ByteRegister value3 = invert(value2);
        return add(value1, value3);
    }

    public static void main(String[] args) {
        ByteRegister bR1 = new ByteRegister((byte)0b1001_0111);
        ByteRegister bR2 = new ByteRegister((byte)0b1001_0111);
        bR1.print();
        bR2.print();
        System.out.println(Summator.add(bR1, bR2));
        bR1.print();
        System.out.println(Summator.add(bR1, bR1));
        bR1.print();
    }
}

