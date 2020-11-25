package Tvist328;

public class Test8 {
    void HighLow() {


        byte value = (byte)0;
        int result = (value & 1) & 0xFF;
    }

    public static void main(String[] args) {
        byte value = (byte) 3;
        int result = (value & 1) & 0xFF;
        System.out.println(result);


    }
}




















