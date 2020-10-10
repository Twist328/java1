package ru.progwards.java1.lessons.bigints;
public abstract class AbsInteger {

    int num;

    public AbsInteger() {
    }
    public  int intValue() {
        return 0;
    }

    static AbsInteger add(AbsInteger num1, AbsInteger num2) {
        int a = num1.intValue();
        int b = num2.intValue();
        return new IntInteger((int)a+b);
    }
    public short shortValue(){
        return (short) 0;
    }

    public byte byteValue(){
        return (byte) 0;
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
