package ru.progwards.java1.lessons.bigints;

class ByteInteger extends AbsInteger {
    byte num;

    public ByteInteger(byte num) {
        super();

        this.num = num;
    }
    public ByteInteger(short num) {
    }
    @Override
    public byte byteValue() {
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
        int a = num1.byteValue();
        int b = num2.byteValue();
        int result = (a + b);

        if (result >= (-128) | result <= 127) {
        }
            return new ByteInteger((byte) result);

    }
}
