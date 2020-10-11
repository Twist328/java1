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
    public byte byteValue() {
        return (byte) num;
    }

    @Override
    public int intValue() {
        return (int) num;
    }

    @Override
    public String toString() {
        return "" + num;
    }

    static AbsInteger add(AbsInteger num3, AbsInteger num4) {
        num3 = num3;
        num4 = num4;
        int a = num3.shortValue();
        int b = num4.shortValue();
        int result = (a + b);

        if (result<(-128)|result <=(-32768)|result >127|result <=32767){
        }
        return new ShortInteger((short) result);
    }
}