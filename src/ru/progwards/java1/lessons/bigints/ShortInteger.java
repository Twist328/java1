package ru.progwards.java1.lessons.bigints;

class ShortInteger extends AbsInteger {
    short num;

    public ShortInteger(short num) {
        super();
        this.num = num;
    }

    @Override
    public short shortValue() {
        return super.shortValue();
    }

    @Override
    public byte byteValue() {
        return super.byteValue();
    }

    @Override
    public int intValue() {
        return super.intValue();
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
        int result = (a + b);

        if (result <= -128 & result >= -32768 & result > 127 & result <= 32767) {
        }
        return new ShortInteger((short) result);
    }
}
