package ru.progwards.java1.lessons.bigints;

class ShortInteger extends AbsInteger {
    short num;

    public ShortInteger(short num) {
        super();
        this.num = num;
    }
    @Override
    public short shortValue() {
        return num;
    }
    @Override
    public int intValue() {
        return num;
    }
    @Override
    public String toString() {
        return "" + num;
    }
    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        num1 = num1;
        num2 = num2;
        int a = num1.shortValue();
        int b = num2.shortValue();

        return new ShortInteger((short)(a + b));
    }
}
