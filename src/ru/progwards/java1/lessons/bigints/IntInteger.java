package ru.progwards.java1.lessons.bigints;

class IntInteger extends AbsInteger {
    int num;

    public IntInteger(int num) {
        super();
        this.num = num;
    }
    @Override
    public int intValue() {
        return num;
    }

    @Override
    public String toString() {
        return "" + num;
    }

    static AbsInteger add(AbsInteger num5, AbsInteger num6) {
        num5 = num5;
        num6 = num6;
        int a = num5.intValue();
        int b = num6.intValue();
        int result = (a+b);
        if (result <= -32768 & result <= 32767) {
        }
        return new IntInteger( result);

    }
}
