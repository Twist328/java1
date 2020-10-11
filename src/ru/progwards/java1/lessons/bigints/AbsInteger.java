package ru.progwards.java1.lessons.bigints;

public abstract class AbsInteger {

    int num;

    public AbsInteger() {
    }

    public short shortValue() {
        return (short) num;
    }

    public byte byteValue() {
        return (byte) num;
    }

    public int intValue() {
        return num;
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        num1=num1;
        num2=num2;
        int a = num1.intValue();
        int b = num2.intValue();
        int result = (a + b);

        if (result > -128 & result <= 127) {
            return new ByteInteger((byte) result);
        } else if (result < -128 & result <= -32768 &result > 127 & result <= 32767){
            return new ShortInteger((short) result);
        } else if( result > 127 & result <= 32767) {
           return new ShortInteger((short) result);
        }else {
            return new IntInteger(result);
        }
    }
}

//length
// if(res<= -128|res<=127) {
//return new ByteInteger((byte) res);
//}else                                                       //for (int i = res; i > 127 ; i++) {
// if (res<= -128|res <=-32768|res >127|res <=32767){
// return new ShortInteger((short) res);
// }else
//return new IntInteger(res);
