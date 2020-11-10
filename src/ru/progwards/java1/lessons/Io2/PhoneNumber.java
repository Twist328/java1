package ru.progwards.java1.lessons.Io2;

import java.io.IOException;

public class PhoneNumber {
public static String format(String phone) throws IOException {
        String numbers = phone.replaceAll("[^\\d]", "");
        int temp = numbers.length();
        if(temp > 11 && temp < 10) {
        throw new IOException("В номере телефон должно быть 10 или 11 цифр!");
        }

        return "+" + (numbers.charAt(0)=='8' ? "7" : numbers.substring(0,1))
        + "(" + numbers.substring(1,4) + ")"
        + numbers.substring(4,7) + "-" + numbers.substring(7);
        }

public static void main(String[] args) throws IOException {
        System.out.println(format("7(999)111-22-33"));
        System.out.println(format("7 470 717 193"));
        }

        }
