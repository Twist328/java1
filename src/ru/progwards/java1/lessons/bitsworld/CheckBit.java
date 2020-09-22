package ru.progwards.java1.lessons.bitsworld;

public class CheckBit {

    public static int checkBit(byte value, int bitNumber) {
        return   (value>>bitNumber) & 1;

        }


    public static void main(String[] args) {

        System.out.println(checkBit((byte) 52, 0));
    }
}

//for (int i =0; i < 8; i++) {
//bitNumber = (value >> 5 & (i&1) & 0xFF) ;

// int num = 1;
//  int temp = bitNumber;
//    while (bitNumber != 0 && num <= value) {
//              if (temp % 2 == 1 && num == value)
//               return 0;
//              else {
//              temp = temp /2 & 1;
//         num++;
//             }
//              }
//            return 1;