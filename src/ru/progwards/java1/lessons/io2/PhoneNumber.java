package ru.progwards.java1.lessons.io2;

import java.io.IOException;

public class PhoneNumber {
    public static String format(String phone) throws IOException {
        String numbers = phone.replaceAll("[^\\d]", "");
        int temp = numbers.length();
        if (temp > 11) {
            throw new RuntimeException("Проверьте количество цифр в телефонном номере");
        } else {
            if (temp < 10) {
                throw new RuntimeException("Проверьте количество цифр в телефонном номере");
            }
                return "+" + (numbers.charAt(0) == '8' ? "7" : numbers.substring(0, 1))
                        + "(" + numbers.substring(1, 4) + ")"
                        + numbers.substring(4, 7) + "-" + numbers.substring(7);
            }
        }

    public static void main(String[] args) throws IOException {
        System.out.println(format("8(999)111-22-33"));
        System.out.println(format("8 903 722 3788"));
    }

}

