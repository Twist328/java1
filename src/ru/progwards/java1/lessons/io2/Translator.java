package ru.progwards.java1.lessons.io2;

import java.util.Arrays;

public class Translator {
    private String[] inLang;
    private String[] outLang;

    Translator(String[] inLang, String[] outLang) {
        this.inLang = inLang;
        this.outLang = outLang;
    }

    public String translate(String sentence) {
        String[] arrSentence = sentence.split(" ");
        String temp = "";
        for (int i = 0; i < arrSentence.length; i++) {
            String str = "";
            for (char c : arrSentence[i].toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    str += c;
                }
            }
            str = str.toLowerCase();
            if (str.equals("")) {
                temp = temp + arrSentence[i] + " ";
            } else {
                for (int j = 0; j < inLang.length; j++) {
                    if (str.equals(inLang[j])) {
                        String next = "";
                        if (arrSentence[i].substring(0, 1).equals(arrSentence[i].substring(0, 1).toUpperCase())) {
                            next = outLang[j].substring(0, 1).toUpperCase() + outLang[j].substring(1);
                        } else {
                            next = outLang[j];
                        }
                        if (str.length() == arrSentence[i].length()) {
                            temp = temp + next + " ";
                        } else {
                            int substr = arrSentence[i].length() - (arrSentence[i].length() - str.length());
                            temp = temp + next + arrSentence[i].substring(substr) + " ";
                        }
                    }
                }
            }
        }
        temp = temp.trim();
        return temp;
    }

    public static void main(String[] args) {
        String[] inLang = {"what", "fell", "is", "lost"};
        String[] outLang = {"что", "упало", "то", "пропало"};
        String sentence = "What fell - is lost!";
        Translator translator = new Translator(inLang, outLang);
        System.out.println(translator.translate(sentence));
    }
}