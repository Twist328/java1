package ru.progwards.java1.lessons.bitsworld;


public class Binary {
    public static void main(String[] args) {
        Binary binary = new Binary((byte) -1);
        System.out.println(binary);

    }

    private byte num;

    public Binary(byte num) {
        this.num = num;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < 8; ++i) {

            byte b = ((byte) (num >>> i & 1));

            str = b + str;
        }
        return str;
    }
}