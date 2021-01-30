package ru.progwards.java1.lessons.sets;

/*Создайте метод с сигнатурой public TreeSet<User> createSet() который
        создает и возвращает TreeSet так, что бы пользователи оказались упорядочены по убыванию id
    */

import java.util.*;

public class User {
    public Integer id;
    public String name;

    User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {

    }

    /*public User() {

    }*/

    public static TreeSet<User> createSet() {
        TreeSet<User> treeSet = new TreeSet<User>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return Integer.compare(o2.id, o1.id);//По УБЫВАНИЮ
            }
        });
        return treeSet;
    }

    public static void main(String[] args) {

        TreeSet<User> backsort = createSet();
        backsort.add(new User(1, "Вася"));
        backsort.add(new User(5, "Петя"));
        backsort.add(new User(2, "Коля"));
        backsort.add(new User(4, "Дима"));

        System.out.println(new TreeSet<User>(backsort));

    }

}


