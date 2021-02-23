package ru.progwards.java1.lessons.register2;



public class ByteRegister {

    public Bit[] bits;
    public int len = 8; // количество бит
    public boolean signed = false; // знаковое ли число
    public enum Score {JUST, BEFORE, ADDITION}
    public Score scorType = Score.JUST;

    public ByteRegister() {
        init();
    }

    public ByteRegister(byte value) {
        this();
        set(value);
    }

    public ByteRegister(ByteRegister value) {
        this();
        set(value);
    }

    protected void init() {
        bits = new Bit[len];
        for (int i = 0; i < len; i++) {
            bits[i] = new Bit();
        }
    }

    public void set(byte value) {
        int last = len - 1;
        bits[last].set(value < 0); // запоминаем знаковый бит
        value &= 0x7F; // отбрасываем знаковый бит
        for (int i = 0; i < last; i++) {
            bits[i].set((value & 1) == 1);
            value >>>= 1;
        }
    }

    public void set(ByteRegister value) {
        boolean differ = len != value.len;
        len = value.len;
        signed = value.signed;
        scorType = value.scorType;
        if (differ) init();
        for (int i = 0; i < len; i++) {
            bits[i].set(value.bits[i].get());
        }
    }

    // вывод в двоичном виде
    public String toString() {
        String str = "";
        for (int i = len - 1; i >= 0; i--) str += bits[i];
        return str;
    }

    // вывод в десятичной системе счисления
    public String toDecString() {
        int sum, a = 1, last;
        boolean lastBitVal = false;

        if (signed) {
            last = len - 1;
            lastBitVal = bits[last].get();
            if (scorType == Score.ADDITION && lastBitVal) {
                // отрицательное число в дополнительной форме записи
                sum = -1;
                for (int i = 0; i < last; i++) {
                    if (!bits[i].get()) sum -= a;
                    a <<= 1;
                }
                return Integer.toString(sum);
            }
        } else {
            last = len;
        }
        sum = 0;
        for (int i = 0; i < last; i++) {
            if (bits[i].get()) sum += a;
            a <<= 1;
        }
        if (signed && lastBitVal) {
            sum *= -1;
        }
        return Integer.toString(sum);
    }

    public void print() {
        System.out.println("0b" + this.toString() + " = (int)" + Integer.parseInt(this.toString()) + " = (dec)" + this.toDecString());
    }

    // tests
    public static void main(String[] args) {
        ByteRegister bR = new ByteRegister();
        bR.print();
        bR = new ByteRegister((byte)0b1001_0001);
        bR.print();
        bR.set((byte)0b1111_1111);
        bR.print();
    }

}
