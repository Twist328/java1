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
        String[] arraySentence = sentence.split(" ");
        String temp = "";
        for (int i = 0; i < arraySentence.length; i++) {
            String str = "";
            for (char c : arraySentence[i].toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    str += c;
                }
            }
            str = str.toLowerCase();
            if (str.equals("")) {
                temp = temp + arraySentence[i] + " ";
            } else {
                for (int j = 0; j < inLang.length; j++) {
                    if (str.equals(inLang[j])) {
                        String next = "";
                        if (arraySentence[i].substring(0, 1).equals(arraySentence[i].substring(0, 1).toUpperCase())) {
                            next = outLang[j].substring(0, 1).toUpperCase() + outLang[j].substring(1);
                        } else {
                            next = outLang[j];
                        }
                        if (str.length() == arraySentence[i].length()) {
                            temp = temp + next + " ";
                        } else {
                            int substr = arraySentence[i].length() - (arraySentence[i].length() - str.length());
                            temp = temp + next + arraySentence[i].substring(substr) + " ";
                        }
                    }
                }
            }
        }
        temp = temp.trim();
        return temp;
    }

    public static void main(String[] args) {
        String[] inLang = {"fell", "is", "lost", "what", "locomotive", "scooter", "rushes", "grandma", "to", "saddled"};
        String[] outLang = {"упало", "то", "пропало", "что","локомотив" ,"самокат", "мчит","бабка","в", "оседлавши"};
        String sentence = "What fell - is lost!";
        String sentence1 = "Saddled scooter Grandma rushes to the locomotive";
        Translator translator = new Translator(inLang, outLang);
        System.out.println(translator.translate(sentence));
        System.out.println(translator.translate(sentence1));
    }
}

/*import java.util.Arrays;

public class Translator {
    private String[] inLang;
    private String[] outLang;


    Translator(String[] inLang, String[] outLang) {
        this.inLang = inLang;
        this.outLang = outLang;
    }

    public String translate(String sentence) {
        String[] arraySentense = sentence.split(" ");// split делит строку на слова с "".
        String in = " ";
        for (int i = 0; i < arraySentense.length; i++) {
            String str = " ";
            for (char c : arraySentense[i].toCharArray()) {
                if (Character.isAlphabetic(c)) {
                    str = str + c;

                }

            }

        }
    }
}*/