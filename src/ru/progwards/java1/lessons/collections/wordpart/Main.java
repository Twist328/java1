package ru.progwards.java1.lessons.collections.wordpart;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) { //итерация частей слова по выбору корень, суффикс, приставка, окончание
        Root root = new Root("беж");
        Prefix prefix = new Prefix("пере");
        Suffix suffix = new Suffix("к");
        Ending ending = new Ending("a");

        Word word = new Word(root, prefix, suffix, ending);

        Iterator wordIterator = word.iterator();
        while (wordIterator.hasNext()) {
            WordPart part = (WordPart) wordIterator.next();
            System.out.println( part.getWordPart());
        }
    }
}

